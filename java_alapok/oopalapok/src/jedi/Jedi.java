package jedi;

public abstract class Jedi implements EroErzekeny {
    protected double ero ;
    protected boolean atallhatE ;

    public Jedi (double ero , boolean atallhatE ) {
        this.ero = ero ;
        this.atallhatE = atallhatE ;
    }

    public abstract boolean megteremtiAzEgyensulyt () ;

    public boolean legyoziE ( EroErzekeny o ) {
        if ( o instanceof Uralkodo ) {
            return o.mekkoraAzEreje() *2 < this.ero ? true : false;
        } else if ( o instanceof Jedi ) {
            return ((Jedi) o).isAtallhatE() && this.ero > o.mekkoraAzEreje() ? true : false ;
        } else {
            return false ;
        }
    }

    public double mekkoraAzEreje () {
        return ero ;
    }

    public double getEro () {
        return ero ;
    }

    public void setEro (double ero ) {
        this.ero = ero ;
    }

    public boolean isAtallhatE () {
        return atallhatE ;
    }

    public void setAtallhatE (boolean atallhatE ) {
        this.atallhatE = atallhatE ;
    }

    @Override
    public String toString () {
        return "Jedi ero = " + ero + ", atallhatE = " + atallhatE ;
    }
}
