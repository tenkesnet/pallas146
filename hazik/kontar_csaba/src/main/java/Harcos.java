public class Harcos {

    public String nev;
    private double eletEro;
    private double sebzesiEro;

    public Harcos(String nev, double eletEro, double sebzesiEro) {
        this.nev = nev;
        this.eletEro = eletEro;
        this.sebzesiEro = sebzesiEro;
    }

    public boolean Harcol(Harcos ellenfel, int localKorokSzama) {
        System.out.println("A " + localKorokSzama + ". kör elején. De még harc van!");
        boolean isEl = ellenfel.sebzes(sebzesiEro);
        if (isEl) {
            eletEro = eletEro - ellenfel.getSebzesiEro();
            if (eletEro <= 0) {
                return false;
            }
        } else {
            return false;
        }
        localKorokSzama += 10;
        return true;
    }

    public boolean sebzes(double sebzesiEro) {
        System.out.println("Harcos sebzés! ero: " + sebzesiEro);
        return true;
    }

    public double getSebzesiEro() {
        return sebzesiEro;
    }

    public double getEletEro() {
        return eletEro;
    }

    public void setEletEro(double eletEro) {
        this.eletEro = eletEro;
    }
}
