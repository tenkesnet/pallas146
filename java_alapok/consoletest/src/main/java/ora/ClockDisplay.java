package ora;

public class ClockDisplay {
    private final NumberDisplay hours;
    private final NumberDisplay minutes;
    private String displayString;

    public ClockDisplay(){
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    public void updateDisplay(){
        displayString = hours.getDisplayValue()+":"+minutes.getDisplayValue();
    }

    public String getTime(){
        return displayString;
    }

    public void setTime(int hour, int minutes){
        hours.setValue(hour);
        this.minutes.setValue(minutes);
        updateDisplay();
    }

    public void timeTick(){
        minutes.increment();
        if(minutes.getValue() == 0){
            hours.increment();
        }
        updateDisplay();
    }
}
