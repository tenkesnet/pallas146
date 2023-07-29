package Oktatas;

import Intezmeny.Vegzettseg;

public class Oktato {

    private String nev;                                 //property_nev

    private Vegzettseg vegzettseg;                              //property_oktato

    public Oktato (String nev, Vegzettseg vegzettseg){          //contructor_Oktato
        this.nev = nev;
        this.vegzettseg = vegzettseg;
    }

    public String getNev(){                             //getter_nev
        return nev;
    }

    public Vegzettseg getVegzettseg(){                          //getter_oktato
        return vegzettseg;
    }

    public void setNev(String nev){                     //setter_nev
        this.nev = nev;
    }

    public void setVegzettseg(Vegzettseg vegzettseg){               //setter_oktato
        this.vegzettseg = vegzettseg;
    }

    public String toString(){                           //toString
        return "Az oktató neve "
                + nev +
                " ,akinek a kategóriája"
                + vegzettseg +
                " oktató.";
    }
}
