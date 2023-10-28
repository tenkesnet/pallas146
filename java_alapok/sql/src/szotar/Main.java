package szotar;


import vizsga.Feladatok;
import vizsga.Lekerdezes;

import java.sql.PreparedStatement;

public class Main {

	public static void main(String[] args) {
		SzotarUtil util = new SzotarUtil();
		long start = System.currentTimeMillis();
		//util.loadSzavak("/home/bardo/repo/pallas/pallas146/magyar-szavak-kat.txt");
		util.loadSzavakDB();
		long stop = System.currentTimeMillis();
		System.out.println("Futási idő: " + (stop - start) + "ms");

		System.out.println(String.format("A max mássalhangzójú szi: %s", util.getMaxMassalhangzo()));
		Feladatok f = new Feladatok();
		for(Lekerdezes l : f.getKerdesek()){
			//PreparedStatement st = c.prepareStatement(l.getSqlParancs());
		}
		/*System.out.println("--------------------");
		System.out.println("Most kezdődik az insert.");
		start = System.currentTimeMillis();
		//util.insertSzavak();
		stop = System.currentTimeMillis();
		System.out.println("Futási idő: " + (stop - start) + "ms");
		*/
	}

}
