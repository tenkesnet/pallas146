class Uralkodo implements EroErzekeny, Sith {
    private double gonoszsga;

    public Uralkodo() {
        this.gonoszsga = 100;
    }

    @Override
    public void engeddElAHaragod() {
        gonoszsga += 50;
    }

    @Override
    public boolean legyoziE(EroErzekeny masik) {
        if (masik instanceof Jedi) {
            Jedi jedi = (Jedi) masik;
            return jedi.mekkoraAzEreje() < gonoszsga;
        }
        return false;
    }

    @Override
    public double mekkoraAzEreje() {
        return gonoszsga * 2;
    }

    public double getGonoszsga() {
        return gonoszsga;
    }

    @Override
    public String toString() {
        return "Uralkodo: gonoszsga = " + gonoszsga;
    }
}
