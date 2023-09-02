package alapozo;

public class PrimeExample {
    public int maxSzam = 2000000;
    public static void main(String[] args){
        int i;
        PrimeExample foProgram = new PrimeExample();
        int darab = 0;
        long start=System.currentTimeMillis();
        for(i=2; i<foProgram.maxSzam;i++){
            int valtozo;
            if(foProgram.primE(i)){
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
}
