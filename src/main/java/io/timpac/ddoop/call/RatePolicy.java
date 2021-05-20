package io.timpac.ddoop.call;

import io.timpac.ddoop.movie.Money;

public interface RatePolicy {
	Money calculateFee(Phone phone);
}
