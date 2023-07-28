package intezmeny;

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

    public Egyetem getEgyetem() {
        return egyetem;
    }

    public void setEgyetem(Egyetem egyetem) {
        this.egyetem = egyetem;
    }
    @Override
    public String toString()  {
        return String.format("Ez a(z) %s vegzettséget %s biztosítja.",szak,egyetem);
    }

}
