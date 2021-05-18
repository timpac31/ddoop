package io.timpac.ddoop.call;

import java.util.ArrayList;
import java.util.List;

import io.timpac.ddoop.movie.Money;

public abstract class Phone {
	private List<Call> calls = new ArrayList<>();
	private double taxRate;
	
	public Phone(double taxRate) {
		this.taxRate = taxRate;
	}
	
	public Money calculateFee() {
		Money result = Money.ZERO;
		for(Call call : calls) {
			result = result.add(calculateFee(call));
		}
		
		return result.add(result.Multiply(taxRate));
	}
	
	public void call(Call call) {
		this.calls.add(call);
	}
	
	protected abstract Money calculateFee(Call call);
}
