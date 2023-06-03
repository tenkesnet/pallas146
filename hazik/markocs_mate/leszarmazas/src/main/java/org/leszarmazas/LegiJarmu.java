package org.leszarmazas;

public class LegiJarmu extends HarciJarmu{
    protected double sebessegMach;
    protected boolean isTeherhordo;
    protected boolean isOnmukodo;
    protected double maxHatotavKM;
    protected LegiJarmu(String gyarto, int suly, int hossz, int magassag, int szelesseg, boolean isFelfegyverzett,
                        double sebessegMach, boolean isTeherhordo, boolean isOnmukodo, double maxHatotavKM){
        super(gyarto, suly, hossz, magassag, szelesseg, isFelfegyverzett);
        this.sebessegMach = sebessegMach;
        this.isTeherhordo = isTeherhordo;
        this.isOnmukodo = isOnmukodo;
        this.maxHatotavKM = maxHatotavKM;
    }
    protected void teherhordoKiiras(){
        if (this.isTeherhordo){
            System.out.println("Ez a légi jármű teherhordó.");
        } else {
            System.out.println("Ez a légi jármű nem therehordó.");
        }
    }
    protected void onmukodoKiiras(){
        if(this.isOnmukodo){
            System.out.println("Ez a legi jármű önműködő.");
        } else {
            System.out.println("Ez a légi jármű nem önműködő.");
        }
    }
}
