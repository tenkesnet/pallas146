package jatek;

public class Karakter {
	double eletEro;
	double eletEroTruncated;
	double sebzes;
	double sebzesTruncated; // befejezetlen kerekítés ref.: ua.
	String nev;
	int szint;
	int eleresiTavolsag;
	int kor;
	GenerateRandom talalatiEsely = new GenerateRandom();
	double eletEroMax;

	public Karakter(double eletEro, double sebzes, String nev, int szint) {
		this.eletEro = talalatiEsely.round(eletEro + (eletEro * (szint * 0.035)), 3);
		this.nev = nev;
		this.sebzes = talalatiEsely.round(sebzes + (sebzes * (szint * 0.015)), 3);
		this.szint = szint;
		this.eletEroMax = this.eletEro;
	}

	public void Harcol(Karakter ellenfel) {
		boolean isTalaltE = ellenfel.utes(talalatiEsely.rng(0, 100));
		boolean isTalaltP = utes(talalatiEsely.rng(0, 100));

		if (isTalaltP) {
			ellenfel.eletEro = ellenfel.eletEro - this.sebzes;
			System.out.println("Talalt! " + talalatiEsely.round(this.sebzes, 3) + " Sebzes kiosztva");
			System.out.println(ellenfel.nev + " jelenlegi eletereje:" + talalatiEsely.round(ellenfel.eletEro, 3));
		} else
			System.out.println(ellenfel.nev + " tamadasa melle!");

		if (ellenfel.eletEro > 0) {
			if (isTalaltE) {
				this.eletEro = this.eletEro - ellenfel.sebzes;
				System.out.println("Talalt! " + ellenfel.sebzes + " Sebzes elszenvedve");
				System.out.println(nev + " jelenlegi eletereje:" + this.eletEro);
			} else
				System.out.println(nev + " tamadasa melle");
			kor++;
		}
	}

	public boolean utes(int talalatiEsely) {

		return (talalatiEsely > 50);

	}

	public void printFinalRound() {
		System.out.println("A harc " + kor + ". korig tartott");
	}

}