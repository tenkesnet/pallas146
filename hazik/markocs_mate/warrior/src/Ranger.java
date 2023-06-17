public class Ranger extends Fighter {

    private int avoidChance;

    public Ranger(String name, int healthPoints, int damagePoints, int speed, int avoidChance) {
        super(name, healthPoints, damagePoints, speed);
        this.avoidChance = avoidChance;
    }

    private boolean isAvoid(){
        return (this.avoidChance >= (Math.random()*100));
    }

    @Override
    public void takingDamage(int damage) {
        if (isAvoid()){
            System.out.print(this.getName() + " elugrott az ütés elől! ");
        } else {
        this.setHealthPoints(this.getHealthPoints() - damage);
        }
        if (this.isAlive()){
            System.out.println(this.getName() + " maradék élete: " + this.getHealthPoints());
        } else{
        System.out.println(this.getName() + " meghalt!");
        }
    }

    @Override
    public void printStats() {
        super.printStats();
        System.out.println(this.getAvoidChance() + "% elugrási esélye van.");
    }

    public int getAvoidChance() {
        return avoidChance;
    }

    public void setAvoidChance(int avoidChance) {
        this.avoidChance = avoidChance;
    }

}
