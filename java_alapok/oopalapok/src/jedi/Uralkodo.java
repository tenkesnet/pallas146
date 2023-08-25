package jedi;

public class Uralkodo implements EroErzekeny , Sith {
    private double gonoszsag ;

    public Uralkodo () {
        this.gonoszsag = 100;
    }

    public boolean legyoziE ( EroErzekeny o ) {
        return o.mekkoraAzEreje () < this.gonoszsag ? true : false ;
    }

    public double mekkoraAzEreje () {
        return this.gonoszsag*2;
    }

    public void engeddElAHaragod () {
        this.gonoszsag+=50;
    }

    public double getGonoszsag () {
        return gonoszsag ;
    }

    public void setGonoszsag (double gonoszsag ) {
        this.gonoszsag = gonoszsag ;
    }

    @Override
    public String toString () {
        return "Uralkodo gonoszsag = " + gonoszsag ;
    }
}
