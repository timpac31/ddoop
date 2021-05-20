package io.timpac.ddoop.call;

import io.timpac.ddoop.movie.Money;

public class DiscountableRatePolicy extends AdditionalRatePolicy {
	private Money discountAmount;

	public DiscountableRatePolicy(Money discountAmount, RatePolicy next) {
		super(next);
		this.discountAmount = discountAmount;
	}

	@Override
	protected Money afterCalculated(Money fee) {
		return fee.subtract(discountAmount);
	}

}
