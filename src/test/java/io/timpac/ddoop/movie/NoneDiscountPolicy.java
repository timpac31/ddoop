package io.timpac.ddoop.movie;

public class NoneDiscountPolicy implements DiscountPolicy {

	@Override
	public Money getDiscountAmount(Screening screening) {
		return Money.ZERO;
	}

}
