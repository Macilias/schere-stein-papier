package com.macilias.games.model;

import java.util.Comparator;

public enum Choice {
    SCHERE("X"), STEIN("O"), PAPIER("I");

    private final String abr;

    Choice(String abr) {
        this.abr = abr;
    }

    public String getAbr() {
        return abr;
    }

    public static Choice getChoice(int index) {
        return Choice.values()[index%Choice.values().length];
    }

    public static Choice getChoice(String value) {
        for(Choice c : values())
        {
            if(c.getAbr().equalsIgnoreCase(value)) return c;
        }
        throw new IllegalArgumentException();
    }

    public static class ChoiceComparator implements Comparator<Choice> {
        Choice[] arr = Choice.values();

        public int compare(Choice c1, Choice c2)
        {
            if (c1 == c2) return 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == c1) {
                    return (getChoice(i+1) != c2) ? 1 : -1;
                }
            }
            throw new RuntimeException(String.format("unpossible state while comparing %s with %s. " +
                    "Do we have more than 3 cases now? ", c1, c2));
        }
    }

    static class BruteForceComparator implements Comparator<Choice> {
        public int compare(Choice c1, Choice c2)
        {
            if (c1 == c2) return 0;
            if (c1 == SCHERE) {
                if (c2 == STEIN) return -1;
                if (c2 == PAPIER) return 1;
            }
            if (c1 == STEIN) {
                if (c2 == SCHERE) return 1;
                if (c2 == PAPIER) return -1;
            }
            if (c1 == PAPIER) {
                if (c2 == SCHERE) return -1;
                if (c2 == STEIN) return 1;
            }
            throw new RuntimeException(String.format("unpossible state while comparing %s with %s. " +
                    "Do we have more than 3 cases now? ", c1, c2));
        }
    }

}
