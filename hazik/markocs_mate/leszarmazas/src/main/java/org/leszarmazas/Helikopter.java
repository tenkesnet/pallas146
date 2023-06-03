package org.leszarmazas;

public class Helikopter extends LegiJarmu{
    protected int pilotakSzama;
    protected int szallithatoFo;
    protected String meghajtasTipusa;
    public Helikopter (String gyarto, int suly, int hossz, int magassag, int szelesseg, boolean isFelfegyverzett,
                       double sebessegMach, boolean isTeherhordo, boolean isOnmukodo, double maxHatotavKM,
                       int pilotakSzama, int szallithatoFo, String meghajtasTipusa){
        super(gyarto, suly, hossz, magassag, szelesseg, isFelfegyverzett, sebessegMach, isTeherhordo, isOnmukodo,
                maxHatotavKM);
        this.pilotakSzama = pilotakSzama;
        this.szallithatoFo = szallithatoFo;
        this.meghajtasTipusa = meghajtasTipusa;
    }
}
