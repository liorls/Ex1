package Ex1Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Ex1.Monom;
import Ex1.Polynom;

class PolynomTest {
	Polynom p;
	Polynom p0;

	@BeforeEach
	void init() {
		p = new Polynom();
		p0 = new Polynom();
	}

	@Test
	void fTest() {
		p = new Polynom("2x^3+5x+6");
		int expected = 6;
		double actual = (p.f(0));
		assertEquals(expected, actual, "this is not answer");

	}
	@Test
	void copyTest() {
		p=new Polynom("2x^4-7x^3+3x^2-6");
		p0=(Polynom) p.copy();

//		assertEquals(p, p0);
//		assertNotSame(p, p0);	
	}
	@Test
	public void areaTest() {

		p=new Polynom("2x^4-7x^3+3x^2-6");
		p.area(0, 10, 0.000001)	;
		double eps=0.000001;
		
		//assertTrue(23440-p.area(0, 10, 0.000001)<eps);
	}
	@Test
	public void initFromStringTest() {
		
		Polynom p=new Polynom("2x^4-7x^3+3x^2-6");
		Polynom p2=new Polynom();
		p2.add(new Monom(2,4));
		p2.add(new Monom(-7,3));
		p2.add(new Monom(3,2));
		p2.add(new Monom(-6,0));
		assertEquals(p2, p);
	}
	@Test
	public void substractTest() {
		
		p=new Polynom("2x^4-7x^36");
		p0=new Polynom("2x^4-7x^36-6x");
		p.substract(p0);
		assertEquals(new Polynom("6x"), p);
		assertNotSame(new Polynom("6x"), p);
	}
   
	@Test
	public void rootTest() {
		
		p=new Polynom("2x^3-7x^2+3x-2");
		p0=new Polynom("2x^4-7x^36-6x");
		double d=p.root(2, 300, 0.003);
		
		assertTrue(3.12214-d<0.003);
	}

	


}
