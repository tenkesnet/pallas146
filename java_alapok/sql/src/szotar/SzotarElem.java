package szotar;

//POJO
public class SzotarElem {
    private String szo;
    private String lemma;
    private String szofaj;
    private int szotagszam;
    private String cv;
    private int szoGyakorisag;
    private int lemmaGyakorisag;

    public String getSzo() {
        return szo;
    }

    public void setSzo(String szo) {
        this.szo = szo;
    }

    public String getLemma() {
        return lemma;
    }

    public void setLemma(String lemma) {
        this.lemma = lemma;
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

    public int getSzoGyakorisag() {
        return szoGyakorisag;
    }

    public void setSzoGyakorisag(int szoGyakorisag) {
        this.szoGyakorisag = szoGyakorisag;
    }

    public int getLemmaGyakorisag() {
        return lemmaGyakorisag;
    }

    public void setLemmaGyakorisag(int lemmaGyakorisag) {
        this.lemmaGyakorisag = lemmaGyakorisag;
    }
}
