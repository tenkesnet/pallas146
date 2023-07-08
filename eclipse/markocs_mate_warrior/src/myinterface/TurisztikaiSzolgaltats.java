package myinterface;

public class TurisztikaiSzolgaltats {
    public double osszBevetel;
    public static double afa = 18;

    public TurisztikaiSzolgaltats(double osszBevetel) {
        this.osszBevetel = osszBevetel;
    }

    public static void setAfa(double afa){
        TurisztikaiSzolgaltats.afa=afa;
    }

    public static String getSzolgaltatasok(){
        return "vendeglatas,turavezetes";
    }

    public String getAfaTartalom(){
        return String.format("A(z) %.2f %% áfatartalom = %.2f",afa,osszBevetel*afa/100);
    }
}
