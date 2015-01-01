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
		
		assertFalse(Money.franc(10).equals(Money.dollar(10)));
	}
	
	@Test
	public void testCurrency()  {
		assertEquals("USD",Money.dollar(20).getCurrency());
		assertEquals("CHF",Money.franc(50).getCurrency());
	}
	
}
