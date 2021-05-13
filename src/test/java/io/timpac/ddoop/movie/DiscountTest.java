package io.timpac.ddoop.movie;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

public class DiscountTest {
	
	@Test
	public void discount() {
		ReservationManager manager = new ReservationManager();
		
		DiscountCondition discountCondition1 = new DiscountCondition(DiscountConditionType.SEQUENCE, 1, null, null, null);
		DiscountCondition discountCondition2 = new DiscountCondition(DiscountConditionType.SEQUENCE, 2, null, null, null);
		DiscountCondition discountCondition3 = new DiscountCondition(DiscountConditionType.PERIOD, 1, DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(12, 0));
		DiscountCondition discountCondition4 = new DiscountCondition(DiscountConditionType.PERIOD, 2, DayOfWeek.MONDAY, LocalTime.of(14, 0), LocalTime.of(18, 0));
		DiscountCondition discountCondition5 = new DiscountCondition(DiscountConditionType.PERIOD, 2, DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(18, 0));
		
		Movie movie = new Movie("기생충", Duration.ofMinutes(120), Money.wons(10000), MovieType.AMOUNT_DISCOUNT, Money.wons(1000), 0.2, discountCondition5);
		
		Screening screening = new Screening();
		screening.setSeq(1);
		screening.setMovie(movie);
		screening.setWhenScreened(LocalDateTime.of(2021, 5, 10, 10, 30));
		
		Reservation reservation = manager.reserve(screening, new Customer("jo", "timpac"), 1);
		
		
		System.out.println(reservation.getFee().getAmount().intValue());
	}
}
