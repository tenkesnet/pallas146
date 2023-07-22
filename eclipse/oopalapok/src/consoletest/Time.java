package consoletest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
	 public static void main(String... args) throws InterruptedException {
		 SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	        while(true) {
	            System.out.printf("\r%s", sdf.format(new Date()));
	            Thread.sleep(1000);
	        }
	    }
}
