package Hazifeladat.oktatas;

import Hazifeladat.intezmeny.Vegzettseg;

public class Oktato {
    private String name;
    private Vegzettseg vegzettseg;


    public Oktato(String name, Vegzettseg vegzettseg){
    this.name = name;
    this.vegzettseg = vegzettseg;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vegzettseg getVegzettseg() {
        return vegzettseg;
    }

    public void setVegzettseg(Vegzettseg vegzettseg) {
        this.vegzettseg = vegzettseg;
    }

    @Override
    public String toString(){
      return String.format("Oktató : %s \n Oktató %s ",name,vegzettseg.toString());
    };

}
