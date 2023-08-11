import java.util.Random;
public class AnakinSkywalker extends Jedi implements Sith {

    Random rand = new Random();
    float randN = rand.nextFloat(0,10);
    AnakinSkywalker() {
        super(150, true);
    }

    @Override
    public boolean megteremtiAzEgyensulyt() {
        return getEro()>1000;
    }

    @Override
    public void engeddElAHaragod() {
        setEro(getEro()*randN);
    }

    public String toString(){
        return String.format("Anakin Skywalker:\nEreje: %f \n Áruló: %b",getEro(),isAtallhatE());
    }



}
