package myinterface;

public class Main {
    public static void main(String[] args) {
        TurisztikaiSzolgaltats szallasadas = new TurisztikaiSzolgaltats(4500);
        TurisztikaiSzolgaltats turavezetes = new TurisztikaiSzolgaltats(3500);

        // kódrészlet

        TurisztikaiSzolgaltats.setAfa(20);

        //kódrészletek

        System.out.println("Szallasadás áfa: " + szallasadas.getAfaTartalom());
        System.out.println("Turavezetés áfa: " + turavezetes.getAfaTartalom());
    }
}
