package org.leszarmazas;

public class HarciJarmu {
    private String gyarto;
    private int suly;
	private int hossz;
    private int magassag;
    private int szelesseg;
    private boolean isFelfegyverzett;

    protected HarciJarmu(String gyarto, int suly, int hossz, int magassag, int szelesseg, boolean isFelfegyverzett){
        this.gyarto = gyarto;
        this.suly = suly;
        this.hossz = hossz;
        this.magassag = magassag;
        this.szelesseg = szelesseg;
        this.isFelfegyverzett = isFelfegyverzett;
    }
    
    public HarciJarmu() {
    	
    }
    protected void gyartoKiiras(){
        System.out.println(this.gyarto);
    }

	public String getGyarto() {
		return gyarto;
	}
	public int getSuly() {
		return suly;
	}

	public void setSuly(int suly) {
		this.suly = suly;
	}
}
