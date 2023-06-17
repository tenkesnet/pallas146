package jatek;

import java.security.SecureRandom;
 
public class generateRandom {
		int rand_int;
		SecureRandom rand = new SecureRandom();
        public generateRandom() {
		};
		
		public int rng() {
		return this.rand_int = rand.nextInt(100);
	}
}