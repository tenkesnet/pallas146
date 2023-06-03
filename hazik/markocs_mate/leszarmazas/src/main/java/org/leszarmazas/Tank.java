package org.leszarmazas;

public class Tank extends FoldiJarmu {
    protected int agyuKaliber;
    protected String lovedekTipusa;
    protected int lovedekekSzama;
    protected boolean isCBRN;
    
    
    
    public Tank (String gyarto, int suly, int hossz, int magassag, int szelesseg, boolean isFelfegyverzett,
                 int legenysegSzama, double sebessegKmH, int agyuKaliber, String lovedekTipusa, int lovedekekSzama,
                 boolean isCBRN){
        //super(gyarto, suly, hossz, magassag, szelesseg, isFelfegyverzett, legenysegSzama, sebessegKmH);
        this.agyuKaliber = agyuKaliber;
        this.lovedekTipusa = lovedekTipusa;
        this.lovedekekSzama = lovedekekSzama;
        this.isCBRN = isCBRN;
    }
    protected void tankInfo(){
        if (this.getSuly() <= 20000){
            System.out.println("Ez egy könnyű tank.");
        } else if (this.getSuly() <= 50000){
            System.out.println("Ez egy közepes tank.");
        } else {
            System.out.println("Ez egy nehéz tank.");
        }
    }
}
