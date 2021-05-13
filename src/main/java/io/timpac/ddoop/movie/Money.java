package io.timpac.ddoop.movie;

import java.math.BigDecimal;

public class Money {
	public static Money ZERO = Money.wons(0);
	
	private BigDecimal amount;
	
	private Money(BigDecimal amount) {
		this.amount = amount;
	}
	
	public static Money wons(long amount) {
		return new Money(BigDecimal.valueOf(amount));
	}
	
	public static Money wons(double amount) {
		return new Money(BigDecimal.valueOf(amount));
	}

	public BigDecimal getAmount() {
		return amount;
	}
	
	public Money add(Money money) {
		return new Money(this.amount.add(money.amount));
	}
	
	public Money add(long amount) {
		return new Money(this.amount.add(BigDecimal.valueOf(amount)));
	}
	
	public Money subtract(Money money) {
		return new Money(this.amount.subtract(money.amount));
	}
	
	public Money subtract(long amount) {
		return new Money(this.amount.subtract(BigDecimal.valueOf(amount)));
	}
	
	public Money Multiply(Money money) {
		return new Money(this.amount.multiply(money.amount));
	}
	
	public Money Multiply(double amount) {
		return new Money(this.amount.multiply(BigDecimal.valueOf(amount)));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (amount.intValue() != other.amount.intValue())
			return false;
		return true;
	}
	
	
}
