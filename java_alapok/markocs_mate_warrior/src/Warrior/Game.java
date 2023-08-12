package Warrior;

import java.io.FileNotFoundException;

public class Game {
    public static void main(String[] args) {
        try {
            int jatekosokSzama = Integer.parseInt(args[0]);
            BattleRoyale tournament = new BattleRoyale(jatekosokSzama);
            tournament.startBattle();
        } catch (NumberFormatException e) {
            System.out.println("Az első paraméter a játékosok száma, ami egy 1 vagy annál nagyobb szám!");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Hiányzó paraméter!");
        }

    }
}