
public class Jatek {
    private static Object i;

    public static void main(String[] args) {
        final Barbar barbar1 = new Barbar("Józsi", 200, 201, 3);
        final Barbar barbar2 = new Barbar("Géza", 200, 15, 6);

        int korokSzama = 0;

        barbar1.nev = "jkhkhk";
        for (; barbar1.Harcol(barbar2, korokSzama);) {
            barbar2.gyogyul();
            korokSzama++;

        }

        if (barbar1.getEletEro() <= 0) {

            System.out.println("Géza nyert!");

        }

        else {
            System.out.println("Józsi nyert!");
        }

    }
}