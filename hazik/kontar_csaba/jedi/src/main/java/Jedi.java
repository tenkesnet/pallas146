abstract class Jedi implements EroErzekeny {
    private double ero;
    private boolean atallhatE;

    public Jedi(double ero, boolean atallhatE) {
        this.ero = ero;
        this.atallhatE = atallhatE;
    }

    public abstract boolean megteremtiAzEgyensulyt();

    @Override
    public boolean legyoziE(EroErzekeny masik) {
        if (masik instanceof Jedi) {
            Jedi masikJedi = (Jedi) masik;
            if (atallhatE && masikJedi.atallhatE) {
                if (ero > masikJedi.ero) {
                    return true;
                }
            }
        } else if (masik instanceof Uralkodo) {
            Uralkodo uralkodo = (Uralkodo) masik;
            if (atallhatE && ero > uralkodo.getGonoszsga() * 2) {
                return true;
            }
        }
        return false;
    }

    @Override
    public double mekkoraAzEreje() {
        return ero;
    }

    public double getEro() {
        return ero;
    }

    public void setEro(double ero) {
        this.ero = ero;
    }

    public boolean isAtallhatE() {
        return atallhatE;
    }

    public void setAtallhatE(boolean atallhatE) {
        this.atallhatE = atallhatE;
    }

    @Override
    public String toString() {
        return "Jedi ereje = " + ero + ", atallhat-e: " + atallhatE;
    }
}