package io.timpac.ddoop.movie;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Movie {
	private String title;
	private Duration runningTime;
	private Money fee;
	private MovieType movieType;
	private List<DiscountCondition> discountCondition = new ArrayList<>();
	private Money discountAmount;
	private double discountPercent;
	
	public Movie(String title, Duration runningTime, Money fee, MovieType movieType,
			Money discountAmount, double discountPercent, DiscountCondition ...conditions) {
		this.title = title;
		this.runningTime = runningTime;
		this.fee = fee;
		this.movieType = movieType;
		this.discountCondition = Arrays.asList(conditions);
		this.discountAmount = discountAmount;
		this.discountPercent = discountPercent;
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
	public MovieType getMovieType() {
		return movieType;
	}
	public void setMovieType(MovieType movieType) {
		this.movieType = movieType;
	}
	public List<DiscountCondition> getDiscountCondition() {
		return Collections.unmodifiableList(discountCondition);
	}
	public void setDiscountCondition(List<DiscountCondition> discountCondition) {
		this.discountCondition = discountCondition;
	}
	public Money getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(Money discountAmount) {
		this.discountAmount = discountAmount;
	}
	public double getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}
	
}
