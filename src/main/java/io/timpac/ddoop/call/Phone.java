package io.timpac.ddoop.call;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import io.timpac.ddoop.movie.Money;

public class Phone {
	private Money amount;
	private Duration seconds;
	private List<Call> calls = new ArrayList<>();
	
	public Phone(Money amount, Duration seconds) {
		this.amount = amount;
		this.seconds = seconds;
	}
	
	public void call(Call call) {
		calls.add(call);
	}
	
	public Money calculateFee() {
		Money result = Money.ZERO;
		for(Call call : calls) {
			result = result.add(amount.Multiply(call.getDuration().getSeconds() / seconds.getSeconds()));
		}
		
		return result;
	}
}
