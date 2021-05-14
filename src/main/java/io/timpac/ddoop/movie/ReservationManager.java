package io.timpac.ddoop.movie;

public class ReservationManager {
	public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
		Movie movie = screening.getMovie();
		return new Reservation(screening, customer, audienceCount, movie.calculateDiscountFee(screening));
	}

}
