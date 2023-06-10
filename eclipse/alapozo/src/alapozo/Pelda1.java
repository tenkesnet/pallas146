package alapozo;

class Inc{
	private int value;
	
	public void inc(int incValue) {
		value+=incValue;
	}
	
	public int getValue() {
		return value;
	}
}

public class Pelda1 {
	String nev;
	public boolean vizsgal(Inc vizsgalando,int hatarertek) {
		//System.out.println("Vizsgalat:  "+vizsgalando.getValue()+"<"+hatarertek);
		vizsgalando.inc(1);
		return vizsgalando.getValue()<hatarertek;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] nevek = { "Robi", "Gizi", "Jani", "a","b" };
		// String[] nevek = { "Robi" };
		
		Inc jref=new Inc();
		Inc iref=new Inc();
		Pelda1 pelda= new Pelda1();
		Pelda1 pelda2 = new Pelda1();
		pelda.nev="valami";
		pelda2.nev="valami";
		pelda2.nev="valami2";
		for(;(pelda.vizsgal(jref, nevek.length) && pelda.vizsgal(iref, nevek.length));) {
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
