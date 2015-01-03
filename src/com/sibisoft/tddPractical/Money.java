package com.sibisoft.tddPractical;

public class Money implements Expression {

	/* Instance Variables */
	protected int amount;
	protected String currency;

	/* getters/setters */
	public String getCurrency() {
		return currency;
	}

	public int getAmount() {
		return amount;
	}

	/* Constructors */
	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	/* Factory Methods */
	static Money dollar(int amount) {
		return new Money(amount, "USD");
	}

	static Money franc(int amount) {
		return new Money(amount, "CHF");
	}

	/* Method to ensure equality */
	public boolean equals(Object obj) {
		Money moneyObj = (Money) obj;
		return (amount == moneyObj.amount && this.getCurrency().equals(moneyObj.getCurrency()));
	}

	/* Arithmetic operations */
	@Override
	public Expression times(int multiplier) {
		return new Money(getAmount() * multiplier, getCurrency());
	}

	/*
	 * public Money sum(Money addend) { 
	 * 	return new Money(getAmount() + addend.getAmount(),getCurrency()); 
	 * }
	 */
	
	/* overridden methods */
	@Override
	public Money reduce(Bank bank, String toCurrency) {
		int rate = bank.rate(this.getCurrency(), toCurrency);
		return new Money(amount / rate, toCurrency);
	}
	
	@Override
	public Expression plus(Expression addend) {
		return new Sum(this, addend);
	}

	/* For Debugging */
	public String toString() {
		return "amount=" + getAmount() + " currency=" + getCurrency();
	}

}
