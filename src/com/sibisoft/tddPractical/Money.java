package com.sibisoft.tddPractical;

public class Money {

	protected int amount;
	protected String currency;
	
	public Money(int amount, String currency){
		this.amount = amount;
		this.currency = currency;
	}
	
	public boolean equals(Object obj){
		Money moneyObj = (Money) obj;
		return (amount == moneyObj.amount &&
				this.currency.equals(moneyObj.currency));
	}
	
	static Money dollar(int amount){
		return new Dollar(amount,"USD");
	}
	static Money franc(int amount){
		return new Franc(amount,"CHF");
	}
	
	public Money times(int multiplier){
		return new Money(amount * multiplier,currency);
	}
	public String currency() {
		return currency;
	}
	public String toString(){
		return "amount="+amount+" currency="+currency;
	}
	
}
