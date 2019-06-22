package com.macilias.games.view;

import com.macilias.games.controller.Game;
import com.macilias.games.controller.GameImpl;
import com.macilias.games.model.Choice;

import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        Scanner s = new Scanner(System.in);
        Game game = new GameImpl();

        System.out.println(String.format("Willkommen - wähle [%s] für Schere, [%s] für Stein oder [%s] für Papier",
                Choice.SCHERE.getAbr(), Choice.STEIN.getAbr(), Choice.PAPIER.getAbr()));

        while (true) {
            String move = s.next().toUpperCase();
            if (move.equalsIgnoreCase("Q")) {
                break;
            }
            try {
                Choice choice = Choice.getChoice(move);
                printResult(game.choose(choice));
            } catch (IllegalArgumentException e) {
                System.out.println(String.format("%s ist leider nicht gültig. Wähle [%s] für Schere, [%s] für Stein " +
                                "oder [%s] für Papier oder [Q] um das Spiel abzubrechen", move, Choice.SCHERE.getAbr(),
                        Choice.STEIN.getAbr(), Choice.PAPIER.getAbr()));
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
