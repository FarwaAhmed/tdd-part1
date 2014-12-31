package com.sibisoft.tddPractical;

public abstract class Money {

	protected int amount;
	protected String currency;
	
	public boolean equals(Object obj){
		Money moneyObj = (Money) obj;
		return (amount == moneyObj.amount &&
				this.getClass().equals(moneyObj.getClass()));
	}
	
	static Money dollar(int amount){
		return new Dollar(amount);
	}
	static Money franc(int amount){
		return new Franc(amount);
	}
	
	public abstract Money times(int multiplier);
	public String currency() {
		return currency;
	}
}
