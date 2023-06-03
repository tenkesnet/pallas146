package org.pallas;


public class Main {
    public static void main(String[] args) {
        MacskaFele tigris;
        MacskaFele szörnyi;
        szörnyi = new HaziMacska("szürkecirmos", "Ház", 1.5f, false);
        tigris= new VadMacska("csikos", "India", 400, true);

        System.out.println("Tigris");
        System.out.print("Szine:");
        System.out.println(tigris.szin);
        System.out.print("Élőhelye:");
        System.out.println(tigris.élőHely);
        System.out.print("Súlya:");
        System.out.print(tigris.suly);
        System.out.println("kg");
        System.out.print("Temperamentuma:");
        if (tigris.agressziv = true){
            System.out.println("Agressziv");
        }
        else {System.out.println("Szelid");};
        System.out.println("Szörnyi");
        System.out.print("Szine:");
        System.out.println(szörnyi.szin);
        System.out.print("Élőhelye:");
        System.out.println(szörnyi.élőHely);
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