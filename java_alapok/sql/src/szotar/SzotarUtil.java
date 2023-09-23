package szotar;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
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
			elem.setLemming(items[1]);
			elem.setSzofaj(items[2]);
			elem.setSzotagszam(Integer.parseInt(items[4]));
			szotarElems.add(elem);
		}
		System.out.println("");
	}

}