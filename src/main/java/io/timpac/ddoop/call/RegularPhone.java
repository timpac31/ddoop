package io.timpac.ddoop.call;

import java.time.Duration;

import io.timpac.ddoop.movie.Money;

public class RegularPhone extends Phone {
	private Money amount;
	private Duration seconds;
	
	public RegularPhone(Money amount, Duration seconds, double taxRate) {
		super(taxRate);
		this.amount = amount;
		this.seconds = seconds;
	}
	
	@Override
	public Money calculateFee(Call call) {
		return amount.Multiply(call.getDuration().getSeconds() / seconds.getSeconds());
	}
}
