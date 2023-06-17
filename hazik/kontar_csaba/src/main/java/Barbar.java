public class Barbar extends Harcos {
    private double kozelharciSzerencse;

    public Barbar(String nev, double eletEro, double sebzesiEro, double kozelharciSzerencse) {
        super(nev, eletEro, sebzesiEro);
        this.kozelharciSzerencse = kozelharciSzerencse;
    }

    @Override
    public boolean sebzes (double ero) {
        //System.out.println("Barbar sebzés!");
        super.sebzes(ero + kozelharciSzerencse);
        setEletEro(getEletEro()-ero);
        if(getEletEro()<=0) {
            return false;
        }
        return true;
    }
}
