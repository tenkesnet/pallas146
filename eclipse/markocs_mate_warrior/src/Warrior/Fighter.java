package Warrior;

public class Fighter implements IFighter,MyMarker {

    private final String name;
    private final int maxHealthPoints;
    private int currentHealthPoints;
    private final int damagePoints;
    private final int speed;

    public Fighter(String name, int maxHealthPoints, int damagePoints, int speed) {
        this.maxHealthPoints = maxHealthPoints;
        this.name = name;
        this.currentHealthPoints = maxHealthPoints;
        this.damagePoints = damagePoints;
        this.speed = speed;
    }

    @Override
    public boolean isAlive() {
        return (this.getCurrentHealthPoints() > 0);
    }

    @Override
    public int initiative() {
        return (int) (this.getSpeed() + (Math.random() * 10));
    }

    @Override
    public void takingDamage(int damage) {
        this.setCurrentHealthPoints(this.getCurrentHealthPoints() - damage);
        if (this.isAlive()) {
            this.printHealtPoints();
        } else {
            this.printDead();
        }
    }

    @Override
    public int dealingDamage() {
        System.out.println(this.getName() + " ütött! Sebzése: " + this.getDamagePoints());
        return this.getDamagePoints();
    }

    @Override
    public void printHealtPoints() {
        System.out.println(this.getName() + " maradék élete: " + this.getCurrentHealthPoints());
    }

    @Override
    public void printDead() {
        System.out.println(this.getName() + " meghalt!");
    }

    @Override
    public void printStats() {
        System.out.print(this.getName() + " akinek " +
                this.getCurrentHealthPoints() + " élete, " + this.getDamagePoints() + " sebzése, " +
                this.getSpeed() + " gyorsasága, ");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCurrentHealthPoints() {
        return currentHealthPoints;
    }

    @Override
    public void setCurrentHealthPoints(int currentHealthPoints) {
        this.currentHealthPoints = currentHealthPoints;
    }

    @Override
    public int getDamagePoints() {
        return damagePoints;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    @Override
    public void healDamage() {
        this.currentHealthPoints = this.maxHealthPoints;
    }
}
