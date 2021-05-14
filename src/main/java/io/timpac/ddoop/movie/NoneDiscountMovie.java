package io.timpac.ddoop.movie;

import java.time.Duration;

public class NoneDiscountMovie extends Movie {

	public NoneDiscountMovie(String title, Duration runningTime, Money fee, DiscountCondition ...conditions) {
		super(title, runningTime, fee, conditions);
	}

	@Override
	protected Money getDiscountAmount(Screening screening) {
		return Money.ZERO;
	}

}
