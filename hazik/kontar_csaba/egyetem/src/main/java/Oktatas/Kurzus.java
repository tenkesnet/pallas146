package Oktatas;

public class Kurzus {
    private String nev;
    private Oktato oktato;

    public Kurzus(String nev, Oktato oktato) {
        this.nev = nev;
        this.oktato = oktato;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Oktato getOktato() {
        return oktato;
    }

    public void setOktato(Oktato oktato) {
        this.oktato = oktato;
    }

    @Override
    public String toString() {
        return String.format("Ez a(z) %s kurzus %s tanítja.", nev, oktato);
    }

}
