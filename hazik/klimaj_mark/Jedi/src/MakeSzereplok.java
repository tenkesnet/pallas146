import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MakeSzereplok {
    public static void main(String[] args){
        int log =0;
        try{
            File myObj = new File("szereplok.txt");
        if(myObj.createNewFile()) {
            System.out.printf("File created %s\n",myObj.getName());
            log = 0;
        }
        else{
            System.out.println("File already exists");
            log =1;
        }
    } catch(IOException e)
        {
            System.out.println("Error in creating file");
            e.printStackTrace();
            log = 2;
        }
        switch (log) {
            case 0 -> System.out.println("Trying to write ");
            case 1 -> System.out.println("Rewriting file");
            case 2 -> System.out.println("Something wrong happened");
        }
    try{
        FileWriter myWriter = new FileWriter("szereplok.txt");
        myWriter.write("Anakin Skywalker\n");
        myWriter.write("Anakin Skywalker\n");
        myWriter.write("Anakin Skywalker\n");
        myWriter.write("Uralkodo\n");
        myWriter.write("Uralkodo\n");
        myWriter.append("Uralkodo\n");  
        myWriter.close();
        switch (log){
            case 0 -> System.out.println("Write to file succeeded, file closed...");
            case 1 -> System.out.println("Rewriting the file succeeded, file closed...");
        }
    }catch(IOException e){e.printStackTrace();}

    }

}
