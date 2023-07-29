package org.ora;

public class NumberDisplay {

    private final int limit;                //deklaráció

    private int value;                      //deklaráció

    public NumberDisplay(int limit){        //konstruktor
        this.limit = limit;                 //inicializálás
        value = 0;                          //inicializálás
    }

    public int getValue(){                  //Getter
        return value;
    }

    public void setValue(int newValue){     //Setter
        if(newValue >= 0 && newValue < limit) {
            value = newValue;
        }
    }

    public String getDisplayValue(){
        if(value < 10){
            return "0" + String.valueOf(value);
        }
        return String.valueOf(value);
    }

    public void increment (){
        value = (value +1) % limit;
    }


}
