package ora;

public class NumberDisplay {
    private final int limit;
    private int value;

    public NumberDisplay(int limit) {
        this.limit = limit;
        value = 0;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int newValue) {
        if (newValue >= 0 && newValue < limit) {
            value = newValue;
        }
    }

    public String getDisplayValue() {
        if (value < 10) {
            return "0" + String.valueOf(value);
        }
        return "" + value;
    }

    public void increment(){
        value = (value +1) % limit;
    }

}
