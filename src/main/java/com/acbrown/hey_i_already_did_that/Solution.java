package com.acbrown.hey_i_already_did_that;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

  private Solution() {
    throw new IllegalStateException("Non-instantiable");
  }

  public static int solution(String n, int b) {
    List<String> minions = new ArrayList<>();
    boolean minionNotAssigned = true;
    String nextMinion = n;
    minions.add(nextMinion);
    while (minionNotAssigned) {
      nextMinion = getNextMinion(nextMinion, b);
      if (minions.contains(nextMinion)) {
        minionNotAssigned = false;
      } else {
        minions.add(nextMinion);
      }
    }
    return minions.size() - minions.indexOf(nextMinion);
  }

  public static String getNextMinion(String minionId, int radix) {
    int x = toBaseTenFromRadix(sortIdDescending(minionId), radix);
    int y = toBaseTenFromRadix(sortIdAscending(minionId), radix);
    int z = x - y;
    return padWithZeros(toRadixFromBaseTen(String.valueOf(z), radix), minionId.length());
  }

  public static int toBaseTenFromRadix(String number, int radix) {
    return Integer.parseInt(number, radix);
  }

  public static String toRadixFromBaseTen(String number, int radix) {
    return Integer.toString(Integer.parseInt(number, 10), radix);
  }

  public static String sortIdAscending(String minionId) {
    char[] chars = minionId.toCharArray();
    Arrays.sort(chars);
    return String.valueOf(chars);
  }

  public static String sortIdDescending(String minionId) {
    String[] chars = minionId.split("");
    Arrays.sort(chars, Collections.reverseOrder());
    StringBuilder sb = new StringBuilder(minionId.length());
    for (String str : chars) {
      sb.append(str);
    }
    return sb.toString();
  }

  public static String padWithZeros(String inputString, int lengthOfString) {
    return String.format(String.format("%%1$%ds", lengthOfString), inputString).replace(' ', '0');
  }
}
