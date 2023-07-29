package Intezmeny;

public class Vegzettseg {

    private String szak;                                        //property_szak

    private String egyetem;                                     //property_egyetem

    public Vegzettseg (String szak, String egyetem){            //constructor_Vegzettseg
        this.szak = szak;
        this.egyetem = egyetem;
    }

    public String getSzak(){                                    //getter_szak
        return szak;
    }

    public String getEgyetem(){                                 //getter_egyetem
        return egyetem;
    }

    public void setSzak(String szak){                           //setter_szak
        this.szak = szak;
    }

    public void setEgyetem(String egyetem){                     //setter_egyetem
        this.egyetem = egyetem;
    }

    public String toString(){                                   //toString
        return "A végzettség az "
                + egyetem +
                " egyetem"
                + szak +
                " szakán szerezhető meg.";
    }

}
