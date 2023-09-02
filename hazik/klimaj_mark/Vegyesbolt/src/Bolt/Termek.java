package Bolt;

public abstract class Termek {
    private String nev;

    protected int egysegar;

    Termek(String nev, int egysegar){
        this.nev=nev;
        this.egysegar=egysegar;
    }

    public abstract int mennyibeKerul();

    @Override
    public String toString(){
        return String.format("%s - %d Ft",nev,mennyibeKerul());
    }
}
