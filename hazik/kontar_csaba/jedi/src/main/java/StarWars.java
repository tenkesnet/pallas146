import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StarWars {
    public static void szereplok(String fajlPath) {
        List<EroErzekeny> karakterek = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fajlPath))) {
            String sor;
            while ((sor = br.readLine()) != null) {
                if (sor.contains("Anakin Skywalker")) {
                    var hanyszor=sor.split(",")[1];
                    karakterek.add(new AnakinSkywalker());
                } else if (sor.contains("Uralkodó")) {
                    karakterek.add(new Uralkodo());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (EroErzekeny karakter : karakterek) {
            if (karakter instanceof Sith) {
                Sith sithKarakter = (Sith) karakter;
                sithKarakter.engeddElAHaragod();
            }
        }

        for (EroErzekeny karakter : karakterek) {
            System.out.println(karakter.toString());
        }
    }

    public static void main(String[] args) {

        szereplok("karakterek.txt");
    }
}