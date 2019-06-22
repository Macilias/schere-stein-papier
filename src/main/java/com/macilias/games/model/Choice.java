package com.macilias.games.model;

import java.util.Comparator;

public enum Choice {
    SCHERE("X", Varriant.DEFAULT),
    SPOCK("V", Varriant.SPOCK),
    ECHSE("<", Varriant.SPOCK),
    STEIN("O", Varriant.DEFAULT),
    PAPIER("I", Varriant.DEFAULT);

    private final String abr;
    private final Varriant v;

    Choice(String abr, Varriant v) {
        this.abr = abr;
        this.v = v;
    }

    public String getAbr() {
        return abr;
    }

    public static Choice getChoice(int index) {
        Choice c = Choice.values()[index % Choice.values().length];
        return c;
    }

    public static Choice getChoice(int index, Varriant v) {
        Choice c = getChoice(index);
        while (c.v != v && c.v != Varriant.DEFAULT) {
            index++;
            c = getChoice(index);
        }
        return c;
    }

    public static String printChoices(Varriant v) {
        String res = "";
        for (Choice c : values()) {
            if (c.v == v || c.v == Varriant.DEFAULT) {
                res += String.format("[%s] für %s, ", c.getAbr(), c.name());
            }
        }
        return res;
    }

    public static Choice getChoice(String value, Varriant v) {
        for (Choice c : values()) {
            if (c.getAbr().equalsIgnoreCase(value)) {
                if (c.v != v && c.v != Varriant.DEFAULT) {
                    throw new IllegalArgumentException(String.format("du cheatest, %s is in der gewählten " +
                            "Spiel-Variante %s nicht verfügbar", c.name(), v.name()));
                }
                return c;
            }
        }
        throw new IllegalArgumentException();
    }

    public static class ChoiceComparator implements Comparator<Choice> {
        Choice[] arr = Choice.values();

        public int compare(Choice c1, Choice c2) {
            if (c1 == c2) return 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == c1) {
                    return (getChoice(i + 1) == c2 || getChoice(i + 3) == c2) ? -1 : 1;
                }
            }
            throw new RuntimeException(String.format("unpossible state while comparing %s with %s.", c1, c2));
        }
    }

    static class BruteForceComparator implements Comparator<Choice> {
        public int compare(Choice c1, Choice c2) {
            if (c1 == c2) return 0;
            if (c1 == SCHERE) {
                if (c2 == SPOCK) return -1;
                if (c2 == ECHSE) return 1;
                if (c2 == STEIN) return -1;
                if (c2 == PAPIER) return 1;
            }
            if (c1 == SPOCK) {
                if (c2 == ECHSE) return -1;
                if (c2 == STEIN) return 1;
                if (c2 == PAPIER) return -1;
                if (c2 == SCHERE) return 1;
            }
            if (c1 == ECHSE) {
                if (c2 == STEIN) return -1;
                if (c2 == PAPIER) return 1;
                if (c2 == SCHERE) return -1;
                if (c2 == SPOCK) return 1;
            }
            if (c1 == STEIN) {
                if (c2 == PAPIER) return -1;
                if (c2 == SCHERE) return 1;
                if (c2 == SPOCK) return -1;
                if (c2 == ECHSE) return 1;
            }
            if (c1 == PAPIER) {
                if (c2 == SCHERE) return -1;
                if (c2 == SPOCK) return 1;
                if (c2 == ECHSE) return -1;
                if (c2 == STEIN) return 1;
            }
            throw new RuntimeException(String.format("unpossible state while comparing %s with %s. ", c1, c2));
        }
    }

}
