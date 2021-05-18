package io.timpac.ddoop.call;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import io.timpac.ddoop.movie.Money;

public class CallTest {
	@Test
	public void calculateFee() {
		Phone phone = new Phone(Money.wons(5), Duration.ofSeconds(10));
		phone.call(new Call(LocalDateTime.of(2021, 1, 1, 12, 10, 0), LocalDateTime.of(2021, 1, 1, 12, 11, 0)));
		phone.call(new Call(LocalDateTime.of(2021, 1, 2, 22, 10, 0), LocalDateTime.of(2021, 1, 2, 22, 11, 0)));
		
		assertEquals(Money.wons(60), phone.calculateFee());
	}
	
	@Test
	public void calculateNightFee() {
		NightlyDiscountPhone phone = new NightlyDiscountPhone(Money.wons(2), Money.wons(5), Duration.ofSeconds(10));
		phone.call(new Call(LocalDateTime.of(2021, 1, 1, 12, 10, 0), LocalDateTime.of(2021, 1, 1, 12, 11, 0)));
		phone.call(new Call(LocalDateTime.of(2021, 1, 2, 22, 10, 0), LocalDateTime.of(2021, 1, 2, 22, 11, 0)));
		
		assertEquals(Money.wons(42), phone.calculateFee());
	}
}
