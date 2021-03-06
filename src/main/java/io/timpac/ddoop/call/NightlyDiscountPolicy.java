package io.timpac.ddoop.call;

import java.time.Duration;

import io.timpac.ddoop.movie.Money;

public class NightlyDiscountPolicy extends BasicRatePolicy {
	private static final int LATE_NIGHT_HOUR = 22;
	private Money nightlyAmount;
	private Money amount;
	private Duration seconds;
	
	public NightlyDiscountPolicy(Money nightlyAmount, Money amount, Duration seconds) {
		this.nightlyAmount = nightlyAmount;
		this.amount = amount;
		this.seconds = seconds;
	}
	
	@Override
	public Money calculateFee(Call call) {
		if(call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
			return nightlyAmount.Multiply(call.getDuration().getSeconds() / seconds.getSeconds());
		}
		
		return amount.Multiply(call.getDuration().getSeconds() / seconds.getSeconds());
	}
}
