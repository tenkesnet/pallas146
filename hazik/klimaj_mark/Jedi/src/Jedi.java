public class Jedi implements EroErzekeny {

    private float ero;
    private boolean atallhatE;

    Jedi(float inputero, boolean atallhatE){
        this.ero = inputero;
        this.atallhatE = atallhatE;
    }

    @Override
    public boolean LegyoziE(EroErzekeny e) {

        if (e instanceof Uralkodo uralkodo){
            return atallhatE && (this.ero > uralkodo.mekkoraAzEreje());
        }
        else if(e instanceof Jedi jedi) {
        return atallhatE && (this.ero>jedi.mekkoraAzEreje());
        }
        else {
            return false;
        }
    }


    @Override
    public float mekkoraAzEreje() {
        return this.ero;
    }

    public boolean megteremtiAzEgyensulyt() {
        return false;
    }

    public float getEro() {
        return ero;
    }

    public void setEro(float ero) {
        this.ero = ero;
    }

    public boolean isAtallhatE() {
        return atallhatE;
    }

    public void setAtallhatE(boolean atallhatE) {
        this.atallhatE = atallhatE;
    }

    @Override
    public String toString(){


        return String.format("Ereje %f \nÁruló: %b ", this.ero,this.isAtallhatE());
    }
}
