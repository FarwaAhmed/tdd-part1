package com.sibisoft.tddPractical;

import static org.junit.Assert.*;

import org.junit.Test;

public class DollarTest {

	@Test
	public void testMixedAddition() {
		// 5$ + 10 CHF = 10$ when rate is 2 : 1
		Money fiveBucks = Money.dollar(5);
		Money tenFrancs = Money.franc(10);
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Money reducedMoney = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
		assertEquals(Money.dollar(10), reducedMoney);
	}
	
	@Test
	public void testIdentityRate() {

		assertEquals(1, new Bank().rate("USD", "USD"));
	}

	@Test
	public void testArrayEquals() {

		assertArrayEquals(new Object[] { "ABC" }, new Object[] { "ABC" });
	}

	@Test
	public void testReduceMoneyDifferentCurrency() {

		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Money reducedMoney = bank.reduce(Money.franc(2), "USD");
		assertEquals(Money.dollar(1), reducedMoney);
	}

	@Test
	public void testReduceMoney() {

		Bank bank = new Bank();
		Money reducedMoney = bank.reduce(Money.dollar(3), "USD");
		assertEquals(Money.dollar(3), reducedMoney);
	}

	@Test
	public void testReduceSum() {

		Expression sum = new Sum(Money.dollar(2), Money.dollar(2));
		Bank bank = new Bank();
		Money reducedMoney = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(4), reducedMoney);
	}

	@Test
	public void testPlusReturnsSum() {
		// plus should return sum instead of Money

		Money two = Money.dollar(2);
		Expression resultInTermsOfMoney = two.plus(two);

		Sum sum = (Sum) resultInTermsOfMoney; // expected = ClassCastException
												// if plus is returns Money
												// instead of Sum
		assertEquals(two, sum.getAugend());
		assertEquals(two, sum.getAddend());
	}

	@Test
	public void testSimpleAddition() {
		// Expression = 2$ + 2CHF; at rate 2:1 2chf= 1$ ; means result should be 3$;

		Money two = Money.dollar(2);
		Expression expression = two.plus(two);
		Bank bank = new Bank();

		// In bank: apply exchange rates to result returned by expression
		Money reducedMoney = bank.reduce(expression, "USD");

		assertEquals(Money.dollar(4), reducedMoney);
	}

	/*
	 * @Test 
	 * public void testSimpleAdditionForDifferentCurrencies(){ 
	 * 	//Applying triangulation strategy
	 * 
	 * 	//returns true - because of currency that returns Money sum =
	 * 	Money.dollar(5).sum(Money.franc(5)); 
	 * 	assertEquals(Money.dollar(10), sum);
	 * 
	 * 	//returns false - because of currency that returns Money sum2 =
	 * 	Money.franc(5).sum(Money.dollar(5)); 
	 * 	assertNotEquals(Money.dollar(10), sum2); 
	 * }
	 * 
	 * @Test 
	 * public void testSimpleAdditionForSameCurrency(){ 
	 * 	Money sum = Money.dollar(5).sum(Money.dollar(5)); 
	 * 	assertEquals(Money.dollar(10), sum); 
	 * }
	 */

	@Test
	public void testCurrency() {
		assertEquals("USD", Money.dollar(20).getCurrency());
		assertEquals("CHF", Money.franc(50).getCurrency());
	}

	@Test
	public void testEquality() {
		assertTrue(Money.dollar(10).equals(Money.dollar(10)));
		assertFalse(Money.dollar(10).equals(Money.dollar(20)));

		assertFalse(Money.franc(10).equals(Money.dollar(10)));
	}

	@Test
	public void testMultiplication() {
		Money ten = Money.dollar(10);
		assertEquals(Money.dollar(20), ten.times(2));
		assertEquals(Money.dollar(50), ten.times(5));
	}

}
