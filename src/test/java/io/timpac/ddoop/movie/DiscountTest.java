package io.timpac.ddoop.movie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
		
		assertTrue(discountCondition1.isSatisfied(1, null, null));
		assertFalse(discountCondition1.isSatisfied(2, null, null));
		assertTrue(discountCondition2.isSatisfied(2, null, null));
		assertFalse(discountCondition2.isSatisfied(1, null, null));
		assertTrue(discountCondition3.isSatisfied(1, DayOfWeek.MONDAY, LocalTime.of(12, 0)));
		assertFalse(discountCondition3.isSatisfied(1, DayOfWeek.MONDAY, LocalTime.of(9, 0)));
		assertFalse(discountCondition3.isSatisfied(1, DayOfWeek.THURSDAY, LocalTime.of(11, 0)));
		assertFalse(discountCondition4.isSatisfied(1, DayOfWeek.THURSDAY, LocalTime.of(11, 0)));
		assertTrue(discountCondition5.isSatisfied(1, DayOfWeek.TUESDAY, LocalTime.of(18, 0)));
		
		
		Movie movie1 = new Movie("기생충", Duration.ofMinutes(120), Money.wons(10000), MovieType.AMOUNT_DISCOUNT, Money.wons(1000), 0.2, discountCondition5);
		Movie movie2 = new Movie("아바타", Duration.ofMinutes(120), Money.wons(10000), MovieType.AMOUNT_DISCOUNT, Money.wons(1000), 0.2, discountCondition1);
		Movie movie3 = new Movie("곡성", Duration.ofMinutes(120), Money.wons(10000), MovieType.PERCENT_DISCOUNT, Money.wons(1000), 0.2, discountCondition3);
		Movie movie4 = new Movie("조커", Duration.ofMinutes(120), Money.wons(10000), MovieType.PERCENT_DISCOUNT, Money.wons(1000), 0.2, discountCondition2, discountCondition4);
		
		Screening screening = new Screening();
		screening.setSeq(1);
		screening.setMovie(movie1);
		screening.setWhenScreened(LocalDateTime.of(2021, 5, 10, 10, 30));
		
		Reservation reservation = manager.reserve(screening, new Customer("jo", "timpac"), 1);
		assertEquals(Money.wons(10000), reservation.getFee());
		
		screening.setMovie(movie2);
		reservation = manager.reserve(screening, new Customer("jo", "timpac"), 1);
		assertEquals(Money.wons(9000), reservation.getFee());
		
		screening.setMovie(movie3);
		reservation = manager.reserve(screening, new Customer("jo", "timpac"), 1);
		assertEquals(Money.wons(8000), reservation.getFee());
		
		screening.setWhenScreened(LocalDateTime.of(2021, 5, 12, 10, 30));
		reservation = manager.reserve(screening, new Customer("jo", "timpac"), 1);
		assertEquals(Money.wons(10000), reservation.getFee());
		
		screening.setMovie(movie4);
		screening.setWhenScreened(LocalDateTime.of(2021, 5, 10, 14, 30));
		reservation = manager.reserve(screening, new Customer("jo", "timpac"), 1);
		assertEquals(Money.wons(8000), reservation.getFee());
	
	}
}
