package org.leszarmazas;

public class ViziJarmu extends HarciJarmu{
    protected double sebessegCsomo;
    protected double maxHatotavKM;
    protected ViziJarmu (String gyarto, int suly, int hossz, int magassag, int szelesseg, boolean isFelfegyverzett,
                         double sebessegCsomo, double maxHatotavKM){
        super(gyarto, suly, hossz, magassag, szelesseg, isFelfegyverzett);
        this.sebessegCsomo = sebessegCsomo;
        this.maxHatotavKM = maxHatotavKM;
    }
}
