package alapozo;

public class Magus extends Harcos {
	private double kozelharciSzerencse;

	public Magus(String nev, double eletEro, double sebzesiEro, double kozelharciSzerencse) {
		super(nev, eletEro, sebzesiEro);
		this.kozelharciSzerencse = kozelharciSzerencse;
	}
}
