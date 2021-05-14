package io.timpac.ddoop.movie;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class PeriodDiscountCondition implements DiscountCondition {
	private DayOfWeek dayOfWeek;
	private LocalTime startTime;
	private LocalTime endTime;
	
	public PeriodDiscountCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	@Override
	public boolean isSatisfied(Screening screening) {
		return dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek()) &&
			startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
			endTime.compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
	}
	
	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
}
