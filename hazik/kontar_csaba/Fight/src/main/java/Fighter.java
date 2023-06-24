import java.util.Random;

class Fighter {
    public String name;
    public int health;
    public int damage;
    public int plusDamage;
    public Random random;
    public Random start;


    public Fighter(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.random = new Random();
        //this.start = new start();
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        health -= (damage);
        if (health < 0) {
            health = 0;
        }
    }
    public int start() {

        int whoSNext = start.nextInt(6)+1 ;
        return whoSNext;
    }
    public int attackDamage() {
        plusDamage = start.nextInt(10)+1;// Véletlenszerűen generált sebzés
        int randomDamage = damage + plusDamage;
        return randomDamage;
    }

    public String getName() {
        return name;
    }

    public int getPlusDamage() {
        return plusDamage;
    }
}



