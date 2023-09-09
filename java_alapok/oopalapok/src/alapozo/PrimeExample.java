package alapozo;

public class PrimeExample {
    public int maxSzam = 10000;
    public static void main(String[] args){
        int i;
        PrimeExample foProgram = new PrimeExample();
        int darab = 0;
        long start=System.currentTimeMillis();
        for(i=2; i<foProgram.maxSzam;i++){
            int valtozo;
            if(foProgram.primE(i) && foProgram.primE(reverseNumber(i)) ){
                darab++;
            }

        }
        long stop=System.currentTimeMillis();
        System.out.println(darab);
        System.out.println(stop-start);
    }
    public boolean primE(int szam){
        boolean result = true;
        for(int i=2; i*i<=szam;i++){                    //i*i=négyzetre emelés
            //for(int i=2; i<=Math.sqrt(szam);i++){         //Math.sqrt=négyzetgyök
            //for(int i=2; i<=szam/2;i++){
            if (szam%i==0){
                result=false;
                break;
            }
        }
        return result;
    }
    public static int reverseNumber(int num){
        int reversed = 0;
        while(num!=0){
            int digit = num % 10;
            reversed = reversed*10+digit;
            num/=10;
        }
        return reversed;
    }
}
