package com.macilias.games.controller;

import com.macilias.games.model.Choice;

import java.util.Random;

public class GameImpl implements Game {

    int playerScore = 0;
    int computerScore = 0;
    Random random = new Random(467462421234L);
    Choice.ChoiceComparator comp = new Choice.ChoiceComparator();

    public int choose(Choice c1) {
        Choice c2 = Choice.getChoice(random.nextInt(3));
        System.out.println(String.format("Du wählst %s", c1.name()));
        System.out.println(String.format("Computer wählt %s", c2.name()));
        int res = comp.compare(c1, c2);
        if (res == 1) {
            playerScore ++;
        }
        if (res == -1) {
            computerScore ++;
        }
        return res;
    }

    public String getScore() {
        return String.format("Du: %d Computer: %d, %s", playerScore, computerScore, playerScore == computerScore ?
                "Oh unentschieden" : playerScore > computerScore ? "Gratuliere" : "Pech gehabt");
    }
}
