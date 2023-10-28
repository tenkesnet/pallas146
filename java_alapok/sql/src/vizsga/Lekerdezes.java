package vizsga;

public class Lekerdezes {
    String sqlParancs;
    String kerdes;
    int oszlopSzam;
    int feladatSzam;

    public Lekerdezes(int feladatSzam,String kerdes,String parancs, int szam){
        sqlParancs=parancs;
        oszlopSzam=szam;
        this.feladatSzam=feladatSzam;
        this.kerdes=kerdes;
    }

    public String getSqlParancs() {
        return sqlParancs;
    }

    public void setSqlParancs(String sqlParancs) {
        this.sqlParancs = sqlParancs;
    }

    public String getKerdes() {
        return kerdes;
    }

    public void setKerdes(String kerdes) {
        this.kerdes = kerdes;
    }

    public int getOszlopSzam() {
        return oszlopSzam;
    }

    public void setOszlopSzam(int oszlopSzam) {
        this.oszlopSzam = oszlopSzam;
    }

    public int getFeladatSzam() {
        return feladatSzam;
    }

    public void setFeladatSzam(int feladatSzam) {
        this.feladatSzam = feladatSzam;
    }
}
