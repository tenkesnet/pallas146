package jedi;

public class AnakinSkywalker extends Jedi implements Sith{
    public AnakinSkywalker () {
        super(150 , true ) ;
    }

    public void engeddElAHaragod () {
        this.ero +=( Math . random () *10) ;
    }

    public boolean megteremtiAzEgyensulyt () {
        return this.ero > 1000 ? true : false ;
    }

    @Override
    public String toString () {
        return "AnakinSkywalker " + super.toString () ;
    }
}
