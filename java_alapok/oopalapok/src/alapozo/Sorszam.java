package alapozo;

public class Sorszam {
    private double i;
    public Sorszam(){
        i=0;
    }
    public Sorszam(double values){
        i=values;
    }
    public void increment(){
        i++;
    }
    public void increment(double values){
        i+=values; //i = i+ values
    }
    public double get(){
        return i;
    }
}
