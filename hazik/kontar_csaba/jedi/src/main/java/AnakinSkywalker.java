
import java.util.Random;

class AnakinSkywalker extends Jedi implements Sith {
    public AnakinSkywalker() {
        super(150, true);
    }

    @Override
    public void engeddElAHaragod() {
        Random rand = new Random();
        double powerIncrease = rand.nextDouble() * 10;
        setEro(getEro() + powerIncrease);
    }

    @Override
    public boolean megteremtiAzEgyensulyt() {
        return getEro() > 1000;
    }

    @Override
    public String toString() {
        return "Anakin Skywalker: " + super.toString();
    }
}
