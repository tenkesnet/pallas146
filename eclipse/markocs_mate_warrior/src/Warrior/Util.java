package Warrior;

public class Util {
    private String name;

    public static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

}
