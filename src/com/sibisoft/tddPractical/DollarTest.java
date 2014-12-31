package com.sibisoft.tddPractical;

import static org.junit.Assert.*;

import org.junit.Test;

public class DollarTest {

	@Test
	public void testMultiplication()  {
		Money ten = Money.dollar(10);
		assertEquals(Money.dollar(20),ten.times(2));
		assertEquals(Money.dollar(50),ten.times(5));
		
	}
	
	@Test
	public void testEquality(){
		assertTrue(Money.dollar(10).equals(Money.dollar(10)));
		assertFalse(Money.dollar(10).equals(Money.dollar(20)));
		
		assertTrue(Money.franc(10).equals(Money.franc(10)));
		assertFalse(Money.franc(10).equals(Money.franc(20)));
		
		assertFalse(Money.franc(10).equals(Money.dollar(10)));
	}
	
	@Test
	public void testFrancMultiplication()  {
		Money ten = Money.franc(10);
		assertEquals(Money.franc(20),ten.times(2));
		assertEquals(Money.franc(50),ten.times(5));
		
	}
	
	@Test
	public void testCurrency()  {
		assertEquals("USD",Money.dollar(20).currency());
		assertEquals("CHF",Money.franc(50).currency());
	}
	
}
