package com.sibisoft.tddPractical;

public class Sum implements Expression{

	private Money augend;
	private Money addend;
	
	public Money getAugend() {
		return augend;
	}
	public void setAugend(Money augend) {
		this.augend = augend;
	}
	public Money getAddend() {
		return addend;
	}
	public void setAddend(Money addend) {
		this.addend = addend;
	}
	
	public Sum(Money augend, Money addend){
		
	}
	/*@Override
	public Money getResult(Money money1, Money money2) {
		return money1.sum(money2);
		
	}*/
}
