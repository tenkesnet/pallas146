package jatek;

public class Karakter implements IKarakter {
	double eletEro;
	double sebzes;
	String nev;
	int szint;
	int eleresiTavolsag;
	int kor=1;
	GenerateRandom talalatiEsely = new GenerateRandom();
	double eletEroMax;

	public Karakter(double eletEro, double sebzes, String nev, int szint) {
		this.eletEro = talalatiEsely.round(eletEro + (eletEro * (szint * 0.035)), 2);
		this.nev = nev;
		this.sebzes = talalatiEsely.round(sebzes + (sebzes * (szint * 0.015)), 2);
		this.szint = szint;
		this.eletEroMax = this.eletEro;
	}

	public void Harcol(Karakter ellenfel) {
		boolean isTalaltE = ellenfel.utes(talalatiEsely.rng(0, 100));
		boolean isTalaltP = utes(talalatiEsely.rng(0, 100));

		if (isTalaltP) {
			ellenfel.eletEro = ellenfel.eletEro - this.sebzes;
			System.out.println(nev+" Talalt! " + talalatiEsely.round(this.sebzes, 2) + " Sebzes kiosztva");
		} else
			System.out.println(nev + " tamadasa melle!");

		if (ellenfel.eletEro > 0) {
			if (isTalaltE) {
				this.eletEro = this.eletEro - ellenfel.sebzes;
				System.out.println(ellenfel.nev+" Talalt! " + talalatiEsely.round(ellenfel.sebzes,2) + " Sebzes elszenvedve");
			} else
				System.out.println(ellenfel.nev + " tamadasa melle");
			System.out.println("Vege a(z) "+kor+". kornek\n");
			kor++;
		}
	}

	public boolean utes(int talalatiEsely) {

		return (talalatiEsely > 50);

	}

	public void printFinalRound() {
		System.out.println("A harc " + kor + ". korig tartott");
	}
	
	@Override
	public void flee() {
		System.out.println(nev+" elszaladt a harc elől");
		System.out.println(this.eletEroMax);
		this.eletEro = -1;
	};
	
	@Override
	public void checkHP()
	{
		System.out.println("----------------------");
		System.out.println(this.nev+" jelenlegi eletereje: "+talalatiEsely.round((this.eletEro),2));
		System.out.println("Eddig elszenvedt sebzes: "+(talalatiEsely.round((this.eletEroMax-this.eletEro),2))+"\n");
		
	};
	
	public void checkDMG() {
		
	}
	
}