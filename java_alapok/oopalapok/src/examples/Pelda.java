package examples;

public class Pelda {
    public static void main(String[] args) {
        Alkalmazott dolgozo =new Alkalmazott("Tibor", 250000, 63);
        Alkalmazott dolgozo2=new Alkalmazott("Jani", 200000, 55);
        System.out.println(dolgozo);
        dolgozo.fizetesEmel(20000);
        System.out.println(dolgozo);
        dolgozo.fizetesEmel(dolgozo2);
        System.out.println("Tibor többet keres Janinál: "+dolgozo2.tobbetKeresE(dolgozo));
        System.out.println("Tibor közepes jövedelemmel rendelkezik: " +dolgozo.kozepesJovedelmu(100000,220000));
        System.out.println("Tibornak "+dolgozo.hatraVan()+" év van hátra a nyugdijig");
        System.out.println("Janinak "+dolgozo2.hatraVan()+" év van hátra a nyugdijig");
        Alkalmazott.nyugdijKorhatarEmeles();
        System.out.println("Tibornak "+dolgozo.hatraVan()+" év van hátra a nyugdijig a korhatár emelés után");
        System.out.println("Janinak "+dolgozo2.hatraVan()+" év van hátra a nyugdijig a korhatár emelés után");
        System.out.println(dolgozo.evesSzabadsag());
    }
}