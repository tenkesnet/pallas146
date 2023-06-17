public class Fighter implements IFighter {

    private final String name;
    private int healthPoints;
    private final int damagePoints;
    private final int speed;

    public Fighter(String name, int healthPoints, int damagePoints, int speed) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.damagePoints = damagePoints;
        this.speed = speed;
    }
    @Override
    public boolean isAlive(){
        return (this.getHealthPoints() > 0);
    }

    @Override
    public int initiative(){
        return (int) (this.getSpeed() + (Math.random() * 10));
    }

    @Override
    public void takingDamage(int damage){
        this.setHealthPoints(this.getHealthPoints() - damage);
        if (this.isAlive()){
            this.printHealtPoints();
        } else {
            this.printDead();
        }
    }

    @Override
    public int dealingDamage(){
        System.out.println(this.getName() + " ütött! Sebzése: " + this.getDamagePoints());
        return this.getDamagePoints();
    }

    @Override
    public void printHealtPoints(){
        System.out.println(this.getName() + " maradék élete: " + this.getHealthPoints());
    }

    @Override
    public void printDead(){
        System.out.println(this.getName() + " meghalt!");
    }

    @Override
    public void printStats(){
        System.out.print(this.getName() + " egy " + this.getClass().getSimpleName() + " akinek " +
                this.getHealthPoints() + " élete, " + this.getDamagePoints() + " sebzése, " +
                this.getSpeed() + " gyorsasága, ");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealthPoints() {
        return healthPoints;
    }

    @Override
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    @Override
    public int getDamagePoints() {
        return damagePoints;
    }

    @Override
    public int getSpeed() {
        return speed;
    }
}
