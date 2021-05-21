package io.timpac.ddoop.movie;

public interface DiscountPolicy {
	Money getDiscountAmount(Screening screening);
}
