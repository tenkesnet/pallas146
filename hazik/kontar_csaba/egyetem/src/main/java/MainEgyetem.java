import Oktatas.Kurzus;
import Oktatas.Oktato;
import intezmeny.Egyetem;
import intezmeny.Vegzettseg;

public class MainEgyetem {
    public static void main(String[] args) {
        Egyetem egyetem1 = new Egyetem("BME", "Budapest");
        Egyetem egyetem2 = new Egyetem("Debreceni Egyetem", "Debrecen");


        Vegzettseg vegzettseg1 = new Vegzettseg("Informatika", egyetem1);
        Vegzettseg vegzettseg2 = new Vegzettseg("Jogász", egyetem2);

        Oktato oktato1 = new Oktato("Kovács János", vegzettseg1);
        Oktato oktato2 = new Oktato("Molnár László", vegzettseg2);


        Kurzus[] kurzusok = new Kurzus[4];
        kurzusok[0] = new Kurzus("Matematika", oktato1);
        kurzusok[1] = new Kurzus("Java", oktato1);
        kurzusok[2] = new Kurzus("Polgári jog", oktato2);
        kurzusok[3] = new Kurzus("Adatvédelmi jog", oktato2);

        //Kurzusok kiírása
        for (Kurzus kurzus : kurzusok) {
            System.out.printf(kurzus.toString());
        }
        String varosNev = "Budapest";

        int oktatoSzam = MainEgyetem.countOktatokbyVaros(kurzusok, varosNev);
        System.out.println("A megadott városban lévő kurzus oktatóinak száma: " + oktatoSzam);
    }

    public static int countOktatokbyVaros(Kurzus[] kurzusok, String varos) {
        int count = 0;
        for (Kurzus kurzus : kurzusok) {
            if (kurzus.getOktato().getVegzettseg().getEgyetem().getVaros().equals(varos)) {
                count++;
            }
        }
        return count;
    }
}

