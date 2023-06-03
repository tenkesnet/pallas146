package org.leszarmazas;

public class Rombolo extends ViziJarmu{
    protected String fegyverzetTipusa;
    protected int fegyverzetSzama;
    public Rombolo(String gyarto, int suly, int hossz, int magassag, int szelesseg, boolean isFelfegyverzett,
                   double sebessegCsomo, double maxHatotavKM, String fegyverzetTipusa, int fegyverzetSzama){
        super(gyarto, suly, hossz, magassag, szelesseg, isFelfegyverzett, sebessegCsomo, maxHatotavKM);
        this.fegyverzetTipusa = fegyverzetTipusa;
        this.fegyverzetSzama = fegyverzetSzama;
    }
}
