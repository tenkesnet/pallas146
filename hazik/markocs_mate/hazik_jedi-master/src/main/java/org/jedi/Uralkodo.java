package org.jedi;

public class Uralkodo implements IEroErzekeny, ISith{

    private float gonoszsag;

    public Uralkodo(){
        this.gonoszsag = 100;
    }
    public float getGonoszsag() {return this.gonoszsag;}
    public void setGonoszsag(float gonoszsag) {this.gonoszsag = gonoszsag;}

    public void printErtekek(){
        System.out.println("Az Uralkodó gonoszsága: " + this.getGonoszsag());
    }

    @Override
    public boolean legyoziE(IEroErzekeny ellenfel) {
        if (this.getGonoszsag() > ellenfel.mekkoraAzEreje()){
            return true;
        }else {
            return false;
        }
    }
    @Override
    public float mekkoraAzEreje() {
        return (this.gonoszsag * 2);
    }
    @Override
    public boolean atallithato() {
        return true;
    }
    @Override
    public void engeddElAHaragor() {
        this.setGonoszsag((this.getGonoszsag() + 50));
    }
}
