package com.macilias.games.controller;

import com.macilias.games.model.Choice;
import com.macilias.games.model.Varriant;

import java.util.Random;

public class GameImpl implements Game {

    private int playerScore = 0;
    private int computerScore = 0;
    private Random random = new Random(467462421234L);
    private Choice.ChoiceComparator comp = new Choice.ChoiceComparator();

    public int choose(Choice c1, Varriant v) {
        Choice c2 = Choice.getChoice(random.nextInt(Choice.values().length), v);
        System.out.println(String.format("Du wählst %s", c1.name()));
        System.out.println(String.format("Computer wählt %s", c2.name()));
        int res = comp.compare(c1, c2);
        if (res > 0) {
            playerScore ++;
        }
        if (res < 0) {
            computerScore ++;
        }
        return res;
    }

    public String getScore() {
        return String.format("Du: %d Computer: %d, %s", playerScore, computerScore, playerScore == computerScore ?
                "Oh unentschieden" : playerScore > computerScore ? "Gratuliere" : "Pech gehabt");
    }
}
