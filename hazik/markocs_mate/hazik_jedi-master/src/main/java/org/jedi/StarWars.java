package org.jedi;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StarWars {

    public static List<IEroErzekeny> szereplok(String filePath){
        BufferedReader reader;
        List<IEroErzekeny> szereplokLista = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();

            while (line != null) {
                if (line.equals("Anakin Skywalker")){
                    szereplokLista.add(new AnakinSkywalker());
                } else if (line.equals("Uralkodó")){
                    szereplokLista.add(new Uralkodo());
                } else {
                    for (int i = 0; i < Integer.parseInt(line); i++){
                    szereplokLista.get(szereplokLista.size()-1).engeddElAHaragor();
                    }
                }
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return szereplokLista;
    }
}
