package io.timpac.ddoop.movie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

public class DiscountTest {
	
	@Test
	public void discount() {
		ReservationManager manager = new ReservationManager();
		
		DiscountCondition discountCondition1 = new SequenceDiscountCondition(1);
		DiscountCondition discountCondition2 = new SequenceDiscountCondition(2);
		DiscountCondition discountCondition3 = new PeriodDiscountCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(12, 0));
		DiscountCondition discountCondition4 = new PeriodDiscountCondition(DayOfWeek.MONDAY, LocalTime.of(14, 0), LocalTime.of(18, 0));
		DiscountCondition discountCondition5 = new PeriodDiscountCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(18, 0));
		
		Movie movie1 = new Movie("기생충", Duration.ofMinutes(120), Money.wons(10000), new AmountDiscountPolicy(Money.wons(1000), discountCondition5));
		Movie movie2 = new Movie("아바타", Duration.ofMinutes(120), Money.wons(10000), new AmountDiscountPolicy(Money.wons(1000), discountCondition1));
		Movie movie3 = new Movie("곡성", Duration.ofMinutes(120), Money.wons(10000), new PercentDiscountPolicy(0.2, discountCondition3));
		Movie movie4 = new Movie("조커", Duration.ofMinutes(120), Money.wons(10000), new PercentDiscountPolicy(0.2, discountCondition2, discountCondition4));
		Movie movie5 = new Movie("스타워즈", Duration.ofMinutes(120), Money.wons(10000), new NoneDiscountPolicy());
		
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
		
		screening.setMovie(movie5);
		screening.setWhenScreened(LocalDateTime.of(2021, 5, 10, 14, 30));
		reservation = manager.reserve(screening, new Customer("jo", "timpac"), 1);
		assertEquals(Money.wons(10000), reservation.getFee());
	
	}
	
	@Test
	public void invalidSreeningException() {
		Movie movie = new Movie("", Duration.ofHours(2), Money.wons(10000), new AmountDiscountPolicy(Money.wons(100), new SequenceDiscountCondition(1)));
		
		Screening screening = new Screening();
		screening.setWhenScreened(LocalDateTime.of(2022, 1, 1, 1, 0));
		
		assertThrows(InvalidSreeningException.class, () -> {
			movie.calculateDiscountFee(screening);
		});
	}
}
