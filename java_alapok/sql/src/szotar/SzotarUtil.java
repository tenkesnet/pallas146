package szotar;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SzotarUtil {
	List<String> lines = new ArrayList<String>();
	ArrayList<SzotarElem> szotarElems = new ArrayList<>();
	public void loadSzavak(String filePath) {
		try {
			lines = Files.readAllLines(Path.of(filePath), StandardCharsets.UTF_8);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		for (String line : lines ) {
			String[] items = line.split("\t"); 
			if(items.length<8) continue;
			SzotarElem elem = new SzotarElem();
			elem.setSzo(items[0]);
			elem.setLemma(items[1]);
			elem.setSzofaj(items[2]);
			elem.setSzotagszam(Integer.parseInt(items[4]));
			elem.setCv(items[5]);
			elem.setSzoGyakorisag(Integer.parseInt(items[6]));
			elem.setLemmaGyakorisag(Integer.parseInt(items[7]));
			szotarElems.add(elem);
		}
		System.out.println("");
	}

	public void insertSzavak(){
		try {
			Class.forName("org.postgresql.Driver");
			Connection c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/pallas?currentSchema=auto",
							"pallas", "Oktato123");
			c.setAutoCommit(false);
			Statement stmt = c.createStatement();




			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
}
