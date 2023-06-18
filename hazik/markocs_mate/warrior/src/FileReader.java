import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public static void readFileToList(String filePathName, List<String> list) {
        try {
            File myFile = new File(filePathName);
            Scanner file = new Scanner(myFile);
            while (file.hasNextLine()) {
                String data = file.nextLine();
                list.add(data);
            }
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nincs ilyen fájl!");
            e.printStackTrace();
        }
    }
}
