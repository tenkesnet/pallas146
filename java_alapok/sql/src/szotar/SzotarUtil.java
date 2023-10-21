package szotar;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SzotarUtil {
	List<String> lines = new ArrayList<String>();
	ArrayList<SzotarElem> szotarElems = new ArrayList<>();
	Connection c;
	public SzotarUtil(){
		try {
			Class.forName("org.postgresql.Driver");

			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/pallas?currentSchema=auto",
							"pallas", "Oktato123");
			c.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
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

	public void loadSzavakDB(){
		try {
			String sql = "select * from pallas.words";
			PreparedStatement st = c.prepareStatement(sql);
			//st.setFetchSize(Integer.MAX_VALUE);
			//System.out.println(String.format("A fetchsize: %d", st.getFetchSize()));
			ResultSet r = st.executeQuery();
			while (r.next()) {
				SzotarElem e = new SzotarElem();
				e.setSzo(r.getString("szo"));
				e.setLemma(r.getString("lemma"));
				e.setSzofaj(r.getString("szofaj"));
				e.setSzotagszam(r.getInt("szotagszam"));
				e.setCv(r.getString("cv"));
				e.setSzoGyakorisag(r.getInt("szo_gyakorisag"));
				e.setLemmaGyakorisag(r.getInt("lemma_gyakorisag"));
				szotarElems.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
	public SzotarElem getMaxMassalhangzo(){
		SzotarElem result=null;
		int maxMassalhagzo=0;
		for(SzotarElem item: szotarElems){
			if(item.getSzofaj().equals("NUM")) continue;
			String[] ck = item.getCv().split("v");
			for (String darab: ck) {
				if(darab.length()>maxMassalhagzo){
					result=item;
					maxMassalhagzo=darab.length();
				}
			}
		}
		return result;
	}
	public void insertSzavak(){
		try {
			Class.forName("org.postgresql.Driver");
			Connection c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/pallas?currentSchema=auto",
							"pallas", "Oktato123");
			c.setAutoCommit(false);
			Statement stmt = c.createStatement();

			int i=0;
			for(SzotarElem item:szotarElems){
				stmt.addBatch(String.format("INSERT INTO words(szo,lemma,szofaj,szotagszam,cv,szo_gyakorisag,lemma_gyakorisag) "
								+ "VALUES ('%s','%s','%s',%d,'%s',%d,%d)",
						item.getSzo(),item.getLemma(),item.getSzofaj(),item.getSzotagszam(),
						item.getCv(),item.getSzoGyakorisag(),item.getLemmaGyakorisag() ));
				//if(i>10000) break;
				i++;
			}


			stmt.executeBatch();
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
