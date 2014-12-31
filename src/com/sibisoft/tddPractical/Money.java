package com.sibisoft.tddPractical;

public abstract class Money {

	protected int amount;
	protected String currency;
	
	public Money(int amount, String currency){
		this.amount = amount;
		this.currency = currency;
	}
	
	public boolean equals(Object obj){
		Money moneyObj = (Money) obj;
		return (amount == moneyObj.amount &&
				this.getClass().equals(moneyObj.getClass()));
	}
	
	static Money dollar(int amount){
		return new Dollar(amount,"USD");
	}
	static Money franc(int amount){
		return new Franc(amount,"CHF");
	}
	
	public abstract Money times(int multiplier);
	public String currency() {
		return currency;
	}
}
