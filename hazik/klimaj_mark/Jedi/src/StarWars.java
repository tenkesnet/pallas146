import java.io.*;
import java.util.ArrayList;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StarWars {
    static ArrayList<AnakinSkywalker> anakins = new ArrayList<>();
    static ArrayList<Uralkodo> uralkodos = new ArrayList<>();
    public static String SZEREPLOKFILE = "/szereplok.txt";

    public static void main(String[] args) {
        String currentWorkingDirectory = System.getProperty("user.dir");
        Path filePath = Paths.get(currentWorkingDirectory, SZEREPLOKFILE);
        File file = filePath.toFile();


        szereplok(file);
        sithek();

    }

    static void szereplok(File filepath){
        String line;

        int count =0, aSCount=0, uCount = 0;
        try {
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        while((line = reader.readLine()) != null){
            count++;
            if(line.equals("Anakin Skywalker")){
                aSCount++;
            }
            if(line.equals("Uralkodo")){
                uCount++;
            }
        }
        for(int i=0; i<aSCount;i++)
        {
            AnakinSkywalker anakin =new AnakinSkywalker();
            anakin.engeddElAHaragod();
            anakins.add(anakin);
        }

        for(int i=0; i<uCount;i++){
            Uralkodo uralkodo = new Uralkodo();
            uralkodo.engeddElAHaragod();
            uralkodos.add(uralkodo);
        }

            System.out.printf(String.format("Összes sor a fájlban %d ", count));

            System.out.printf(String.format("Anakin %d  darab , Uralkodo %d darab \n", aSCount,uCount));
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    static void sithek(){

        for(AnakinSkywalker aS : anakins ){
        System.out.printf("Mekkora az ereje?: %f Megteremti az egyensúlyt: %b \n",
                aS.mekkoraAzEreje(),
                aS.megteremtiAzEgyensulyt());}
        for(int i = 0; i<uralkodos.size();i++){
        System.out.printf("Mekkora az ereje?: %f Legyőzi-e az ellenfelét: %b \n",
                uralkodos.get(i).mekkoraAzEreje(),
                uralkodos.get(i).LegyoziE(anakins.get(i)));}
}
}