package com.macilias.games.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class ChoiceTest {

    @Test
    public void testChoiceComparator() {
        Choice.ChoiceComparator comp = new Choice.ChoiceComparator();
        testCombinations(comp);
    }

    @Test
    public void testBruteForceComparator() {
        Choice.BruteForceComparator comp = new Choice.BruteForceComparator();
        testCombinations(comp);
    }

    private void testCombinations(Comparator<Choice> comp) {
        Assert.assertEquals("SCHERE vs SCHERE", comp.compare(Choice.SCHERE, Choice.SCHERE), 0);
        Assert.assertEquals("SCHERE vs STEIN", comp.compare(Choice.SCHERE, Choice.STEIN), -1);
        Assert.assertEquals("SCHERE vs PAPIER", comp.compare(Choice.SCHERE, Choice.PAPIER), 1);

        Assert.assertEquals("STEIN vs SCHERE", comp.compare(Choice.STEIN, Choice.SCHERE), 1);
        Assert.assertEquals("STEIN vs STEIN", comp.compare(Choice.STEIN, Choice.STEIN), 0);
        Assert.assertEquals("STEIN vs PAPIER", comp.compare(Choice.STEIN, Choice.PAPIER), -1);

        Assert.assertEquals("PAPIER vs SCHERE", comp.compare(Choice.PAPIER, Choice.SCHERE), -1);
        Assert.assertEquals("PAPIER vs STEIN", comp.compare(Choice.PAPIER, Choice.STEIN), 1);
        Assert.assertEquals("PAPIER vs PAPIER", comp.compare(Choice.PAPIER, Choice.PAPIER), 0);
    }

}