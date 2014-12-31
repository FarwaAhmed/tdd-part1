package com.sibisoft.tddPractical;

import static org.junit.Assert.*;

import org.junit.Test;

public class DollarTest {

	@Test
	public void testMultiplication() {
		Dollar ten = new Dollar(10);
		Dollar product = ten.times(2);
		assertEquals(20,product.amount);
		product = ten.times(5);
		assertEquals(50,product.amount);
		
	}
	
	@Test
	public void testEquality(){
		assertTrue(new Dollar(10).equals(new Dollar(10)));
		assertFalse(new Dollar(10).equals(new Dollar(20)));
	}

}
