package com.macilias.games.view;

import com.macilias.games.controller.Game;
import com.macilias.games.controller.GameImpl;
import com.macilias.games.model.Choice;
import com.macilias.games.model.Varriant;

import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        Scanner s = new Scanner(System.in);
        Game game = new GameImpl();
        Varriant v = Varriant.DEFAULT;
        while (true) {
            System.out.println("Willkommen - für das klassische Spiel wähle bitte [K] für die Scheldon Lee Cooper Variante [S]");
            String variant = s.next().toUpperCase();
            if (variant.equalsIgnoreCase("S")) {
                v = Varriant.SPOCK;
                break;
            }
            if (variant.equalsIgnoreCase("K")) {
                break;
            }
        }

        System.out.println(String.format("Willkommen - wähle %s", Choice.printChoices(v)));

        while (true) {
            String move = s.next().toUpperCase();
            if (move.equalsIgnoreCase("Q")) {
                break;
            }
            try {
                Choice choice = Choice.getChoice(move, v);
                printResult(game.choose(choice, v));
            } catch (IllegalArgumentException e) {
                System.out.println(String.format("%s ist leider nicht gültig %s. Wähle %s", move, e.getMessage(), Choice.printChoices(v)));
            }
        }
        System.out.println(String.format("Das Ergebnis lautet: %s.", game.getScore()));
        s.close();
    }

    private static void printResult(int res) {
        switch (res) {
            case -1:
                System.out.println("Du verierst");
                break;
            case 0:
                System.out.println("Noch mal");
                break;
            case 1:
                System.out.println("Du gewinnst");
                break;
        }
    }
}
