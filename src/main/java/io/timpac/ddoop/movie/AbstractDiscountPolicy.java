package io.timpac.ddoop.movie;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDiscountPolicy implements DiscountPolicy {
	private List<DiscountCondition> discountConditions = new ArrayList<>();
	
	public AbstractDiscountPolicy(List<DiscountCondition> conditions) {
		this.discountConditions = conditions;
	}
	
	/**
	 * 할인조건이 하나라도 맞으면 return true, 아니면 false
	 * */
	private boolean discountable(Screening screening) {
		return discountConditions.stream().anyMatch(condition -> condition.isSatisfied(screening));
	}

	@Override
	public Money getDiscountAmount(Screening screening) {
		if(discountable(screening)) {
			return getDiscountAmount(screening.getMovieFee());
		}else {
			return Money.ZERO;
		}
	}

	protected abstract Money getDiscountAmount(Money fee);
}
