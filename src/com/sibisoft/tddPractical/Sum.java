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
		this.augend = augend;
		this.addend = addend;
	}
	
	@Override
	public Money reduce(String toCurrency){
		int amount = this.getAugend().getAmount() + this.getAddend().getAmount();
		return new Money(amount,toCurrency);
	}
	
}
