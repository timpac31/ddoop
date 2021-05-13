package io.timpac.ddoop.movie;

import java.util.List;

public class ReservationManager {
	public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
		Movie movie = screening.getMovie();
		List<DiscountCondition> conditions = movie.getDiscountCondition();
		
		Money fee;
		if(validateCondition(conditions, screening)) {
			Money discountAmount = Money.ZERO;
			switch(movie.getMovieType()) {
				case AMOUNT_DISCOUNT:
					discountAmount = movie.getDiscountAmount();
					break;
				case PERCENT_DISCOUNT:
					discountAmount = movie.getFee().Multiply(movie.getDiscountPercent());
					break;
				case NONE_DISCOUNT:
					discountAmount = Money.ZERO;
					break;
			}
			
			fee = movie.getFee().subtract(discountAmount);
		}else {
			fee = movie.getFee();
		}
		
		return new Reservation(screening, customer, audienceCount, fee);
	}
	
	private boolean validateCondition(List<DiscountCondition> conditions, Screening screening) {
		for(DiscountCondition condition : conditions) {
			if(condition.getType() == DiscountConditionType.SEQUENCE) {
				if(condition.getSeq() == screening.getSeq()) {
					return true;
				}
			}else {
				if(condition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
						condition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0) {
					return true;
				}
			}
		}
		
		return false;
	}
}
