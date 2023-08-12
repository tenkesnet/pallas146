package newclass;

import java.util.ArrayList;


public class ListaIro {
    ArrayList<Integer> szamok ;

    public ListaIro(ArrayList<Integer> szamok) {
        this.szamok = szamok;
    }

    public void osszegKiiras() {
        int osszeg = 0;
        for ( int elem: szamok) {
            osszeg = osszeg + elem;
        }
        System.out.println("A(z) " + szamok + " számok összege= " + osszeg);
        float atlag = (float) osszeg / szamok.size();
        System.out.println("A(z) " + szamok + " átlaga: " + atlag);
        if (osszeg % 2 == 0) {
            System.out.println("Az összeg páros.");
        } else {
            System.out.println("Az összeg páratlan.");
        }
    }
}

