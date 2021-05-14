package io.timpac.ddoop.movie;

public interface DiscountCondition {
	boolean isSatisfied(Screening screening);
}
