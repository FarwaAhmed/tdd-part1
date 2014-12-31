package com.sibisoft.tddPractical;

public class Money {

	protected int amount;
	
	public boolean equals(Object obj){
		Money moneyObj = (Money) obj;
		return (amount == moneyObj.amount &&
				this.getClass().equals(moneyObj.getClass()));
	}
}
