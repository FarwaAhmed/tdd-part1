package com.sibisoft.tddPractical;

public class Dollar {

	private int amount;
	
	public Dollar(int amount){
		this.amount = amount;
	}
	public Dollar times(int multiplier){
		return new Dollar(amount * multiplier );
	}
	public boolean equals(Object obj){
		Dollar dollarObj = (Dollar) obj;
		return amount == dollarObj.amount;
	}
}