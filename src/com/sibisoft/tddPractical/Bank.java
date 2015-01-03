package com.sibisoft.tddPractical;

import java.util.Hashtable;

public class Bank {

	private Hashtable rates = new Hashtable();

	public void addRate(String fromCurrency, String toCurrency, int rate) {
		rates.put(new Pair(fromCurrency, toCurrency), new Integer(rate));
	}

	public int rate(String fromCurrency, String toCurrency) {
		if (fromCurrency.equals(toCurrency)) {
			return 1;
		}
		Integer rate = (Integer) rates.get(new Pair(fromCurrency, toCurrency));
		return rate.intValue();
	}

	public Money reduce(Expression source, String toCurrency) {
		/*
		 * if(source instanceof Money){ return source.reduce(toCurrency); } 
		 * Sum sum = (Sum) source; 
		 * return sum.reduce(toCurrency);
		 */
		return source.reduce(this, toCurrency);
	}

}
