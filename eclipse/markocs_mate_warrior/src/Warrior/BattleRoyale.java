package Warrior;

import javax.management.AttributeList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class BattleRoyale {

    private IFighter[] fighterList;
    private int numberOfDuels = 1;

    public BattleRoyale (int numberOfFighters){
        this.fighterList = new IFighter[numberOfFighters];
        for (int i = 0; i < numberOfFighters; i++){
            this.fighterList[i]=CharacterGenerator.getRandomFighter();
        }
    }

    public void startBattle(){
        while (this.fighterList.length >= 2){
            int firstFighter = (int) ((Math.random() * fighterList.length));
            int secondFighter = (int) ((Math.random() * fighterList.length));
            if (firstFighter != secondFighter){
                System.out.println("\nXXXXXXXXXXXXXXXXX " + numberOfDuels + ". párbaj XXXXXXXXXXXXXXXXX\n");
                IFighter vesztes = Duel.fighting(fighterList[firstFighter], fighterList[secondFighter]);
                IFighter[] tempFighter = new IFighter[fighterList.length-1];
                for(int i=0,j=0;i<fighterList.length;i++){
                    if(fighterList[i]!=vesztes) {
                        tempFighter[j]=fighterList[i];
                        j++;
                    }
                }
                numberOfDuels++;
                fighterList=tempFighter;
            }
        }
        printChampion();
    }

    private void printChampion() {
        try{
            var result = fighterList[0].printStats();
            System.out.print("\nA GYŐZTES: \n"+result);
        } catch (Exception e){
            System.out.println("Minimum két játékos szükséges!");
        }

    }
}
