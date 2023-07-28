package Hazifeladat;

import Hazifeladat.intezmeny.*;
import Hazifeladat.oktatas.*;

public class MainEgyetem {


    public static void main(String[] args) {
        Egyetem e1 = new Egyetem("BME","Budapest");
        Egyetem e2 = new Egyetem("SZTE","Szeged");
        Egyetem e3 = new Egyetem("PTE","Pécs");
        Vegzettseg v1 = new Vegzettseg("Informatika",e1);
        Vegzettseg v2 = new Vegzettseg("Informatika",e2);
        Vegzettseg v3 = new Vegzettseg("Informatika",e3);
        Oktato o1 = new Oktato("János",v1);
        Oktato o2 = new Oktato("Géza", v2);
        Oktato o3 = new Oktato("Tibor", v3);
        Oktato o4 = new Oktato("Géza", v3);
        Oktato o5 = new Oktato("Géza", v3);


        Kurzus[] kurzus = new Kurzus[]
                {
                new Kurzus("Hálozat ismeretek",o1),
                new Kurzus("Programozás alapjai", o2),
                new Kurzus ("Hardver Ismeretek", o3),
                new Kurzus("Matematika a számítástechnikában", o3),
                new Kurzus("Matematika a számítástechnikában", o4),
                new Kurzus("Hálózati ismeretek 2", o5)
                };


        for( Kurzus a : kurzus)
        {
        System.out.println(a);
        }

        varosNeve(kurzus,"Pécs"); //Az ellenőrizendő érték itt módosítható.


    }

    public static void varosNeve(Kurzus[] ellenorzes, String varosNev) {
        short incr = 0;
        boolean[] azonosOktatonev=new boolean[ellenorzes.length];
        for (Kurzus vizsgalando : ellenorzes) {

            if (vizsgalando.getOktato().getVegzettseg().getEgytem().getVaros().equals(varosNev)) {
                String oktatoNeve = vizsgalando.getOktato().getName();
                int nIndex = findIndexOfSameName(ellenorzes, oktatoNeve);

                if (nIndex != -1 && !azonosOktatonev[nIndex]) {
                    azonosOktatonev[nIndex] = true;
                    incr++;

                }
            }
        }
        System.out.printf("A megadott városból : %d oktató szerezte a végzettségét", incr);


    }


    private static int findIndexOfSameName(Kurzus[] ellenorzes, String oktatoNev) {
        for (int i = 0; i < ellenorzes.length; i++) {
            if (ellenorzes[i].getOktato().getName().equals(oktatoNev)) {
                return i;
            }
        }
        return -1;
    }
}


