import ora.ClockDisplay;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Time {
    public static void main(String... args) throws InterruptedException {
        ClockDisplay oraPeldany = new ClockDisplay();
        LocalDateTime time = LocalDateTime.now();
        oraPeldany.setTime(time.getHour(),time.getMinute());
        while(true) {
            oraPeldany.timeTick();
            System.out.printf("\r%s", oraPeldany.getTime());
            Thread.sleep(1000*60);
        }
    }
}
