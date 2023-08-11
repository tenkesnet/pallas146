package org.jedi;

import java.util.Random;

public class AnakinSkywalker extends Jedi implements ISith{

    public AnakinSkywalker() {
        super(150, true);
    }

    @Override
    public void engeddElAHaragor() {
        Random rnd = new Random();
        this.setEro(this.getEro() + (rnd.nextFloat()*10) );
    }

    @Override
    public boolean megteremtiAzEgyensulyt() {
        if (this.getEro() > 1000){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public void printErtekek(){
            System.out.println("Anakin Skywalker ereje: " + this.getEro() + " és átállhat a sötét oldalra.");
    }
}
