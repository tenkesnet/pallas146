package alapozo;

public class Jatek {

	public static void main(String[] args) {
		Barbar barbar1= new Barbar("Józsi", 200, 20, 3);
		Barbar barbar2= new Barbar("Géza", 200, 15, 6);
		
		//barbar1.Harcol(barbar2);
		while(barbar1.Harcol(barbar2)) {
			System.out.println("Még harc van!");
		}
		
		
		
	}

}
