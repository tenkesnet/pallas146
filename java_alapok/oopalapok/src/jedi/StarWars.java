package jedi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StarWars {
    public static ArrayList<EroErzekeny> lista =new ArrayList<EroErzekeny>() ;

    public static void szereplok(String path) throws IOException,FileNotFoundException {
        BufferedReader br = new BufferedReader (new FileReader( path ) ) ;
        String line = br.readLine () ;
        while ( line != null ) {
            String [] szavak = line.split (" ") ;
            if ( szavak[0].equals ("Anakin") ) {
                AnakinSkywalker a =new AnakinSkywalker () ;
                for ( int i =0; i < Integer.parseInt( szavak[1]); i++) {
                    a.engeddElAHaragod () ;
                }
                lista.add ( a ) ;
            } else if ( szavak[0].equals("Uralkodo") ) {
                Uralkodo a =new Uralkodo () ;
                for ( int i =0; i < Integer.parseInt(szavak[1]); i++) {
                    a.engeddElAHaragod () ;
                }
                lista.add(a) ;
            } else {
                System.out.println("Rossz sor ") ;
            }
            line = br.readLine () ;
        }
        br.close () ;
    }

    public static void sithek() {
        for(int i =0; i < lista.size() ; i++) {
            System.out.println ( lista.get(i).toString() ) ;
        }
    }

    public static void main(String[] args) {
        try {
            szereplok("input.txt");
            sithek();
        } catch(Exception ex) {
            System.out.println("Hiba tortent a filebeolvasás közben.") ;
        }
    }
}
