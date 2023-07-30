package Hazifeladat;

import Hazifeladat.intezmeny.*;
import Hazifeladat.oktatas.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MainEgyetem {


    public static void main(String[] args) {
        Egyetem e1 = new Egyetem("BME", "Budapest");
        Egyetem e2 = new Egyetem("SZTE", "Szeged");
        Egyetem e3 = new Egyetem("PTE", "Pécs");
        Egyetem e4 = new Egyetem("Szabad", "Pécs");
        Vegzettseg v1 = new Vegzettseg("Informatika", e1);
        Vegzettseg v2 = new Vegzettseg("Informatika", e2);
        Vegzettseg v3 = new Vegzettseg("Informatika", e3);
        Vegzettseg v4 = new Vegzettseg("Biológia", e4);
        Oktato o1 = new Oktato("János", v1,4);
        Oktato o2 = new Oktato("Géza", v2,6);
        Oktato o3 = new Oktato("Tibi", v3,7);
        Oktato o4 = new Oktato("Zoli", v3,3);
        Oktato o5 = new Oktato("Géza", v3,5);
        Oktato o6 = new Oktato("Géza", v4,2);

        Kurzus[] kurzus = new Kurzus[]
                {
                        new Kurzus("Hálozat ismeretek", o1),
                        new Kurzus("Programozás alapjai", o2),
                        new Kurzus("Hardver Ismeretek", o3),
                        new Kurzus("Matematika a számítástechnikában", o3),
                        new Kurzus("Matematika a számítástechnikában", o4),
                        new Kurzus("Hálózati ismeretek 2", o5),
                        new Kurzus("Hálózati ismeretek 2", o6)
                };


        for (Kurzus a : kurzus) {
            System.out.println(a);
        }

        varosNeve(kurzus, "Pécs"); //Az ellenőrizendő érték itt módosítható.
        System.out.println();
        String a = "1ot";
        String b = new String("1pU");

        b = b.intern();
        System.out.printf("'a' hash code: %s%n",a.hashCode());
        System.out.printf("'a' hash code: %s%n",b.hashCode());
        System.out.printf("a==b: %s%n",a == b);
        System.out.printf("a.equals(b) : %s%n",a.equals(b));
        System.out.printf("o5.equals(o2): %s%n",o5.equals(o2));
    }

    public static void varosNeve(Kurzus[] ellenorzes, String varosNev) {
        short incr = 0;
        HashMap<String,Oktato> oktatokMap = new HashMap<>();
        for (Kurzus vizsgalando : ellenorzes) {
            if (vizsgalando.getOktato().getVegzettseg().getEgytem().getVaros().equals(varosNev)) {
                if (!oktatokMap.containsKey(vizsgalando.getOktato().getName()+
                        vizsgalando.getOktato().getVegzettseg().getSzak())) {
                    incr+=vizsgalando.getOktato().getTapasztalat();
                }
                oktatokMap.put(vizsgalando.getOktato().getName()+
                        vizsgalando.getOktato().getVegzettseg().getSzak()
                        ,vizsgalando.getOktato());
            }
        }
        System.out.printf("A megadott városból : %d oktató szerezte a végzettségét", incr);
    }

}


