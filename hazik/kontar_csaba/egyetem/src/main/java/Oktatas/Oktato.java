package Oktatas;

import intezmeny.Vegzettseg;

public class Oktato {
    private String nev;
    private Vegzettseg vegzettseg;
    public Oktato(String nev, Vegzettseg vegzettseg) {
        this.nev = nev;
        this.vegzettseg = vegzettseg;
    }

    public String getNev() {
        return nev;
    }
    public void setNev(String nev) {
        this.nev = nev;
    }

    public Vegzettseg getVegzettseg() {
        return vegzettseg;
    }

    public void setVegzettseg(Vegzettseg vegzettseg) {
        this.vegzettseg = vegzettseg;
    }
    @Override
    public String toString() {
        return String.format("Ez a(z) %s oktató rendelkezik %s végzettséggel",nev,vegzettseg);
    }


}
