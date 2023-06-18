public class Dummy extends Fighter{
    public Dummy(String name, int maxHealthPoints, int damagePoints, int speed) {
        super(name, maxHealthPoints, damagePoints, speed);
    }
    @Override
    public void printStats(){
        System.out.println("Ellenfele egy emberméretű szalmazsák!");
    }
}
