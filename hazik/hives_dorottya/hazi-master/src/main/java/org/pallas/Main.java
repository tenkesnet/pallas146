package org.pallas;


public class Main {
    public static void main(String[] args) {
        MacskaFele tigris;
        MacskaFele szörnyi;
        szörnyi = new HaziMacska("szürkecirmos", "Ház", 1.5f, false);
        tigris= new VadMacska("csikos", "India", 400, false);
        Otthon dori = new Otthon();
        //dori.szörnyi.boldog=new String("igen");
        
        if(dori.szörnyi.boldog == null) System.out.println(dori.szörnyi.boldog.length());
        
        int length = dori.szörnyi.boldog == null ? dori.szörnyi.boldog.length(): 4 ;
        
        
        System.out.println("Tigris");
        System.out.print("Szine:");
        System.out.println(tigris.szin);
        System.out.print("Élőhelye:");
        System.out.println(tigris.eloHely);
        System.out.print("Súlya:");
        System.out.print(tigris.suly);
        System.out.println("kg");
        System.out.print("Temperamentuma:");
        if (tigris.agressziv == true){
            System.out.println("Agressziv");
        }
        else {System.out.println("Szelid");};
        System.out.println("Szörnyi");
        System.out.print("Szine:");
        System.out.println(szörnyi.szin);
        System.out.print("Élőhelye:");
        System.out.println(szörnyi.eloHely);
        System.out.print("Súlya:");
        System.out.print(szörnyi.suly);
        System.out.println("kg");
        System.out.print("Temperamentuma:");
        if (szörnyi.agressziv == true) {
            System.out.print("Agressziv");
        }
        else {
            System.out.print("Szelid");
        }
    }

}