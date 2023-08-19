package alapozo;

public class Sorszam {
    private int i;
    public Sorszam(){
        i=0;
    }
    public Sorszam(int values){
        i=values;
    }
    public void increment(){
        i++;
    }
    public int get(){
        return i;
    }
}
