package org.pallas;

public class Macska {
    int bolhaSzam=3;
    Main ref1 = new Main();

    public Macska(){
    }
    public Macska(int bolhaSzam){
        this.bolhaSzam=bolhaSzam;
    }
    public Macska(Main ref1){
        this.ref1=ref1;
    }

    public void setRef1(Main ref1){
        this.ref1=ref1;
    }

    public int osszead(int a , int b ){
        return a+b;
    }

    public String osszead(int i, float j){
        return String.valueOf(i)+String.valueOf(j);
    }
    public static void main(String[] parameterek) {
        int primitiv1=4;
        int primitiv2=primitiv1;
        Macska cirmi1 = new Macska();
        Macska cirmi2 = new Macska(5);
        Macska cirmi3 = new Macska(cirmi1.ref1);
        cirmi2.setRef1(cirmi3.ref1);
        int a =5;
        float b =2;
        System.out.println(cirmi1.osszead(1,2));
        System.out.println(cirmi2.osszead(a,b));
        //System.out.println(cirmi3.osszead(1,2f));
    }
}
