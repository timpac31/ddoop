package io.timpac.ddoop.call;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import io.timpac.ddoop.movie.Money;

public class NightlyDiscountPhone {
	private static final int LATE_NIGHT_HOUR = 22;
	private Money nightlyAmount;
	private Money amount;
	private Duration seconds;
	private List<Call> calls = new ArrayList<>();
	
	public NightlyDiscountPhone(Money nightlyAmount, Money amount, Duration seconds) {
		this.nightlyAmount = nightlyAmount;
		this.amount = amount;
		this.seconds = seconds;
	}
	
	public void call(Call call) {
		calls.add(call);
	}
	
	public Money calculateFee() {
		Money result = Money.ZERO;
		for(Call call : calls) {
			if(call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
				result = result.add(nightlyAmount.Multiply(call.getDuration().getSeconds() / seconds.getSeconds()));
			}else {
				result = result.add(amount.Multiply(call.getDuration().getSeconds() / seconds.getSeconds()));
			}
		}
		
		return result;
	}
}
