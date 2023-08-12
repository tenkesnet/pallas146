package myinterface;

import java.util.Calendar;
import java.util.GregorianCalendar;
import Warrior.IFighter;

public class People<T> implements IEmlos<T> {
    public String name;
    public int age;

    public People(int age,String name) {
        this.name = name;
        this.age = age;
    }


    @Override
    public int getBirthDate() {
        return new GregorianCalendar().get(Calendar.YEAR) - age;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public T get() {
        T result = null;
        return result;
    }

}
