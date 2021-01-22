package com.acbrown.hey_i_already_did_that;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void solutionShouldReturnExpected() {
    Assert.assertEquals(3, Solution.solution("210022", 3));
    Assert.assertEquals(1, Solution.solution("1211", 10));
  }

  @Test
  public void getNextMinionShouldReturnExpected() {
    Assert.assertEquals("0999", Solution.getNextMinion("1211", 10));
    Assert.assertEquals("8991", Solution.getNextMinion("0999", 10));
  }

  @Test
  public void toBaseTenFromRadixShouldReturnExpected() {
    Assert.assertEquals(4, Solution.toBaseTenFromRadix("0100", 2));
    Assert.assertEquals(2, Solution.toBaseTenFromRadix("02", 3));
  }

  @Test
  public void toRadixFromBaseTenShouldReturnExpected() {
    Assert.assertEquals("1111", Solution.toRadixFromBaseTen("15", 2));
  }

  @Test
  public void sortIdAscendingShouldReturnExpected() {
    Assert.assertEquals("0247", Solution.sortIdAscending("0427"));
    Assert.assertEquals("00001111", Solution.sortIdAscending("01010101"));
  }

  @Test
  public void sortIdDescendingShouldReturnExpected() {
    Assert.assertEquals("7420", Solution.sortIdDescending("0427"));
    Assert.assertEquals("11110000", Solution.sortIdDescending("01010101"));
  }

  @Test
  public void padWithZerosShouldReturnExpected() {
    Assert.assertEquals("0427", Solution.padWithZeros("427", 4));
    Assert.assertEquals("00427", Solution.padWithZeros("427", 5));
  }
}
