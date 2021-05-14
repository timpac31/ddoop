package io.timpac.ddoop.movie;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class Movie {
	private String title;
	private Duration runningTime;
	private Money fee;
	private List<DiscountCondition> discountCondition = new ArrayList<>();
	
	public Movie(String title, Duration runningTime, Money fee, DiscountCondition ...conditions) {
		this.title = title;
		this.runningTime = runningTime;
		this.fee = fee;
		this.discountCondition = Arrays.asList(conditions);
	}
	
	/**
	 * 할인조건이 하나라도 맞으면 return true, 아니면 false
	 * */
	private boolean discountable(Screening screening) {
		return discountCondition.stream().anyMatch(condition -> condition.isSatisfied(screening));
	}
	
	/**
	 * MovieType에따라 할인된 금액을 계산한다.
	 * */
	public Money calculateDiscountFee(Screening screening) {
		if(discountable(screening)) {
			return fee.subtract(getDiscountAmount(screening));
		}
		return fee;
	}
	
	protected abstract Money getDiscountAmount(Screening screening);
	
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
	public List<DiscountCondition> getDiscountCondition() {
		return Collections.unmodifiableList(discountCondition);
	}
	public void setDiscountCondition(List<DiscountCondition> discountCondition) {
		this.discountCondition = discountCondition;
	}

}
