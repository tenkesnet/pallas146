import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		final int n = 10000;

		boolean[] isPrime = prime(n);
		int darab = 0;

		System.out.println("Prímszámok " + n + "-ig:");
		for (int i = 2; i <= n; i++) {
			if (isPrime[i] && isPrime[(reverseNumber(i))]) {
				System.out.println(i + " Prím fordítottja: " + reverseNumber(i));
				darab++;
			}
		}
		System.out.println(darab);
	}

	public static boolean[] prime(int n) {
		boolean[] isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;

		for (int p = 2; p * p <= n; p++) {
			if (isPrime[p]) {
				for (int i = p * p; i <= n; i += p) {
					isPrime[i] = false;
				}
			}
		}

		return isPrime;
	}

	public static int reverseNumber(int num) {
		int reversed = 0;
		while (num != 0) {
			int digit = num % 10;
			reversed = reversed * 10 + digit;
			num /= 10;
		}
		return reversed;
	}
}