package jatek;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Karakter {
	double eletEro;
	double eletEroTruncated =BigDecimal.valueOf(eletEro)
			.setScale(3, RoundingMode.HALF_UP)
			.doubleValue(); //befejezetlen kerekítés ref.:https://stackoverflow.com/questions/14845937/java-how-to-set-precision-for-double-value
	double sebzes;
	double sebzesTruncated =BigDecimal.valueOf(sebzes)
			.setScale(3, RoundingMode.HALF_UP)
			.doubleValue(); //befejezetlen kerekítés ref.: ua.
	String nev;
	int szint;
	int eleresiTavolsag;
	int kor;
	generateRandom talalatiEsely = new generateRandom();
	double eletEroMax;
	
	Karakter(double eletEro, double sebzes, String nev,int szint){
		this.eletEro = eletEro+(eletEro*(szint*0.035));
		this.nev = nev;
		this.sebzes = sebzes+(sebzes*(szint*0.015));
		this.szint = szint;
		this.eletEroMax= this.eletEro;
	}
	
	public void Harcol(Karakter ellenfel) {
		boolean isTalaltE = ellenfel.utes(talalatiEsely.rng());
		boolean isTalaltP = utes(talalatiEsely.rng());
		
		if(this.eletEro>0.0 && ellenfel.eletEro>0) {
		if(isTalaltP)
		{
			ellenfel.eletEro = ellenfel.eletEro-this.sebzes;
			System.out.println("Talalt! "+this.sebzes+" Sebzes kiosztva");
			System.out.println("Ellenfel jelenlegi eletereje:"+ellenfel.eletEro);
			}
			
		else
			System.out.println("Ellenfel tamadasa melle!");}
		
		if(this.eletEro>0.0 && ellenfel.eletEro>0) {
		if(isTalaltE) {
			this.eletEro = this.eletEro - ellenfel.sebzes;
			System.out.println("Talalt! "+ellenfel.sebzes+" Sebzes elszenvedve");
			System.out.println("Tamado jelenlegi eletereje:"+this.eletEro);
		}
		else
			System.out.println("Tamado tamadasa melle");
		kor++;
		}}
	
	public boolean utes(int talalatiEsely) {
		
		return (talalatiEsely>50);

	}
	
    public void printFinalRound() {
        System.out.println("A harc " + kor + ". korig tartott");
    }
	
}