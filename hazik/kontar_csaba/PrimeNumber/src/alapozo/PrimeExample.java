package alapozo;

public class PrimeExample {
    public int maxSzam = 10000;

    public static void main(String[] args) {
        int i;
        PrimeExample foProgram = new PrimeExample();
        int darab = 0;
        long start = System.currentTimeMillis();
        for (i = 10; i < foProgram.maxSzam; i++) {
            int valtozo;
            if (foProgram.primE(i) && PalindromE(i)) {
            	System.out.println(i);
                darab++;
            }

        }

        long stop = System.currentTimeMillis();
        System.out.println("Palindrom Prímek száma: " + darab);
        System.out.println("Futási idő: " + (stop - start) + "ms");
    }

      public boolean primE(int szam) {
        boolean result = true;
        for (int i = 2; i * i <= szam; i++) {                    //i*i=négyzetre emelés
            //for(int i=2; i<=Math.sqrt(szam);i++){         //Math.sqrt=négyzetgyök
            //for(int i=2; i<=szam/2;i++){
            if (szam % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }
    public static boolean PalindromE(int n) {
        int reversed = 0;
        int original = n;

        while (n != 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }

        return original == reversed;
    }
}

