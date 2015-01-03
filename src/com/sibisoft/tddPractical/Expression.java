package com.sibisoft.tddPractical;

public interface Expression {

	public Money reduce(Bank bank,String toCurrency);
	public Expression plus(Expression addend);
	public Expression times(int multiplier);
}
