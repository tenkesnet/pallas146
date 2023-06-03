package org.leszarmazas;

public class Csatahajo extends ViziJarmu{
    protected int tornyokSzama;
    protected int agyukSzama;
    protected int agyuKaliber;
    public Csatahajo (String gyarto, int suly, int hossz, int magassag, int szelesseg, boolean isFelfegyverzett,
                      double sebessegCsomo, double maxHatotavKM, int tornyokSzama, int agyukSzama, int agyuKaliber){
        super(gyarto, suly, hossz, magassag, szelesseg, isFelfegyverzett, sebessegCsomo, maxHatotavKM);
        this.tornyokSzama = tornyokSzama;
        this.agyukSzama = agyukSzama;
        this.agyuKaliber = agyuKaliber;
    }
}
