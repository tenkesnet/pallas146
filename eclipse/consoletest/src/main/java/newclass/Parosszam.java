package newclass;


import java.util.ArrayList;
import java.util.Scanner;


public class Parosszam {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        boolean haromjegyuE = true;
        int osszeg = 0;
        int atlag = 0;
        //int haromJegyuekSzama = 0;
        ArrayList<Integer> szamok = new ArrayList<Integer>();
        ListaIro listaIro = new ListaIro(szamok);

        while (haromjegyuE) {
            System.out.print("Kérek egy egész háromjegyű pozitív számot (bármi más számra a program kilép) : ");
            int szam = 0;
            try {
                szam = keyboard.nextInt();
            } catch (Exception e) {
                System.out.println("Számot kérek!");
            }
            if (szam >= 100 && szam <= 999) {
                //haromJegyuekSzama++;
                szamok.add(szam);
                //osszeg = osszeg + szam;
                //szamjegy = false;
                /*System.out.println("A szám háromjegyű.");
                if (szam % 2 == 0) {
                    System.out.println("A(z) " + szam + " páros.");
                } else {
                    System.out.println("A(z) " + szam + " páratlan.");
                }*/
            } else {
                haromjegyuE = false;
                System.out.println("A szám nem háromjegyű.");
            }
        }
        listaIro.osszegKiiras();

    }
}
