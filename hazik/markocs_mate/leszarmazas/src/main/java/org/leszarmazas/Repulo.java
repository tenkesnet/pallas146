package org.leszarmazas;

public class Repulo extends LegiJarmu{
    protected String festesTipusa;
    protected boolean isLopakodo;
    protected int maximumRepulesiMagassag;
    public Repulo (String gyarto, int suly, int hossz, int magassag, int szelesseg, boolean isFelfegyverzett,
                   double sebessegMach, boolean isTeherhordo, boolean isOnmukodo, double maxHatotavKM,
                   String festesTipusa, boolean isLopakodo, int maximumRepulesiMagassag){
        super(gyarto, suly, hossz, magassag, szelesseg, isFelfegyverzett, sebessegMach, isTeherhordo, isOnmukodo,
                maxHatotavKM);
        this.festesTipusa = festesTipusa;
        this.isLopakodo = isLopakodo;
        this.maximumRepulesiMagassag = maximumRepulesiMagassag;
    }
}
