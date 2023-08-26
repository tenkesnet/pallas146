package examples;

public class Alkalmazott {
    String nev;
    int fizetes;

    private final static int MIN = 150000;
    private final static int MAX = 300000;

    private static int nyugdijKorhatar = 65;
    private int eletKor;

    private static int[] evesSzabadsag = new int[60];

    static {
        for (int i = 0; i < 30; i++) {
            evesSzabadsag[i] = 15;
        }
        for (int i = 30; i < 40; i++) {
            evesSzabadsag[i] = evesSzabadsag[i - 1] + 1;
        }
        for (int i = 40; i < 50; i++) {
            evesSzabadsag[i] = evesSzabadsag[i - 1] + 2;
        }
        for (int i = 50; i < 60; i++) {
            evesSzabadsag[i] = evesSzabadsag[i - 1] + 1;
        }

    }


    private int evesFizetes;

    public int getEvesFizetes() {
        evesFizetes = fizetes * 12;
        return evesFizetes;
    }

    public void fizetesEmel(Alkalmazott masik) {
        if (this.tobbetKeresE(masik) == 1) this.fizetes = masik.fizetes;
    }

    public void fizetesEmel(int emel) {
        fizetes = fizetes + emel;
        evesFizetes = fizetes * 12;
    }

    public Alkalmazott(String nev, int fizetes, int eletKor) {
        this.nev = nev;
        this.fizetes = fizetes;
        this.eletKor = eletKor;
        evesFizetes = fizetes * 12;
    }

    public int tobbetKeresE(Alkalmazott masik) {
        return masik.fizetes > this.fizetes ? 1 : (this.fizetes == masik.fizetes ? 0 : -1);
    }

    public boolean kozepesJovedelmu(int min, int max) {
        return this.fizetes < max && this.fizetes > min;
    }

    public void automataFizetesEmeles() {
        if (kozepesJovedelmu(MIN, MAX))
            fizetesEmel(5000);
    }

    public int szja() {
        return fizetes * 2 / 5;
    }

    public int tb() {
        return fizetes / 10;
    }

    public static void nyugdijKorhatarEmeles() {
        nyugdijKorhatar++;
    }

    public int hatraVan() {
        return nyugdijKorhatar - eletKor;
    }

    public int evesSzabadsag() {
        if (eletKor > 60)
            return evesSzabadsag[59];
        return evesSzabadsag[eletKor - 1];
    }

    @Override
    public String toString() {
        return "Név: " + nev + "; " + "Fizetése: " + fizetes + " Ft";
    }
}