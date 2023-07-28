package ora;

public class ClockDisplay {
    private final NumberDisplay hours;
    private final NumberDisplay minutes;
    private final NumberDisplay seconds;
    private String displayString;

    public ClockDisplay() {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        seconds = new NumberDisplay(60);
        updateDisplay();
    }

    public void updateDisplay() {
        displayString = hours.getDisplayValue() + ":" + minutes.getDisplayValue() + ":" + seconds.getDisplayValue();
    }

    public String getTime() {
        return displayString;
    }

    public void setTime(int hour, int minute, int second) {
        this.hours.setValue(hour);
        this.minutes.setValue(minute);
        this.seconds.setValue(second);
        updateDisplay();
    }

    public void timeTick() {
        seconds.increment();

        if (seconds.getValue() == 0) {
            minutes.increment();

            if (minutes.getValue() == 0) {
                hours.increment();
            }
        }
        updateDisplay();

    }
}
