import ora.ClockDisplay;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Time {
    public static void main(String... args) throws InterruptedException {
        ClockDisplay oraPeldany = new ClockDisplay();
        LocalDateTime time = LocalDateTime.now();
        oraPeldany.setTime(time.getHour(), time.getMinute(), time.getSecond());
        while (true) {
            System.out.printf("\r%s", oraPeldany.getTime());
            oraPeldany.timeTick();
            Thread.sleep(1000);
        }
    }
}
