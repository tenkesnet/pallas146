package alapozo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Pelda1 {
	String nev;

	public boolean vizsgal(Inc vizsgalando, int hatarertek) {
		// System.out.println("Vizsgalat: "+vizsgalando.getValue()+"<"+hatarertek);
		vizsgalando.inc(1);
		return vizsgalando.getValue() < hatarertek;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String[] nevek = { "Robi", "Gizi", "Jani", "a", "b" };
		// String[] nevek = { "Robi" };

		Inc jref = new Inc();
		Inc iref = new Inc();

		Pelda1 pelda = new Pelda1();
		Pelda1 szamar = new Pelda1();
		try {
			System.out.println(szamar.nev.length());
		} catch (NullPointerException e) {
			System.out.println("bakker vétettél!");
			System.exit(0);
		}
		
		BufferedReader in;

		String fileName = "birka.txt";
		try {
			in = new BufferedReader(new FileReader(fileName));
		} catch (IOException e) {
			System.out.println("nemtudtam megnyitni a " + fileName + "-t filet!");
			System.exit(0);
		}

		pelda.nev = "valami";
		szamar.nev = "valami";
		szamar.nev = "valami2";
		for (; (pelda.vizsgal(jref, nevek.length) && pelda.vizsgal(iref, nevek.length));) {
			System.out.println(nevek[jref.getValue()]);
		}

//		if (nevek.length >= 5) {
//			System.out.println("A nevek tömb hossza nagyobb vagy egyenlő 5");
//		} else if (nevek.length > 2) {
//			System.out.println("A nevek tömb hossza nagyobb 2");
//		} else {
//			System.out.println("A nevek tömb hossz nem elegendő!");
//		}

	}

}
