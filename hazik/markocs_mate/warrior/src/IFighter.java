public interface IFighter {
    boolean isAlive();

    int initiative();

    void takingDamage(int damage);

    int dealingDamage();

    void printHealtPoints();

    void printDead();

    void printStats();

    String getName();

    int getHealthPoints();

    void setHealthPoints(int healthPoints);

    int getDamagePoints();

    int getSpeed();
}
