package jatek;

public class Harcos extends Karakter {
	
	double visszaveresEsely;
	int eleresiTavolasag = 2;
	String className = this.getClass().getSimpleName();

	Harcos (double eletEro, double sebzes, String nev, int szint)
	{
		super(eletEro, sebzes, nev, szint);
	}
	
	
	
}
