abstract class Termek {
 private String nev;
 protected int egysegar;

 public Termek(String nev, int egysegar) {
  this.nev = nev;
  this.egysegar = egysegar;
 }
 protected int mennyibeKerul() {
  return egysegar;
 }
 @Override
    public String toString() {
         return nev + " - " + mennyibeKerul() + " Ft";
     }

}
