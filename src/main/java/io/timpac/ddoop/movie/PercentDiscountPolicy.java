package io.timpac.ddoop.movie;

import java.util.Arrays;

public class PercentDiscountPolicy extends AbstractDiscountPolicy {
	private double discountPercent;
	
	public PercentDiscountPolicy(double discountPercent, DiscountCondition ...conditions) {
		super(Arrays.asList(conditions));
		this.discountPercent = discountPercent;
	}
	
	@Override
	protected Money getDiscountAmount(Money fee) {
		return fee.Multiply(discountPercent);
	}

}