package io.timpac.ddoop.call;

import java.time.Duration;

import io.timpac.ddoop.movie.Money;

public class RegularRatePolicy extends BasicRatePolicy {
	private Money amount;
	private Duration seconds;
	
	public RegularRatePolicy(Money amount, Duration seconds) {
		this.amount = amount;
		this.seconds = seconds;
	}
	
	
	@Override
	public Money calculateFee(Call call) {
		return amount.Multiply(call.getDuration().getSeconds() / seconds.getSeconds());
	}
	

}
