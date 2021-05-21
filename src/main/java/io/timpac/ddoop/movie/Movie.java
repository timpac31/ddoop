package io.timpac.ddoop.movie;

import java.time.Duration;
import java.time.LocalDateTime;

public class Movie {
	private String title;
	private Duration runningTime;
	private Money fee;
	private DiscountPolicy discountPolicy;
	
	public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
		this.title = title;
		this.runningTime = runningTime;
		this.fee = fee;
		this.discountPolicy = discountPolicy;
	}
	
	public Money calculateDiscountFee(Screening screening) {
		if(screening == null || screening.getWhenScreened().isAfter(LocalDateTime.now())) {
			throw new InvalidSreeningException();
		}
		
		return fee.subtract(discountPolicy.getDiscountAmount(screening));
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Duration getRunningTime() {
		return runningTime;
	}
	public void setRunningTime(Duration runningTime) {
		this.runningTime = runningTime;
	}
	public Money getFee() {
		return fee;
	}
	public void setFee(Money fee) {
		this.fee = fee;
	}

}
