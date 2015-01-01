package com.sibisoft.tddPractical;

public class Money {

	/* Instance Variables*/
	protected int amount;
	protected String currency;
	
	/* getters/setters*/
	public String getCurrency() {
		return currency;
	}
	public int getAmount(){
		return amount;
	}
	
	/* Constructors*/
	public Money(int amount, String currency){
		this.amount = amount;
		this.currency = currency;
	}
	
	
	/* Factory Methods*/
	static Money dollar(int amount){
		return new Money(amount,"USD");
	}
	static Money franc(int amount){
		return new Money(amount,"CHF");
	}
	
	/* Method to ensure equality*/
	public boolean equals(Object obj){
		Money moneyObj = (Money) obj;
		return (amount == moneyObj.amount &&
				this.getCurrency().equals(moneyObj.getCurrency()));
	}
	
	/* Arithmetic operations*/
	public Money times(int multiplier){
		return new Money(getAmount() * multiplier,getCurrency());
	}
	
	/* For Debugging*/
	public String toString(){
		return "amount="+getAmount()+" currency="+getCurrency();
	}
	
}
