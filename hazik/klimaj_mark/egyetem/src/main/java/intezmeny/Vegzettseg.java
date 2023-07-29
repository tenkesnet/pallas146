package Hazifeladat.intezmeny;



public class Vegzettseg {

    private String szak;
    private Egyetem egyetem;

    public Vegzettseg(String szak, Egyetem egyetem) {
        this.szak = szak;
        this.egyetem = egyetem;
    }


    public String getSzak() {
        return szak;
    }

    public void setSzak(String szak) {
        this.szak = szak;
    }

    public Egyetem getEgytem() {
        return egyetem;
    }

    public void setEgytem(Egyetem egyetem) {
        this.egyetem = egyetem;
    }

    @Override
    public String toString() {
        return String.format("Végzettsége: %s \n Egyetem : "+egyetem.toString(),szak);
    }
}
