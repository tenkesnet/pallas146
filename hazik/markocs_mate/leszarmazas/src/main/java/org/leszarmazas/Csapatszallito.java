package org.leszarmazas;

public class Csapatszallito extends FoldiJarmu{
    protected int szallithatoFo;
    protected int szallithatoSuly;
    protected int kerekekSzama;
    public Csapatszallito (String gyarto, int suly, int hossz, int magassag, int szelesseg, boolean isFelfegyverzett,
                           int legenysegSzama, double sebessegKmH, int szallithatoFo, int szallithatoSuly,
                           int kerekekSzama){
        super(gyarto, suly, hossz, magassag, szelesseg, isFelfegyverzett, legenysegSzama, sebessegKmH);
        this.szallithatoFo = szallithatoFo;
        this.szallithatoSuly = szallithatoSuly;
        this.kerekekSzama = kerekekSzama;
    }
}
