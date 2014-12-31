package com.sibisoft.tddPractical;

public class Franc {
	private int amount;
	public Franc(int amount){
		this.amount = amount;
	}
	public Franc times(int multiplier){
		return new Franc(amount * multiplier );
	}
	public boolean equals(Object obj){
		Franc dollarObj = (Franc) obj;
		return amount == dollarObj.amount;
	}
}
