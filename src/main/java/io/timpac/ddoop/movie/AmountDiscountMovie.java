package io.timpac.ddoop.movie;

import java.time.Duration;

public class AmountDiscountMovie extends Movie {
	private Money discountAmount;
	
	public AmountDiscountMovie(String title, Duration runningTime, Money fee, Money discountAmount, DiscountCondition ...conditions) {
		super(title, runningTime, fee, conditions);
		this.discountAmount = discountAmount;
	}

	@Override
	public Money getDiscountAmount(Screening screening) {
		return discountAmount;
	}
}
