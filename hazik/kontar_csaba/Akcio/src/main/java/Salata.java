class Salata extends Termek {
    private int darabszam;

    public Salata(int darabszam, int egysegar) {
        super("salata", egysegar);
        this.darabszam = darabszam;
    }
    private int egysegar() {
        return egysegar;
    }
    @Override
    protected int mennyibeKerul() {
        return darabszam * egysegar();
    }

    @Override
    public String toString() {
        return darabszam + " db salata -  " + mennyibeKerul() + "Ft";
    }

}
