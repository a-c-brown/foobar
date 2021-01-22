package com.acbrown.re_id;

import com.acbrown.Util;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SolutionTest {

  private static final int MAX_CHARS = 31999;

  @Test
  public void sieveShouldReturnExpectedString() {
    Assert.assertEquals("2", Solution.produceStringFromSieveOfEratosthenes(3));
    Assert.assertEquals("23", Solution.produceStringFromSieveOfEratosthenes(4));
    Assert.assertEquals("235", Solution.produceStringFromSieveOfEratosthenes(6));
    Assert.assertEquals("235711", Solution.produceStringFromSieveOfEratosthenes(12));
    Assert.assertEquals("23571113", Solution.produceStringFromSieveOfEratosthenes(14));
    Assert.assertEquals("23571113", Solution.produceStringFromSieveOfEratosthenes(14));
    Assert.assertEquals("2357111317", Solution.produceStringFromSieveOfEratosthenes(18));
    Assert.assertEquals("235711131719", Solution.produceStringFromSieveOfEratosthenes(20));
    Assert.assertEquals("23571113171923", Solution.produceStringFromSieveOfEratosthenes(24));
    Assert.assertEquals("2357111317192329", Solution.produceStringFromSieveOfEratosthenes(30));
  }

  @Test
  public void staticInitializerShouldCreateExpectedString() {
    Assert.assertEquals(10_009, Solution.STRING_OF_PRIMES.length());
  }

  @Test
  public void solutionShouldReturnExpectedSubstring() {
    Assert.assertEquals("23571", Solution.solution(0));
    Assert.assertEquals("71113", Solution.solution(3));
    Assert.assertEquals("19232", Solution.solution(10));
    Assert.assertEquals("02192", Solution.solution(10_000));
  }

  @Test
  public void solutionShouldReturnStringOfLengthFive() {
    for (int i = 0; i < 10_001; i++) {
      Assert.assertEquals(5, Solution.solution(i).length());
    }
  }

  @Test
  public void solutionShouldHaveLessCharsThanMandated() throws IOException {
    int numCharsInSolutionFile =
        Util.countCharsInFile("src/main/java/com/acbrown/re_id/Solution.java");
    System.out.println(numCharsInSolutionFile);
    Assert.assertTrue(numCharsInSolutionFile <= MAX_CHARS);
  }
}
