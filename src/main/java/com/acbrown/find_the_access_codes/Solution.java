package com.acbrown.find_the_access_codes;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  private Solution() {
    throw new IllegalStateException("Non-instantiable");
  }

  public static int solution(int[] l) {
    List<List<Integer>> triples = new ArrayList<>();
    return parseTriples(triples, l).size();
  }

  public static List<List<Integer>> parseTriples(List<List<Integer>> triples, int[] codeList) {
    for (int i = codeList.length - 1; i >= 2; i--) {
      parseTriplesFromFixedIndex(triples, codeList, i);
    }
    return triples;
  }

  public static List<List<Integer>> parseTriplesFromFixedIndex(
      List<List<Integer>> triples, int[] codeList, int index) {
    int indexOfYVal = index - 1;
    for (int i = indexOfYVal; i >= 0; i--) {
      addTripleToSet(triples, codeList, index, i);
    }
    return triples;
  }

  public static List<List<Integer>> addTripleToSet(
      List<List<Integer>> triples, int[] codeList, int indexOfZVal, int indexOfYVal) {
    int zVal = codeList[indexOfZVal];
    int yVal = codeList[indexOfYVal];
    if (isDivisor(zVal, yVal)) {
      for (int i = indexOfYVal - 1; i >= 0; i--) {
        int xVal = codeList[i];
        if (isDivisor(yVal, xVal)) {
          triples.add(createTriple(xVal, yVal, zVal));
          break;
        }
      }
    }
    return triples;
  }

  public static boolean isDivisor(int num1, int num2) {
    return num1 % num2 == 0;
  }

  public static List<Integer> createTriple(int x, int y, int z) {
    ArrayList<Integer> triple = new ArrayList<>(3);
    triple.add(x);
    triple.add(y);
    triple.add(z);
    return triple;
  }
}
