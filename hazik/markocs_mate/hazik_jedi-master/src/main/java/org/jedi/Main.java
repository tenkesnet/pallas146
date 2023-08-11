package org.jedi;

import java.util.List;

import static org.jedi.StarWars.*;

public class Main
{
    public static void main(String[] args)
    {
        List<IEroErzekeny> szereplok = szereplok("starwars.txt");
        for (var item : szereplok) {
            item.printErtekek();
        }
    }
}