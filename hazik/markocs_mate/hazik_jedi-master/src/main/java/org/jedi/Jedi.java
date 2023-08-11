package org.jedi;

public abstract class Jedi implements IEroErzekeny{
    private float ero;
    private boolean atallhatE;

    public Jedi (float ero, boolean atallhatE){
        this.ero = ero;
        this.atallhatE = atallhatE;
    }

    public float getEro() {return this.ero;}
    public void setEro(float ero) {this.ero = ero;}
    public boolean getAtallhatE() {return this.atallhatE;}
    public void setAtallhatE(boolean atallhatE) {this.atallhatE = atallhatE;}
    public void printErtekek(){
        if (this.getAtallhatE()){
            System.out.println("A Jedi ereje: " + this.getEro() + " és átállhat a sötét oldalra.");
        } else {
            System.out.println("A Jedi ereje: " + this.getEro() + " és nem állhat át a sötét oldalra.");
        }
    }

    public abstract boolean megteremtiAzEgyensulyt();
    @Override
    public float mekkoraAzEreje() {
        return this.getEro();
    }
    @Override
    public boolean atallithato(){
        return this.getAtallhatE();
    }
    @Override
    public boolean legyoziE(IEroErzekeny ellenfel){
        if (!ellenfel.atallithato()){
            return false;
        } else if (ellenfel instanceof Uralkodo || this.getEro() <= (ellenfel.mekkoraAzEreje() * 2)){
            return false;
        } else return !(this.getEro() <= ellenfel.mekkoraAzEreje());
    }
}
