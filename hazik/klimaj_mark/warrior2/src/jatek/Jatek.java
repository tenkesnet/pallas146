package jatek;

public class Jatek {

	public static void main(String[] args) {
		Harcos karakter1 = new Harcos(350, 50.51515414141, "Geza", 18);
		Vadasz karakter2 = new Vadasz(200, 72.62525252414214, "Jani", 23);
		while (karakter1.eletEro > 0.0 && karakter2.eletEro > 0.0) {

			karakter1.Harcol(karakter2);

			if (karakter1.eletEro < 0.0) {
				System.out.println("A " + karakter2.nev + " a (" + karakter2.className + ") nyert");
			}
			if (karakter2.eletEro < 0.0) {
				System.out.println("A " + karakter1.nev + " a (" + karakter1.className + ") nyert");
			}
			// javitando
			if (karakter2.eletEro < karakter2.eletEroMax / 2 && !karakter2.isBuffed() && karakter1.eletEro>0.0) {
				karakter2.Buff();
				karakter2.sebzes = karakter2.Orvloves();
			} else if (karakter2.isBuffed()) {
				karakter2.sebzes = karakter2.Orvloves();
			}
			karakter1.checkHP();
			karakter2.checkHP();
			karakter1.flee();
		}
		karakter1.printFinalRound();

	}
}