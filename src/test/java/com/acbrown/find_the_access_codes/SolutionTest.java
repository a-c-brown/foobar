package com.acbrown.find_the_access_codes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest {

  private List<List<Integer>> triples;

  @Before
  public void setup() {
    triples = new ArrayList<>();
  }

  @Test
  public void parseTripleShouldPassGivenTestCases() {
    Assert.assertEquals(1, Solution.solution(new int[] {1, 1, 1}));
    Assert.assertEquals(3, Solution.solution(new int[] {1, 2, 3, 4, 5, 6}));
    Assert.assertEquals(3, Solution.solution(new int[] {1, 1, 1, 6}));
  }

  @Test
  public void parseTriplesShouldReturnSixTriples() {
    List<List<Integer>> trip1 = new ArrayList<>();
    Assert.assertEquals(6, Solution.parseTriples(trip1, new int[] {2, 4, 8, 16, 32}).size());

    List<List<Integer>> trip2 = new ArrayList<>();
    Assert.assertEquals(0, Solution.parseTriples(trip2, new int[] {3, 7, 11}).size());

    List<List<Integer>> trip3 = new ArrayList<>();
    Assert.assertEquals(1, Solution.parseTriples(trip3, new int[] {1, 1, 1}).size());
  }

  @Test
  public void parseTriplesFromIndexShouldReturnExpected() {
    List<List<Integer>> trip1 = new ArrayList<>();
    Assert.assertEquals(
        3, Solution.parseTriplesFromFixedIndex(trip1, new int[] {2, 4, 8, 16, 32}, 4).size());

    List<List<Integer>> trip2 = new ArrayList<>();
    Assert.assertEquals(
        2, Solution.parseTriplesFromFixedIndex(trip2, new int[] {2, 4, 8, 16}, 3).size());

    List<List<Integer>> trip3 = new ArrayList<>();
    Assert.assertEquals(
        1, Solution.parseTriplesFromFixedIndex(trip3, new int[] {2, 4, 8}, 2).size());
  }

  @Test
  public void addTripleToSetShouldAddFirstFoundTriple() {
    List<List<Integer>> expectedTriples = new ArrayList<>();
    expectedTriples.add(Solution.createTriple(2, 6, 12));
    Assert.assertEquals(
        expectedTriples, Solution.addTripleToSet(triples, new int[] {4, 2, 6, 8, 2, 6, 12}, 6, 5));
  }

  @Test
  public void addTripleToSetShouldFindNoTriples() {
    Assert.assertEquals(0, Solution.addTripleToSet(triples, new int[] {3, 7}, 1, 0).size());
  }

  @Test
  public void populateATripleShouldReturnComparableTriples() {
    List<Integer> firstOrder = Solution.createTriple(1, 2, 3);
    List<Integer> secondOrderSameAsFirstOrder = Solution.createTriple(1, 2, 3);
    List<Integer> thirdOrder = Solution.createTriple(2, 1, 3);
    Assert.assertEquals(firstOrder, secondOrderSameAsFirstOrder);
    Assert.assertNotEquals(firstOrder, thirdOrder);
  }
}
