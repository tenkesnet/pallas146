package Warrior;

public class Dummy extends Fighter{
    public Dummy(String name, int maxHealthPoints, int damagePoints, int speed) {
        super(name, maxHealthPoints, damagePoints, speed);
    }
    @Override
    public String printStats(){
        return "Ellenfele egy emberméretű szalmazsák!";
    }
}
