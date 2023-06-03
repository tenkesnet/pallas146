package org.leszarmazas;

public class HarciJarmu {
    protected String gyarto;
    protected int suly;
    protected int hossz;
    protected int magassag;
    protected int szelesseg;
    protected boolean isFelfegyverzett;

    protected HarciJarmu(String gyarto, int suly, int hossz, int magassag, int szelesseg, boolean isFelfegyverzett){
        this.gyarto = gyarto;
        this.suly = suly;
        this.hossz = hossz;
        this.magassag = magassag;
        this.szelesseg = szelesseg;
        this.isFelfegyverzett = isFelfegyverzett;
    }

    protected void gyartoKiiras(){
        System.out.println(this.gyarto);
    }
}
