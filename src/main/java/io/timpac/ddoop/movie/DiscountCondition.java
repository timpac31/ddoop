package io.timpac.ddoop.movie;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {
	private DiscountConditionType type;
	private int seq;
	private DayOfWeek dayOfWeek;
	private LocalTime startTime;
	private LocalTime endTime;
	
	public DiscountCondition(DiscountConditionType type, int seq, DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
		this.type = type;
		this.seq = seq;
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public boolean isSatisfied(int screeningSeq, DayOfWeek screeningDayOfWeek, LocalTime screeningTime) {
		if(type == DiscountConditionType.SEQUENCE) {
			if(seq == screeningSeq) {
				return true;
			}
		}else if(type == DiscountConditionType.PERIOD) {
			if(dayOfWeek.equals(screeningDayOfWeek) && startTime.compareTo(screeningTime) <= 0 && endTime.compareTo(screeningTime) >= 0) {
				return true;
			}
		}else {
			throw new IllegalArgumentException("DiscountConditionType is invalid");
		}
		return false;
	}
	
	public DiscountConditionType getType() {
		return type;
	}
	public void setType(DiscountConditionType type) {
		this.type = type;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
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
