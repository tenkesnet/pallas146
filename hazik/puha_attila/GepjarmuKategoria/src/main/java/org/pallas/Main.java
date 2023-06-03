package org.pallas;

public class Main {

    public static void main(String[] args) {
        int ablak = 10;
        String b = "pali";

        System.out.println(b);


        //System.out.println("A gépjármű kategória két részre bontható. " +
        //        "Teherautóra és személygépjárműre.");
        TeherAuto cezar ;
        cezar = new TeherAuto("suzuki",1200,20);
        Kamion kamion = new Kamion(1,2,"fosz") ;
        Kamion kamion2 = new Kamion(1,2,"fosz") ;

        //System.out.println ((((cezar))).marka);
        //System.out.println (kamion.marka);
        Hello ok = new Hello();
        //System.out.println(ok);
        //System.out.println(ok.hashCode());
    }
    public static void fut(){

    }
}