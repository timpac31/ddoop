package io.timpac.ddoop.movie;

public class Reservation {
	private Screening screening;
	private Customer customer;
	private int audienceCount;
	private Money fee;
	
	public Reservation(Screening screening, Customer customer, int audienceCount, Money fee) {
		this.screening = screening;
		this.customer = customer;
		this.audienceCount = audienceCount;
		this.fee = fee;
	}
	
	public Screening getScreening() {
		return screening;
	}
	public void setScreening(Screening screening) {
		this.screening = screening;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getAudienceCount() {
		return audienceCount;
	}
	public void setAudienceCount(int audienceCount) {
		this.audienceCount = audienceCount;
	}
	public Money getFee() {
		return fee;
	}
	public void setFee(Money fee) {
		this.fee = fee;
	}
	
}
