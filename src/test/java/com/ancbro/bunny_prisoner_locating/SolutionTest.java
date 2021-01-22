package com.ancbro.bunny_prisoner_locating;

import com.ancbro.Util;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SolutionTest {

    private static final int MAX_CHARS = 31999;

    @Test
    public void scaleHorizontallyShouldReturnExpectedValue() {
        Assert.assertEquals(1, Solution.seekFloorCell(1));
        Assert.assertEquals(3, Solution.seekFloorCell(2));
        Assert.assertEquals(6, Solution.seekFloorCell(3));
        Assert.assertEquals(10, Solution.seekFloorCell(4));
        Assert.assertEquals(15, Solution.seekFloorCell(5));
        Assert.assertEquals(21, Solution.seekFloorCell(6));
        Assert.assertEquals(28, Solution.seekFloorCell(7));
    }

    @Test
    public void scaleVerticallyShouldReturnExpectedValue() {
        Assert.assertEquals(1, Solution.seekCellId(1, 1));
        Assert.assertEquals(2, Solution.seekCellId(1, 2));
        Assert.assertEquals(3, Solution.seekCellId(2, 1));
        Assert.assertEquals(5, Solution.seekCellId(2, 2));
        Assert.assertEquals(8, Solution.seekCellId(2, 3));
        Assert.assertEquals(9, Solution.seekCellId(3, 2));
        Assert.assertEquals(13, Solution.seekCellId(3, 3));
    }

    @Test
    public void solutionShouldReturnExpectedValue() {
        Assert.assertEquals("9", Solution.solution(3, 2));
        Assert.assertEquals("96", Solution.solution(5, 10));
    }

    @Test
    public void solutionShouldHaveLessCharsThanMandated() throws IOException {
        int numCharsInSolutionFile = Util.countCharsInFile("src/main/java/com/ancbro/bunny_prisoner_locating/Solution.java");
        System.out.println(numCharsInSolutionFile);
        Assert.assertTrue(numCharsInSolutionFile <= MAX_CHARS);
    }
}