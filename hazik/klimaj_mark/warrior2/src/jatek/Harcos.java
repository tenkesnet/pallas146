package jatek;

public class Harcos extends Karakter {
	
	double visszaveresEsely;
	int eleresiTavolasag = 2;
	String className = this.getClass().getSimpleName();

	Harcos (double eletEro, double sebzes, String nev, int szint)
	{
		super(eletEro, sebzes, nev, szint);
	}
	
	@Override
	public void flee() {
		if(eletEro<= eletEroMax*0.2 && eletEro>0.0) {
		int z = talalatiEsely.rng(1,5);
		System.out.println("A harcos eselye az elmenekulesre "+z);
		for(;z>3;) { // Házi feladat megoldása
		System.out.println(nev+" elszaladt a harc elol");
		eletEro = -1;
		break;}}
	};
	
}
