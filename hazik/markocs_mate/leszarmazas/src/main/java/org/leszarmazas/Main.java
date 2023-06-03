package org.leszarmazas;

public class Main {
    public static void main(String[] args) {

        Tank t54 = new Tank("USSR", 45000, 6300, 2400, 3450, true,
                4,52, 100, "APHE", 49, false);
        Repulo mustang = new Repulo("USA", 5200, 6432, 2890, 15320, true,
                0.43, false, false, 523.4, "szürke",
                false, 6750);
        Csatahajo uSSAlaska = new Csatahajo("USA", 45500, 124000, 43200, 34520,
                true, 42.4, 2345.8, 4, 12, 235);

        System.out.println(t54.gyarto);
        t54.gyartoKiiras();
        uSSAlaska.gyartoKiiras();

        mustang.teherhordoKiiras();
        mustang.onmukodoKiiras();

        t54.tankInfo();
        t54.suly = 52000;
        t54.tankInfo();
    }
}