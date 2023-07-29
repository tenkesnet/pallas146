package org.ora;

public class ClockDisplay {
    private final NumberDisplay hours;        //deklaráció
    private final NumberDisplay minutes;      //deklaráció
    private final NumberDisplay seconds;
    private String displayString;       //deklaráció

    public ClockDisplay(){              //konstruktor
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        seconds = new NumberDisplay(60);
        updateDisplay();
    }

    public void updateDisplay(){
        displayString = hours.getDisplayValue() + ":" +
                minutes.getDisplayValue() + ":" + seconds.getDisplayValue();
    }

    public String getTime(){
        return displayString;
    }

    public void setTime(int hours, int minutes, int seconds){
        this.hours.setValue(hours);
        this.minutes.setValue(minutes);
        this.seconds.setValue(seconds);
        updateDisplay();
    }

    public void timeTick(){
        seconds.increment();
        if(seconds.getValue()==0){
            minutes.increment();
            if (minutes.getValue() == 0){
                hours.increment();
            }
        }

        updateDisplay();
    }

}
