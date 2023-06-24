import java.util.Random;

public class BattleSimulation {
    public static void main(String[] args) {
        Fighter fighter1 = new Fighter("Harcos 1", 100, 20);
        Fighter fighter2 = new Fighter("Harcos 2", 100, 20);
        Random random = new Random();

        int round = 0;
        //Kezdődik a harc, random generátor alapján az kezd, akinek magasabb a sebzése.
        while (fighter1.isAlive() && fighter2.isAlive()) {
            int fighter1Damage = fighter1.attackDamage();
            int fighter2Damage = fighter2.attackDamage();
            System.out.println("A " + fighter1.getName() + " támodási ereje: " + fighter1Damage);
            System.out.println("A " + fighter2.getName() + " támodási ereje: " + fighter2Damage);

            round++;
            int fighter1Esely =fighter1.start();
            int fighter2Esely =fighter2.start();
            if (fighter1Esely > fighter2Esely) {
                System.out.println("Kezdődik az " + round + ". kör, a " + fighter1.getName() + " kezd.");
                fighter2.takeDamage(fighter1Damage);
                System.out.print(fighter1.getName() + " ütötte " + fighter2.getName() + "-t " + fighter1Damage + " sebzéssel. ");
                //fighter1Damage-20;
                System.out.println("A plusz sebzés mértéke: " + fighter1.getPlusDamage()); //Szerettem volna kiíratni külön a plusz sebzést, de nem sikerül
                if (!fighter2.isAlive()) {
                    break;
                }
            } else if (fighter2Esely < fighter2Esely) {
                System.out.println("Kezdődik az " + round + ". kör, a " + fighter2.getName() + " kezd.");
                fighter1.takeDamage(fighter2Damage);
                System.out.println(fighter2.getName() + " ütötte " + fighter1.getName() + "-t " + fighter2Damage + " sebzéssel.");
            } else {
                System.out.println("Kezdődik az " + round + ". kör, kivédték egymás támadását, új kör kezdődik.");
            }

        }
        // A harc vége, kiírjuk az eredményt
        if (fighter1.isAlive()) {
            System.out.println(fighter1.getName() + " győzött!");
        } else if (fighter2.isAlive()) {
            System.out.println(fighter2.getName() + " győzött!");
        } else {
            System.out.println("A harc döntetlen lett.");
        }
    }
}