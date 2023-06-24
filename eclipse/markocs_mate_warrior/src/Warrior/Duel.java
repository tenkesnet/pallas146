package Warrior;

public class Duel {

    public static IFighter fighting(IFighter player1, IFighter player2) {
        int round = 1;
        player1.printStats();
        player2.printStats();
        while (bothAlive(player1, player2)) {
            System.out.println("------------ " + round++ + ". kör ------------");
            battlePhase(player1, player2);
        }
        return checkLoser(player1, player2);
    }

    private static void battlePhase(IFighter player1, IFighter player2) {
        if (player1.initiative() > player2.initiative()) {
            damagePhase(player1, player2);
        } else {
            damagePhase(player1, player2);
        }
    }

    private static void damagePhase(IFighter player1, IFighter player2) {
        player2.takingDamage(player1.dealingDamage());
        if (player2.isAlive()) {
            player1.takingDamage(player2.dealingDamage());
        }
    }

    private static IFighter checkLoser(IFighter player1, IFighter player2) {
        if (player1.isAlive()) {
            printVictor(player1);
            player1.healDamage();
            return player2;
        } else {
            printVictor(player2);
            player2.healDamage();
            return player1;
        }
    }

    private static void printVictor(IFighter player) {
        System.out.println(player.getName() + " nyerte a küzdelmet! " + player.getCurrentHealthPoints() +
                " élete maradt!");
    }

    private static boolean bothAlive(IFighter player1, IFighter player2) {
        return (player1.isAlive() && player2.isAlive());
    }
}
