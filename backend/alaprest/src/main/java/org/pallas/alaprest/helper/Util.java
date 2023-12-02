package org.pallas.alaprest.helper;

public class Util {
    public static boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
