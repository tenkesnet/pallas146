package alapozo;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamAdvanced {
	private ArrayList<String> szavak;

	public static void illegalStateException() {
		Stream<String> elements = Stream.of("a", "b", "c").filter(element -> element.contains("b"));
		Optional<String> anyElement = elements.findAny();
		// IllegalStateException
		Optional<String> firstElement = elements.findAny();

		/**
		 * Megoldás: List<String> elements = Stream.of("a", "b", "c").filter(element ->
		 * element.contains("b")) .collect(Collectors.toList()); Optional<String>
		 * anyElement = elements.stream().findAny(); Optional<String> firstElement =
		 * elements.stream().findFirst();
		 */
	}

	public void loadSzavak(String filePath) {
		try {
			List<String> szavak = Files.readAllLines(Path.of(filePath), StandardCharsets.UTF_8);
			this.szavak = new ArrayList<String>(szavak);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		for( String szo: szavak) {
			if(isPalindrome(szo) && szo.length()==4 ) System.out.println(szo);
		}
		System.out.println("");
	}
	
	public static boolean isPalindrome(String inputString) {
		Objects.requireNonNull(inputString, "String cannot be null."); // Get the length of string
		int len = inputString.length();
		if (len <= 1) {
			return true;
		}
		String newStr = inputString.toUpperCase();
		boolean result = true;

		int counter = len / 2;

		for (int i = 0; i < counter; i++) {
			if (newStr.charAt(i) != newStr.charAt(len - 1 - i)) {

				result = false;

				break;
			}
		}
		return result;
	}
}
