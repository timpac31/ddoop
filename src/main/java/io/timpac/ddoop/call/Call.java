package io.timpac.ddoop.call;

import java.time.Duration;
import java.time.LocalDateTime;

public class Call {
	private LocalDateTime from;
	private LocalDateTime to;
	
	public Call(LocalDateTime from, LocalDateTime to) {
		this.from = from;
		this.to = to;
	}

	public LocalDateTime getFrom() {
		return from;
	}

	public LocalDateTime getTo() {
		return to;
	}
	
	public Duration getDuration() {
		return Duration.between(from, to);
	}
	
}