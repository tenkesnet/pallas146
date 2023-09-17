package alapozo;

public class OOPStream {
	public static void main(String[] args) {
		StreamExamples streamExamples = new StreamExamples();
			

		// streamExamples.reduce();
		// StreamAdvanced.illegalStateException();
		streamExamples.dolgozokBeolvasasa();
		// streamExamples.primitivStreamek();

		/*
		 * int i = 4; int j = 3; System.out.println(i + ++j); // i=4 ; j=4
		 * System.out.println(i++ + j++); // i=5 ; j=5 System.out.println(++i + j++); //
		 * i=6 ; j=6 System.out.println(i + j);
		 * 
		 * int i2 = 1, z = 0; System.out.println(i2++ + ++i2); System.out.println(z); i
		 * = 0; System.out.println(i++ == ++i); // false
		 * 
		 * int a = 15; if (a == 15) { int xy = i;
		 * System.out.println("\"a\" \n \t értéke = 15"); }
		 * 
		 * a *= 2; System.out.println(a);
		 */

		StreamAdvanced streamAdvanced = new StreamAdvanced();
		long start = System.currentTimeMillis();
		streamAdvanced.loadSzavak("/home/bardo/repo/pallas/pallas146/magyar-szavak.txt");
		long stop = System.currentTimeMillis();
		System.out.println("Futási idő: " + (stop - start) + "ms");
	}
}
