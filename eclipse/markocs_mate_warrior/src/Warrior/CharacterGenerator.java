package Warrior;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class CharacterGenerator {

    public static IFighter getRandomFighter() {
        double classNumber = Math.random();
        if (classNumber <= 0.33) {
            return createWarrior(getRandomName() + " (" + getRandomID() + ") - Warrior");
        } else if (classNumber <= 0.66) {
            return createRanger(getRandomName() + " (" + getRandomID() + ") - Ranger ");
        } else {
            return createMage(getRandomName() + " (" + getRandomID() + ") - Mage ");
        }
    }

    private static Warrior createWarrior(String name) {
        return new Warrior(createFighter(name), (int) ((Math.random() * (70 - 10)) + 10));
    }

    private static Ranger createRanger(String name) {
        return new Ranger(createFighter(name), (int) ((Math.random() * (45 - 10)) + 10));
    }

    private static Mage createMage(String name) {
        return new Mage(createFighter(name), (int) ((Math.random() * (15 - 5)) + 5));
    }

    private static Fighter createFighter(String name) {
        return new Fighter(name, (int) ((Math.random() * (200 - 100)) + 100), (int) ((Math.random() * (20 - 10)) + 10),
                (int) ((Math.random() * (10 - 1)) + 1));
    }

    private static String getRandomID() {
        int length = 7;
        return UUID.randomUUID().toString().substring(0, length);
    }

    private static String getRandomName() {
        ArrayList<String> names = new ArrayList<>();
        try {
            FileReader.readFileToList("src/Names.txt",names);
        } catch ( IOException e){

        }

        return names.get((int) (Math.random() * (names.size())));
    }
}
