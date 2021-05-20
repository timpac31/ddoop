package io.timpac.ddoop.call;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.timpac.ddoop.movie.Money;

public class Phone {
	private List<Call> calls = new ArrayList<>();
	private RatePolicy ratePolicy;
	
	public Phone() {}
	
	public Phone(RatePolicy ratePolicy) {
		this.ratePolicy = ratePolicy;
	}
	
	public Money calculateFee() {
		return ratePolicy.calculateFee(this);
	}
	
	public void call(Call call) {
		this.calls.add(call);
	}
	
	public List<Call> getCalls() {
		return Collections.unmodifiableList(calls);
	}
	
	public void changePolicy(RatePolicy ratePolicy) {
		this.ratePolicy = ratePolicy;
	}
}
