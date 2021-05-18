package io.timpac.ddoop.call;

import java.time.Duration;

import io.timpac.ddoop.movie.Money;

public class NightlyDiscountPhone extends Phone {
	private static final int LATE_NIGHT_HOUR = 22;
	private Money nightlyAmount;
	private Money amount;
	private Duration seconds;
	
	public NightlyDiscountPhone(Money nightlyAmount, Money amount, Duration seconds, double taxRate) {
		super(taxRate);
		this.nightlyAmount = nightlyAmount;
		this.amount = amount;
		this.seconds = seconds;
	}
	
	@Override
	public Money calculateFee(Call call) {
		if(call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
			return nightlyAmount.Multiply(call.getDuration().getSeconds() / seconds.getSeconds());
		}else {
			return amount.Multiply(call.getDuration().getSeconds() / seconds.getSeconds());
		}
	}
}
