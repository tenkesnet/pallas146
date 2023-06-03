package org.leszarmazas;

public class FoldiJarmu extends HarciJarmu{
    protected int legenysegSzama;
    protected double sebessegKmH;
    protected FoldiJarmu(String gyarto, int suly, int hossz, int magassag, int szelesseg, boolean isFelfegyverzett,
                         int legenysegSzama, double sebessegKmH){
        super(gyarto, suly, hossz, magassag, szelesseg, isFelfegyverzett);
        this.legenysegSzama = legenysegSzama;
        this.sebessegKmH = sebessegKmH;
    }
    public FoldiJarmu() {
    	
    }
}
