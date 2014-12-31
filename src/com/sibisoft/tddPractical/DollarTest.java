package com.sibisoft.tddPractical;

import static org.junit.Assert.*;

import org.junit.Test;

public class DollarTest {

	@Test
	public void testMultiplication()  {
		Dollar ten = new Dollar(10);
		assertEquals(new Dollar(20),ten.times(2));
		assertEquals(new Dollar(50),ten.times(5));
		
	}
	
	@Test
	public void testEquality(){
		assertTrue(new Dollar(10).equals(new Dollar(10)));
		assertFalse(new Dollar(10).equals(new Dollar(20)));
		
		assertTrue(new Franc(10).equals(new Franc(10)));
		assertFalse(new Franc(10).equals(new Franc(20)));
		
		assertFalse(new Franc(10).equals(new Dollar(10)));
	}
	
	@Test
	public void testFrancMultiplication()  {
		Franc ten = new Franc(10);
		assertEquals(new Franc(20),ten.times(2));
		assertEquals(new Franc(50),ten.times(5));
		
	}
}
