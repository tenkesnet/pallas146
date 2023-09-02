public class RohadtParadicsom extends Termek implements Akciozhato {
    protected double tomeg;

    public RohadtParadicsom(double tomeg, int egysegar) {
        super("Rohadt paradicsom", egysegar);
        this.tomeg = tomeg;
    }
    @Override
    protected int mennyibeKerul(){
        return (int) Math.round(tomeg * egysegar);
    }
    @Override
    public int akciosAr() {
        return (int) Math.round(egysegar * 0.8);
    }
    @Override
    public String toString() {
        return String.format("%1f kg rohadt paradicsom - %d Ft (akciosAr : %d Ft", tomeg, mennyibeKerul(), akciosAr());
    }
}
