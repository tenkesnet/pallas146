package vizsga;

import java.util.ArrayList;

public class Feladatok {
    ArrayList<Lekerdezes> kerdesek = new ArrayList<>();

    public Feladatok(){
        kerdesek.add(new Lekerdezes(5,
                "Irassa ki az egyes autók típusát, a vásárlás idejét és a beszerzési árat!",
                "select t.tipus_nev,a.vasarlas_datuma,a.ar from autok a join tipusok t ON a.tipusok_id = t.id",
                3));

        kerdesek.add(new Lekerdezes(6,
                "Irassa ki SELECT utasítással az AUTOK táblából az összes autó rendszámát, típusát és árát! A kiírás az ár szerinti csökkenő sorrendben történjen!",
                "select a.rendszam, t.tipus_nev, a.ar from autok a join tipusok t on a.tipusok_id = t.id;", 3));
    }

    public ArrayList<Lekerdezes> getKerdesek() {
        return kerdesek;
    }

    public void setKerdesek(ArrayList<Lekerdezes> kerdesek) {
        this.kerdesek = kerdesek;
    }
}
