package io.timpac.ddoop.call;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.timpac.ddoop.movie.Money;

public class CallTest {
	private Phone phone;
	
	@BeforeEach
	public void setUp() {
		phone = new Phone();
		phone.call(new Call(LocalDateTime.of(2021, 1, 1, 12, 10, 0), LocalDateTime.of(2021, 1, 1, 12, 11, 0)));
		phone.call(new Call(LocalDateTime.of(2021, 1, 2, 22, 10, 0), LocalDateTime.of(2021, 1, 2, 22, 11, 0)));
	}
	
	@Test
	public void calculateFee() {
		phone.changePolicy(new RegularRatePolicy(Money.wons(5), Duration.ofSeconds(10)));
		assertEquals(Money.wons(60), phone.calculateFee());
	}
	
	@Test
	public void calculateNightFee() {
		phone.changePolicy(new NightlyDiscountPolicy(Money.wons(2), Money.wons(5), Duration.ofSeconds(10)));
		assertEquals(Money.wons(42), phone.calculateFee());
	}
	
	@Test
	public void addtionalRatePolicy() {
		RatePolicy regularPolicy1 = new RegularRatePolicy(Money.wons(5), Duration.ofSeconds(10));
		RatePolicy policy1 = new TaxableRatePolicy(0.1, regularPolicy1);
		RatePolicy policy2 = new TaxableRatePolicy(0, new DiscountableRatePolicy(Money.wons(10), policy1));
		RatePolicy policy3 = new DiscountableRatePolicy(Money.wons(20), 
								new TaxableRatePolicy(0.1, 
									new NightlyDiscountPolicy(Money.wons(2), Money.wons(5), Duration.ofSeconds(10))));
		
		phone.changePolicy(policy1);
		assertEquals(Money.wons(66), phone.calculateFee());
		
		phone.changePolicy(policy2);
		assertEquals(Money.wons(56), phone.calculateFee());
		
		phone.changePolicy(policy3);
		assertEquals(Money.wons(26.2), phone.calculateFee());
	}
}
