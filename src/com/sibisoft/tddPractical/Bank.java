package com.sibisoft.tddPractical;

public class Bank {

	public Money reduce(Expression source, String toCurrency){
		/*if(source instanceof Money){
			return source.reduce(toCurrency);
		}
		Sum sum = (Sum) source;
		return sum.reduce(toCurrency);
		*/
		return source.reduce(toCurrency);
	}
}
