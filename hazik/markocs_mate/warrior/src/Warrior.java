public class Warrior extends Fighter{
    private static final double critMultiplier = 2;
    private final int critChance;

    public Warrior(String name, int healthPoints, int damagePoints, int speed, int critChance) {
        super(name, healthPoints, damagePoints, speed);
        this.critChance = critChance;
    }

    private boolean isCrit(){
        return (this.critChance >= (Math.random()*100));
    }

    @Override
    public int dealingDamage() {
        if (isCrit()){
            System.out.println(this.getName() + " kritikusat ütött! Sebzése: " +
                    (int)(this.getDamagePoints() * critMultiplier));
            return (int)(this.getDamagePoints() * critMultiplier);
        }
        return super.dealingDamage();
    }

    @Override
    public void printStats() {
        super.printStats();
        System.out.println(this.getCritChance() + "% kritikus esélye van.");
    }

    public int getCritChance() {
        return critChance;
    }
}
