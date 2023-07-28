package Hazifeladat.oktatas;

public class Kurzus {
    private String name;
    private Oktato oktato;


    public Kurzus(String name, Oktato oktato){
        this.name = name;
        this.oktato = oktato;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Oktato getOktato() {
        return oktato;
    }

    public void setOktato(Oktato oktato) {
        this.oktato = oktato;
    }


    @Override
    public String toString(){
        return String.format("Kurzus neve: %s \n Kurzust "+oktato.toString(), name);

    }
}
