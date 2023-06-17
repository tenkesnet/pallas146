public class Game {
    public static void main(String[] args) {
        int numberOfBattles = 2;
        for (int i = 1; i < (2 * numberOfBattles + 1); i++){
            System.out.println("\nXXXXXXXXXXXX " + (i/2+1) + ". csata! XXXXXXXXXXXX\n");
            Fight.fighting(CharacterGenerator.getRandomFighter(i),
                    CharacterGenerator.getRandomFighter(++i));
        }
    }
}