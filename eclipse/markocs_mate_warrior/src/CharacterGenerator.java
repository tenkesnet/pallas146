public class CharacterGenerator {

    public static IFighter getRandomFighter(int characterNumber) {
        double classNumber = Math.random();
        if (classNumber <= 0.33) {
            return createWarrior(characterNumber + ". harcos (Warrior)");
        } else if (classNumber <= 0.66) {
            return createRanger(characterNumber + ". harcos (Ranger)");
        } else {
            return createMage(characterNumber + ". harcos (Mage)");
        }
    }

    private static Warrior createWarrior(String name) {
        return  new Warrior(name, (int) (100 + Math.random() * 1000), (int) (Math.random() * 100 + 1),
                (int) (Math.random() * 10), (int) (Math.random() * 100));
    }

    private static Ranger createRanger(String name) {
        return new Ranger(name, (int) (100 + Math.random() * 1000), (int) (Math.random() * 100 + 1),
                (int) (Math.random() * 10), (int) (Math.random() * 100));
    }

    private static Mage createMage(String name) {
        return new Mage(name, (int) (100 + Math.random() * 1000), (int) (Math.random() * 100 + 1),
                (int) (Math.random() * 10), (int) (Math.random() * 100));
    }
}
