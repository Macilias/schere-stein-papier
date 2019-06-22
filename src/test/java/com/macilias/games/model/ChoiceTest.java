package com.macilias.games.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChoiceTest {

    @Test
    public void testChoiceComparator() {
        Choice.ChoiceComparator comp = new Choice.ChoiceComparator();
        Assert.assertEquals("STEIN vs STEIN", comp.compare(Choice.SCHERE, Choice.SCHERE), 0);
        Assert.assertEquals("STEIN vs STEIN", comp.compare(Choice.SCHERE, Choice.STEIN), -1);
        Assert.assertEquals("STEIN vs STEIN", comp.compare(Choice.SCHERE, Choice.PAPIER), 1);

        Assert.assertEquals("STEIN vs STEIN", comp.compare(Choice.STEIN, Choice.SCHERE), 1);
        Assert.assertEquals("STEIN vs STEIN", comp.compare(Choice.STEIN, Choice.STEIN), 0);
        Assert.assertEquals("STEIN vs STEIN", comp.compare(Choice.STEIN, Choice.PAPIER), -1);

        Assert.assertEquals("STEIN vs STEIN", comp.compare(Choice.PAPIER, Choice.SCHERE), -1);
        Assert.assertEquals("STEIN vs STEIN", comp.compare(Choice.PAPIER, Choice.STEIN), 1);
        Assert.assertEquals("STEIN vs STEIN", comp.compare(Choice.PAPIER, Choice.PAPIER), 0);
    }

    @Test
    public void testBrComparator() {
        Choice.BruteForceComparator comp = new Choice.BruteForceComparator();
        Assert.assertEquals("STEIN vs STEIN", comp.compare(Choice.SCHERE, Choice.SCHERE), 0);
        Assert.assertEquals("STEIN vs STEIN", comp.compare(Choice.SCHERE, Choice.STEIN), -1);
        Assert.assertEquals("STEIN vs STEIN", comp.compare(Choice.SCHERE, Choice.PAPIER), 1);

        Assert.assertEquals("STEIN vs STEIN", comp.compare(Choice.STEIN, Choice.SCHERE), 1);
        Assert.assertEquals("STEIN vs STEIN", comp.compare(Choice.STEIN, Choice.STEIN), 0);
        Assert.assertEquals("STEIN vs STEIN", comp.compare(Choice.STEIN, Choice.PAPIER), -1);

        Assert.assertEquals("STEIN vs STEIN", comp.compare(Choice.PAPIER, Choice.SCHERE), -1);
        Assert.assertEquals("STEIN vs STEIN", comp.compare(Choice.PAPIER, Choice.STEIN), 1);
        Assert.assertEquals("STEIN vs STEIN", comp.compare(Choice.PAPIER, Choice.PAPIER), 0);
    }

}