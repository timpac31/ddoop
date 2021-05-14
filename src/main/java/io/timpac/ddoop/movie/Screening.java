package io.timpac.ddoop.movie;

import java.time.LocalDateTime;

public class Screening {
	private Movie movie;
	private int seq;
	private LocalDateTime whenScreened;
	
	public Screening() {}
	public Screening(Movie movie, int seq, LocalDateTime whenScreened) {
		this.movie = movie;
		this.seq = seq;
		this.whenScreened = whenScreened;
	}

	public Reservation reserve(Customer customer, int audienceCount) {
		Reservation reservation = new Reservation(this, customer, audienceCount, movie.calculateDiscountFee(this));
		
		return reservation;
	}
	
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public LocalDateTime getWhenScreened() {
		return whenScreened;
	}
	public void setWhenScreened(LocalDateTime whenScreened) {
		this.whenScreened = whenScreened;
	}
	
	
}
