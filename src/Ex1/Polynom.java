package Ex1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

import Ex1.Monom;

import java.util.ArrayList; // import the ArrayList class

/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 *
 * @author Boaz
 */
public class Polynom implements Polynom_able{

	/**
	 * Zero (empty polynom)
	 */
	public Polynom()
	{
		
	}

	/**
	 * init a Polynom from a String such as:
	 * {"x", "3+1.4X^3-34x", "(2x^2-4)*(-1.2x-7.1)", "(3-3.4x+1)*((3.1x-1.2)-(3X^2-3.1))"};
	 *
	 * @param s: is a string represents a Polynom
	 */
	public Polynom(String s)
	{
		s = s.replace("-", "+-");

		String[] strExps = s.split("\\+");
		for (String exp : strExps)
		{
			expression.add(new Monom(exp));
		}
	}

	public String toString()
	{
		StringBuilder ans = new StringBuilder();
		for (Monom m : expression)
		{
			ans.append(m);
			ans.append("+");
		}

		String toReturn = ans.substring(0, ans.length() - 1).toString();
		toReturn = toReturn.replace("+-", "-");
		return toReturn;
	}

	@Override
	public double f(double x)
	{
		double totalSum = 0;
		for (Monom m : expression)
		{
			totalSum += m.f(x);
		}
		return totalSum;
	}

	@Override
	public void add(Polynom_able p1)
	{

		Iterator<Monom> otherIterator = p1.iteretor();
		boolean isFound;
		while (otherIterator.hasNext())
		{
			Monom current = otherIterator.next();
			/* redirect to the other func (add Monom to Polynom) */
			add(current);
		}
	}

	@Override
	public void add(Monom m1)
	{
		Iterator<Monom> iterator = this.iteretor();
		boolean found = false;
		while (iterator.hasNext())
		{
			Monom temp = iterator.next();
			/* in case shall add to an existing member */
			if (temp.get_power() == m1.get_power())
			{
				temp.add(m1);
				found = true;
			}
		}
		/* if there is no current i in which x^i exist */
		if (!found)
		{
			expression.add(m1);
		}
	}

	@Override
	public void substract(Polynom_able p1)
	{
		Polynom_able p2 = p1.copy();
		Iterator<Monom> otherIterator = p2.iteretor();
		while (otherIterator.hasNext())
		{
			Monom current = otherIterator.next();
			current.multipy(Monom.MINUS1);
		}
		/* add normally, after multiply the entire monom with minus one */
		add(p2);
	}

	@Override
	public Polynom_able copy()
	{
		Polynom copy = new Polynom();
		for (Monom m : expression)
		{
			Monom m1 = new Monom(m);
			copy.expression.add(m1);
		}
		return copy;
	}

	@Override
	public void multiply(Monom m1)
	{
		for (Monom m : expression)
		{
			m.multipy(m1);
		}
	}

	@Override
	public void multiply(Polynom_able p1)
	{
		Iterator<Monom> otherIterator = p1.iteretor();
		while (otherIterator.hasNext())
		{
			Monom current = otherIterator.next();
			this.multiply(current);
		}
	}

	
	public boolean equals(Polynom_able p1)
	{
		Iterator<Monom> thisIterator = iteretor();
		Iterator<Monom> otherIterator = p1.iteretor();
		while(thisIterator.hasNext() && otherIterator.hasNext())
		{
			Monom current1 = thisIterator.next();
			Monom current2 = otherIterator.next();
			if(!current1.equals(current2))
			{
				return false;
			}
		}
		/* return true iff both iterators are end iterators */
		return !thisIterator.hasNext() && !otherIterator.hasNext();
	}

	@Override
	public boolean isZero()
	{
		return (this.equals(new Polynom()));
	}

	@Override
	public double root(double x0, double x1, double eps)
	{
		if (f(x0) * f(x1) <= 0) {
			double mid_x = (x1 + x0) / 2;
			if (Math.abs(f(mid_x)) < eps) {
				return mid_x;
			}
			if (f(x0) == 0) {
				return x0;
			}
			if (f(x1) == 0) {
				return x1;
			}
			if (f(mid_x) < 0) {
				x0 = mid_x;
			} else if (f(mid_x) > 0) {
				x1 = mid_x;
			}
		}
		else {
			throw new IllegalArgumentException("Illegal, error");
		}
		return root(x0, x1, eps);
	}

	@Override
	public Polynom_able derivative()
	{
		for (int i = 0; i < expression.size(); i++)
		{
			expression.set(i, expression.get(i).derivative());
		}
		return this;
	}

	@Override
	public double area(double x0, double x1, double eps)
	{
		double totalArea = 0, currentX = x0, currentArea;
		int numOfSteps = (int) ((x1 - x0) / eps);

		for(int i = 0; i < numOfSteps; i++)
		{
			/* Riman's integral from x0 to x1 in eps steps. chose arbitrary the middle in each segment*/
			currentArea = (Math.abs(f(currentX + eps) + f(currentX)) / 2) * eps;
			totalArea += currentArea;
			currentX += eps;
		}
		return totalArea;
	}

	@Override
	public Iterator<Monom> iteretor()
	{
		return expression.iterator();
	}



	public ArrayList<Monom> expression = new ArrayList<Monom>();



	@Override
	public function initFromString(String s) {
		// TODO Auto-generated method stub
		return null;
	}
}
