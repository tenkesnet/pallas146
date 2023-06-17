package jatek;

public class Vadasz extends Karakter{
	
	int kiteresEsely;
	int eleresiTavolsag = 40;
	int erositettKorok;
	boolean buffed;
	String className = this.getClass().getSimpleName();
	
	Vadasz(double eletEro, double sebzes, String nev, int szint)
	{
		super(eletEro, sebzes, nev, szint);
	}
	
	public double Orvloves(){
		if (erositettKorok>0) {
			erositettKorok--;
			return super.sebzes*2;
		}
		else
			return super.sebzes;
	}
	
	
	public void Buff() {
		erositettKorok = 3;
		buffed = true;
		System.out.println("Vadasz sebzese megnovekedett a kovetkezo 3 korben!");
	}
	
	public boolean isBuffed() {
		return buffed;
	}
}
