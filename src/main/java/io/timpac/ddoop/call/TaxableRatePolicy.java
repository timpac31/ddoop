package io.timpac.ddoop.call;

import io.timpac.ddoop.movie.Money;

public class TaxableRatePolicy extends AdditionalRatePolicy {
	private double taxRate;

	public TaxableRatePolicy(double taxRate, RatePolicy next) {
		super(next);
		this.taxRate = taxRate;
	}

	@Override
	protected Money afterCalculated(Money fee) {
		return fee.add(fee.Multiply(taxRate));
	}

}
