package Intezmeny;

import Oktatas.Kurzus;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private  Hello hello = new Hello();
    public static void main(String[] args) {

        Egyetem e1 = new Egyetem("Talicskafalvi Tudományegyetem (TTE)", "Talicskafalva");
        Main main = new Main();
        System.out.println(e1);

        Kurzus[] kurzusTomb = new Kurzus[4];




        /*kurzusTomb[0] = "Csigaház betonozás";
        kurzusTomb[1] = "Tücsök zeneóra";
        kurzusTomb[2] = "Gepárd sprintfutam";
        kurzusTomb[3] = "Titkos kurzus";*/

        System.out.println("Az alábbi egyetemek közül lehet választani: " + Arrays.toString(kurzusTomb));


    }
}
