package Intezmeny;

public class Egyetem {

    private String nev;

    private String varos;

    public Egyetem(String nev, String varos){
        this.nev = nev;
        this.varos = varos;
    }

    public String getNev(){                            //getter_nev
        return nev;
    }

    public String getVaros (){                          //getter_varos
        return varos;
    }

    public void setNev(String nev){                     //setter_nev
        this.nev = nev;
    }

    public void setVaros(String varos){                 //setter_varos
        this.varos = varos;
    }


    @Override
    public String toString() {
        return "Egyetem{" +
                "nev='" + nev + '\'' +
                ", varos='" + varos + '\'' +
                '}';
    }


}
