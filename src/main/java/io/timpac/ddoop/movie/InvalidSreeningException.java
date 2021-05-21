package io.timpac.ddoop.movie;

public class InvalidSreeningException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidSreeningException() {
		super();
	}
	
	public InvalidSreeningException(String msg) {
		super(msg);
	}
}
