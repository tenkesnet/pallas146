package Warrior;

import java.util.ArrayList;
import java.util.List;

public class BattleRoyale {

    private final List<IFighter> fighterList;
    private int numberOfDuels = 1;

    public BattleRoyale (int numberOfFighters){
        this.fighterList = new ArrayList<>();
        for (int i = 0; i < numberOfFighters; i++){
            this.fighterList.add(CharacterGenerator.getRandomFighter());
        }
    }

    public void startBattle(){
        while (this.fighterList.size() >= 2){
            int firstFighter = (int) ((Math.random() * fighterList.size()));
            int secondFighter = (int) ((Math.random() * fighterList.size()));
            if (firstFighter != secondFighter){
                System.out.println("\nXXXXXXXXXXXXXXXXX " + numberOfDuels + ". párbaj XXXXXXXXXXXXXXXXX\n");
                fighterList.remove(Duel.fighting(fighterList.get(firstFighter), fighterList.get(secondFighter)));
                numberOfDuels++;
            }
        }
        printChampion();
    }

    private void printChampion() {
        try{
            var result = fighterList.get(0).printStats();
            System.out.print("\nA GYŐZTES: \n"+result);
        } catch (Exception e){
            System.out.println("Minimum két játékos szükséges!");
        }

    }
}
