package Bolt;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Vegyesbolt {
    public static List<Termek> termekList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //System.out.print("Kérem a file nevet: ");
        //String inputpath = reader.readLine();
        String currentWorkingDirectory = System.getProperty("user.dir");
        if(args.length==0){
            System.out.println("kérek egy filenevet");
            return;
        }
        Path filePath = Paths.get(args[0]);
        File file = filePath.toFile();


        bevasarlok(file);

        mivanakosaramban();
    }

    public static void bevasarlok(File filepath) throws ArrayIndexOutOfBoundsException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            br.readLine();
            String line = br.readLine();
            while (line != null) {
                String[] szavak = line.split(";");
                if (szavak[0].equals("paradicsom")) {
                    Rohadtparadicsom par = new Rohadtparadicsom
                            (Double.parseDouble(szavak[2]),
                                    Integer.parseInt(szavak[1]));
                    termekList.add(par);
                } else if (szavak[0].equals("salata")) {
                    Salata sal = new Salata
                            (Integer.parseInt(szavak[2]),
                                    Integer.parseInt(szavak[1]));
                    termekList.add(sal);
                } else {
                    System.err.printf("Caught exception %s" +
                            " cannot be added to the List", szavak[0]);
                }
                line = br.readLine();
            }
            br.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mivanakosaramban() {

        termekList.forEach(x -> {
            if (x instanceof Rohadtparadicsom) {
                System.out.println(x);
            } else {
                System.out.println(x);
            }
        });
    }
}
