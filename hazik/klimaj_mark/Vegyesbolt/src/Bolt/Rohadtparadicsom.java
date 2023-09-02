package Bolt;

import static java.lang.Math.round;

public class Rohadtparadicsom extends Termek implements Akciozhato {
private double tomeg = 0;
    Rohadtparadicsom(double tomeg, int egysegar){
        super("rohadt paradicsom", egysegar);
        this.tomeg=tomeg;
    }

    @Override
    public int akciosAr() {
        return (int)(round(this.egysegar*0.8));
    }

    @Override
    public int mennyibeKerul() {
        return (int)(round(tomeg*akciosAr()));
    }

    @Override
    public String toString() {
            return String.format("Akciós %s %.2f kg",super.toString(),tomeg);
    }
}
