package szotar;

public class SzotarElem {
    private String szo;
    private String lemming;
    private String szofaj;
    private int szotagszam;

    private String cv;

    public String getSzo() {
        return szo;
    }

    public void setSzo(String szo) {
        this.szo = szo;
    }

    public String getLemming() {
        return lemming;
    }

    public void setLemming(String lemming) {
        this.lemming = lemming;
    }

    public String getSzofaj() {
        return szofaj;
    }

    public void setSzofaj(String szofaj) {
        this.szofaj = szofaj;
    }

    public int getSzotagszam() {
        return szotagszam;
    }

    public void setSzotagszam(int szotagszam) {
        this.szotagszam = szotagszam;
    }

    public String getCv() { return cv; }

    public void setCv(String cv) { this.cv = cv;  }
}
