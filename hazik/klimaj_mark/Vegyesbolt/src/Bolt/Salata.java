package Bolt;

public class Salata extends Termek{

    private int darab = 0;
    Salata(int darabszam, int egysegar)
    {super("salata", egysegar);
    darab=darabszam;
    }
    @Override
    public int mennyibeKerul(){
        return darab*egysegar;
    }

    @Override
    public String toString(){
        return String.format("%s %d db",super.toString(),darab);
    }
}
