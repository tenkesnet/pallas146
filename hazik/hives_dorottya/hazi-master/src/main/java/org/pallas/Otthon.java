package org.pallas;

public class Otthon extends MacskaFele{

    HaziMacska szörnyi;

    public Otthon() {
        super("", "", 0.0f, false);
        szörnyi = new HaziMacska("szürkecirmos", "Ház", 2.5f, false);
        HaziMacska hela = new HaziMacska("teknőctarka", "Ház", 2.8f, false);
    }
}