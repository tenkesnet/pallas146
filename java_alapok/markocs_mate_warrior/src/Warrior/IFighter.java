package Warrior;

public interface IFighter {
    boolean isAlive();

    int initiative();

    void takingDamage(int damage);

    int dealingDamage();

    void printHealtPoints();

    void printDead();

    String printStats();

    String getName();

    int getCurrentHealthPoints();

    void setCurrentHealthPoints(int currentHealthPoints);

    int getDamagePoints();

    int getSpeed();

    int getMaxHealthPoints();

    void healDamage();
}