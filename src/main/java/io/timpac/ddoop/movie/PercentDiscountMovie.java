package io.timpac.ddoop.movie;

import java.time.Duration;

public class PercentDiscountMovie extends Movie {
	private double discountPercent;

	public PercentDiscountMovie(String title, Duration runningTime, Money fee, double discountPercent, DiscountCondition ...conditions) {
		super(title, runningTime, fee, conditions);
		this.discountPercent = discountPercent;
	}

	@Override
	protected Money getDiscountAmount(Screening screening) {
		return getFee().Multiply(discountPercent);
	}

}
