package Ex1Testing;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Ex1.Monom;

class MonomTest {
	Monom m;
	Monom m0;
	
	@BeforeEach
	void init() {
	m = new Monom();
	m0 = new Monom();
	}
	
	@Test
	void fTest() {
		m = new Monom("2x^3");
		
		int expected = 0;
		double actual = (m.f(0));
		assertEquals(expected, actual, "this is not answer");

		double f = 0 ;
		f = m.f(0);
		assertTrue(f == 2*(Math.pow(0, 3)));	
	}
	
	@Test
	void equalesTest() {
		m = new Monom("2x^3");
		m0 = new Monom("2x^3");
		
		m.equals(m);
		try {
			m.equals(m0);
			
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	@Test
	void addTest() {
		m = new Monom(2,3); //2x^3
		m0 = new Monom(4,3);
		Monom ans =new Monom(6,3);
		
	
		//String ans = "6x^3";
		m0.add(m);
	
		//assertEquals(ans, m.add(m0));
		    
	  // assertEquals(new Monom("6x^4"), m2);
	//   assertSame(m, m0);
//		String expected = "6x^4";
//		String actual = (m0.add(m));
//		assertEquals(expected, actual, "this is not answer");
	}
	
	@Test
	void multipyTest() {
		m = new Monom("2x^3");
		m0 = new Monom("2x^5");
		
		m.multipy(m0);
		
	}
	
	@Test
	void derivativeTest() {
//		m = new Monom("2x^3");
//		m0 = new Monom("6x^2");
//		assertEquals(m0, m.derivative());
		
		m = new Monom(2,3);
		m0 = new Monom(6,2);
		assertTrue(m0 == m.derivative());
	}

	@Test
	public void consTest() {
		m=new Monom(3,4);
		assertTrue(3==m.get_coefficient());
		assertTrue(4==m.get_power());
		
		m0=new Monom("3x^4");
		assertTrue(3==m.get_coefficient());
		assertTrue(4==m.get_power());
		
	}
	//assertEquals(1, function.numDividers(25));

}
