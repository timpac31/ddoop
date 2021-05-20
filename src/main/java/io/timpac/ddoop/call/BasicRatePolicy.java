package io.timpac.ddoop.call;

import io.timpac.ddoop.movie.Money;

public abstract class BasicRatePolicy implements RatePolicy {

	@Override
	public Money calculateFee(Phone phone) {
		Money result = Money.ZERO;
		for(Call call : phone.getCalls()) {
			result = result.add(calculateFee(call));
		}
		
		return result;
	}
	
	protected abstract Money calculateFee(Call call);
}
