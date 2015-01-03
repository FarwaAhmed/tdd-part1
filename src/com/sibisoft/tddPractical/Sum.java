package com.sibisoft.tddPractical;

public class Sum implements Expression {

	private Expression augend;
	private Expression addend;

	public Expression getAugend() {
		return augend;
	}

	public void setAugend(Expression augend) {
		this.augend = augend;
	}

	public Expression getAddend() {
		return addend;
	}

	public void setAddend(Expression addend) {
		this.addend = addend;
	}

	public Sum(Expression augend, Expression addend) {
		this.augend = augend;
		this.addend = addend;
	}

	@Override
	public Money reduce(Bank bank, String toCurrency) {
		int amount = this.getAugend().reduce(bank, toCurrency).getAmount()
				+ this.getAddend().reduce(bank, toCurrency).getAmount();
		return new Money(amount, toCurrency);
	}

	@Override
	public Expression plus(Expression addend) {
		return new Sum(this, addend);
	}
	
	@Override
	public Expression times(int multiplier) {
		// (2 + 3) * 7 = 2*7 + 3*7
		return new Sum(this.getAugend().times(multiplier), this.getAddend().times(multiplier));
	}

}
