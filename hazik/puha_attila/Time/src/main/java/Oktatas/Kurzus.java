package Oktatas;


public class Kurzus {

    private String nev;                                 //property_nev

    private String oktato;                              //property_oktato

    public Kurzus (String nev, String oktato){          //constructor_Kurzus
        this.nev = nev;
        this.oktato = oktato;
    }

    public String getNev(){                             //getter_nev
        return nev;
    }

    public String getOktato() {                         //getter_oktato
        return oktato;
    }

    public void setNev(String nev){                     //setter_nev
        this.nev = nev;
    }

    public void setOktato(String oktato){               //setter_oktato
        this.oktato = oktato;
    }

    public String toString(){                           //toString
        return "A kurzust az "
                + nev +
                " oktató tartja"
                + oktato +
                " kategóriában.";
    }

}
