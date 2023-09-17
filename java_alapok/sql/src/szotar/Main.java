package szotar;


public class Main {

	public static void main(String[] args) {
		SzotarUtil util = new SzotarUtil();
		long start = System.currentTimeMillis();
		util.loadSzavak("/home/bardo/repo/pallas/pallas146/magyar-szavak-kat.txt");
		long stop = System.currentTimeMillis();
		System.out.println("Futási idő: " + (stop - start) + "ms");

	}

}
