package jatek;

public class Jatek {

	public static void main(String[] args) {
		Harcos kihivo = new Harcos(350, 50.51515414141, "Geza", 18);
		Vadasz ellenfel = new Vadasz(200, 72.62525252414214, "Jani", 23);
		while (kihivo.eletEro > 0.0 && ellenfel.eletEro > 0.0) {

			kihivo.Harcol(ellenfel);

			if (kihivo.eletEro < 0.0) {
				System.out.println("A " + ellenfel.nev + " a (" + ellenfel.className + ") nyert");
			}
			if (ellenfel.eletEro < 0.0) {
				System.out.println("A " + kihivo.nev + " a (" + kihivo.className + ") nyert");
			}
			// javitando
			if (ellenfel.eletEro < ellenfel.eletEroMax / 2 && !ellenfel.isBuffed() && kihivo.eletEro>0.0) {
				ellenfel.Buff();
				ellenfel.sebzes = ellenfel.Orvloves();
			} else if (ellenfel.isBuffed()) {
				ellenfel.sebzes = ellenfel.Orvloves();
			}
			kihivo.checkHP();
			ellenfel.checkHP();
			kihivo.flee();
		}
		kihivo.printFinalRound();

	}
}