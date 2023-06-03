package org.pallas;

public class TeherAuto {
    public String marka;
    int vegsebesseg;
    double suly;
    protected boolean isElektromos;

    public TeherAuto (String marka, double suly, int vegsebesseg){
        this.marka = marka;
        this.suly = suly;
        this.vegsebesseg = vegsebesseg;

    }
    public TeherAuto(){
        vegsebesseg=300;
    }


}



