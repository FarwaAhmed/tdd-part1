package com.sibisoft.tddPractical;

import static org.junit.Assert.*;

import org.junit.Test;

public class DollarTest {

	@Test(expected = ClassCastException.class)
	public void testPlusReturnsSum(){
		//plus should return sum instead of Money 
		
		Money two = Money.dollar(2);
		Expression resultInTermsOfMoney = two.plus(two);
		
		Sum sum = (Sum) resultInTermsOfMoney; // ClassCastException because plus is returning Money insteadd of sum
		assertEquals(two, sum.getAugend());
		assertEquals(two, sum.getAddend());
	}
	
	@Test
	public void testSimpleAddition(){
		//Expression = 2$ + 2CHF; at rate 2:1 2chf= 1$ ; means result should be 3$;
		
		Money two = Money.dollar(2);
		Expression expression = two.plus(two);
		Bank bank = new Bank();
		
		// In bank: apply exchange rates to result returned by expression
		Money reducedMoney = bank.reduce(expression,"USD");
		
		assertEquals(Money.dollar(4), reducedMoney);
	}
	/*@Test
	public void testSimpleAdditionForDifferentCurrencies(){
		//Applying triangulation strategy
		
		//returns true - because of currency that returns
		Money sum = Money.dollar(5).sum(Money.franc(5));
		assertEquals(Money.dollar(10), sum);
		
		//returns false - because of currency that returns
		Money sum2 = Money.franc(5).sum(Money.dollar(5));
		assertNotEquals(Money.dollar(10), sum2);
	}
	
	@Test
	public void testSimpleAdditionForSameCurrency(){
		Money sum = Money.dollar(5).sum(Money.dollar(5));
		assertEquals(Money.dollar(10), sum);
	}*/
	
	@Test
	public void testCurrency()  {
		assertEquals("USD",Money.dollar(20).getCurrency());
		assertEquals("CHF",Money.franc(50).getCurrency());
	}
	
	@Test
	public void testEquality(){
		assertTrue(Money.dollar(10).equals(Money.dollar(10)));
		assertFalse(Money.dollar(10).equals(Money.dollar(20)));
		
		assertFalse(Money.franc(10).equals(Money.dollar(10)));
	}
	
	@Test
	public void testMultiplication()  {
		Money ten = Money.dollar(10);
		assertEquals(Money.dollar(20),ten.times(2));
		assertEquals(Money.dollar(50),ten.times(5));
	}
	
}
