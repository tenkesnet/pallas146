package Warrior;

public class Warrior extends Fighter {
    private static final double critMultiplier = 2;
    private final int critChance;

    public Warrior(Fighter fighter, int critChance) {
        super(fighter.getName(), fighter.getMaxHealthPoints(), fighter.getDamagePoints(), fighter.getSpeed());
        this.critChance = critChance;
    }

    private boolean isCrit() {
        return (this.critChance >= (Math.random() * 100));
    }

    @Override
    public int dealingDamage() {
        if (isCrit()) {
            System.out.println(this.getName() + " kritikusat ütött! Sebzése: " +
                    (int) (this.getDamagePoints() * critMultiplier));
            return (int) (this.getDamagePoints() * critMultiplier);
        }
        return super.dealingDamage();
    }

    @Override
    public String printStats() {
        return super.printStats()+"\n"+this.getCritChance() + "% kritikus esélye van.";
    }

    public int getCritChance() {
        return critChance;
    }
}
