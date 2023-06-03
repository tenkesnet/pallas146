package org.pallas;

public class Kamion extends TeherAuto{
    public String szin;
    public Kamion (double suly, int vegsebesseg, String szin){
        super("Raba",suly, vegsebesseg);
        String festettSzin = "fekete";
        this.szin=szin;
   }
   private Kamion()
   {
        marka="olivia";
   }

}
