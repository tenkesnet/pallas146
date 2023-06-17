package jatek;

public class Jatek {



public static void main (String args[])
{
	Harcos karakter = new Harcos(350,50.51515414141,"Geza",18);
	Vadasz karakter1 = new Vadasz(200,72.62525252414214,"Jani",23);
		while(karakter.eletEro>0.0 && karakter1.eletEro>0.0)
		{
			
		karakter.Harcol(karakter1);
		
		if(karakter.eletEro<0.0) {
			System.out.println("A "+karakter1.className+" nyert");
		}
		if(karakter1.eletEro<0.0) {
			System.out.println("A "+karakter.className+" nyert");
		}
		
		//javitando
		if(karakter1.eletEro < karakter1.eletEroMax /2 && !karakter1.isBuffed()) {
			karakter1.sebzes = karakter1.Orvloves();
			karakter1.Buff();
		}
		}
		karakter.printFinalRound();
		
}
}