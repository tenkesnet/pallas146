package org.ora;

import java.time.LocalDateTime;

public class Time {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("********");

        System.out.println("Az aktuális idő:");

        ClockDisplay oraPeldany = new ClockDisplay();

        LocalDateTime time = LocalDateTime.now();

        oraPeldany.setTime(time.getHour(),time.getMinute(),time.getSecond());
        while(true){
            oraPeldany.timeTick();
            System.out.printf("\r%s", oraPeldany.getTime());
            Thread.sleep(1000*1);
        }
    }
}