public class Uralkodo implements EroErzekeny,Sith{

    float gonoszsag;

    @Override
    public boolean LegyoziE(EroErzekeny e) {
        return e != null && e.mekkoraAzEreje() < this.gonoszsag;
    }

    @Override
    public float mekkoraAzEreje(){
    return this.gonoszsag*2;
    };

    @Override
    public void engeddElAHaragod() {
    gonoszsag+=50;
    }

    Uralkodo(){
        gonoszsag=100;
    }


    public String toString(){
        return String.format("Uralkodó, gonoszsága: %f",gonoszsag);
    }

}
