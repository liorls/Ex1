package Ex1;

import java.util.Comparator;

/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and b is an integer
 * The class implements function,
 * and support simple operations as: construction, value at x, derivative, add and multiply.
 *
 * @author Boaz
 */

public class Monom implements function
{
    public static final Monom ZERO = new Monom(0, 0);
    public static final Monom MINUS1 = new Monom(-1, 0);
    public static final double EPSILON = 0.0000001;
    public static final int NOT_FOUND = -1;

    public static final Comparator<Monom> _Comp = new Monom_Comperator();

    public static Comparator<Monom> getComp()
    {
        return _Comp;
    }

    public Monom(double a, int b)
    {
        this.set_coefficient(a);
        this.set_power(b);
    }

    public Monom(Monom ot)
    {
        this(ot.get_coefficient(), ot.get_power());
    }

    /* getters */
    public double get_coefficient()
    {
        return this._coefficient;
    }

    public int get_power()
    {
        return this._power;
    }

    /**
     * this method returns the derivative monom of this.
     *
     * @return
     */
    public Monom derivative()
    {
        if (this.get_power() == 0)
        {
            return getNewZeroMonom();
        }
        return new Monom(this.get_coefficient() * this.get_power(), this.get_power() - 1);
    }

    public double f(double x)
    {
        double ans = 0;
        double p = this.get_power();
        ans = this.get_coefficient() * Math.pow(x, p);
        return ans;
    }

    public boolean isZero()
    {
        return this.get_coefficient() == 0;
    }

    public boolean equals(Monom other)
    {
        double diff = Math.max(_coefficient - other._coefficient, other._coefficient - _coefficient);
        return (diff < EPSILON) && (_power == other._power);
    }

    public Monom(String s)
    {
		this._coefficient = 0;
		this._power = 0;

     	if(!s.isEmpty())
        {
            boolean isMinus = false;
            if(s.charAt(0) == '-')
            {
                isMinus = true;
                /* omit minus sign */
                s = s.substring(1);
            }

            /* search for x or X in the Monom */
            int indexOfX = Math.max(s.indexOf("x"), s.indexOf("X"));
            if (indexOfX == NOT_FOUND)
            {
                this._coefficient = Double.parseDouble(s);
            }
            else
            {
                this._power = 1;
                /* split into coffStr and powStr */
                String coffStr = s.substring(0, indexOfX);
                String powStr = s.substring(indexOfX + 1);
                /* determine cofficient */
                this._coefficient = coffStr.isEmpty() ? 1 : Double.parseDouble(coffStr);

                /* determine power */
                if(!powStr.isEmpty())
                {
                    if (powStr.charAt(0) == '^')
                    {
                        powStr = powStr.substring(1);
                    }
                    this._power = Integer.parseInt(powStr);
                }
            }

            if(isMinus)
            {
                this._coefficient *= -1;
            }
        }
    }

	public void add(Monom m)
    {
		if (this.get_power() != m.get_power())
		{
			throw new RuntimeException("ERR cannot add monoms of different power");
		}
		this._coefficient += m._coefficient;
    }

    public void multipy(Monom d)
    {
		this._power += d._power;
		this._coefficient *= d._coefficient;
    }

    public String toString()
	{
		if (this._coefficient == 0)
		{
			return "0";
		}

        String ans = "";
        ans += this._coefficient;

        if(this._power != 0)
		{
			ans += (this._power == 1) ? "x" : ("x^" + this._power);
		}

        return ans;
    }

    //****************** Private Methods and Data *****************

	/* setters */
    void set_coefficient(double a)
    {
        this._coefficient = a;
    }

    private void set_power(int p)
    {
        if (p < 0)
        {
            throw new RuntimeException("ERR the power of Monom should not be negative, got: " + p);
        }
        this._power = p;
    }

    private static Monom getNewZeroMonom()
    {
        return new Monom(ZERO);
    }

    /* base fields */
    private double _coefficient;
    private int _power;
    
    public Monom() {
   	}

	@Override
	public function initFromString(String s) {
		Monom ans = new Monom(s);
		return ans;
	}

	@Override
	public function copy() {
		Monom copy = new Monom(this.toString());
		return copy;
	}
}
