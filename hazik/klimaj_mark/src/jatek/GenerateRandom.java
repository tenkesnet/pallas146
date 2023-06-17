package jatek;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;

public class GenerateRandom {
	int rand_int;
	SecureRandom rand = new SecureRandom();

	// get random number in range
	public int rng(int min, int max) {
		return this.rand_int = rand.nextInt(min, max);
	}

	public double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(Double.toString(value));
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
}