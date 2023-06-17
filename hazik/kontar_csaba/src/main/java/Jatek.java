
public class Jatek {
    private static Object i;

    public static void main(String[] args) {
        Barbar barbar1 = new Barbar("Józsi", 200, 20, 3);
        Barbar barbar2 = new Barbar("Géza", 200, 15, 6);

        barbar1.Harcol(barbar2);
        while (barbar1.Harcol(barbar2)) {
            System.out.println("Még harc van!");

        }

        if (barbar1.getEletEro() <= 0) {

            System.out.println("Géza nyert!");

        }

        else {
            System.out.println("Józsi nyert!");
        }

    }
}