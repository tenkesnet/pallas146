import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Vegyesbolt {
    private static List<Termek> termekek = new ArrayList<>();

    public static void bevasarlok(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    String nev = parts[0];
                    int egysegar = Integer.parseInt(parts[1]);
                    double mennyiseg = Double.parseDouble(parts[2]);

                    if (nev.equals("salata")) {
                        Salata salata = new Salata((int) mennyiseg, egysegar);
                        termekek.add(salata);
                    } else if (nev.equals("paradicsom")) {
                        RohadtParadicsom paradicsom = new RohadtParadicsom(mennyiseg, egysegar);
                        termekek.add(paradicsom);
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static void mivanakosaramban() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("kosar.txt"))) {
            for (Termek termek : termekek) {
                writer.println(termek.toString());
                if (termek instanceof Akciozhato) {
                    Akciozhato akciozhato = (Akciozhato) termek;
                    writer.println("Akcios ar: " + akciozhato.akciosAr() + " Ft");
                }
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java Vegyesbolt <input_file>");
            return;
        }

        String filePath = args[0];
        bevasarlok(filePath);
        mivanakosaramban();
    }
}

