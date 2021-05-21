package io.timpac.ddoop.movie;

import java.util.Arrays;

public class AmountDiscountPolicy extends AbstractDiscountPolicy {
	private Money discountAmount;
	
	public AmountDiscountPolicy(Money discountAmount, DiscountCondition ...conditions) {
		super(Arrays.asList(conditions));
		this.discountAmount = discountAmount;
	}
	
	@Override
	protected Money getDiscountAmount(Money fee) {
		return discountAmount;
	}
}
