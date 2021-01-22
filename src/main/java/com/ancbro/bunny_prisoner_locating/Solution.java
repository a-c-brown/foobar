package com.ancbro.bunny_prisoner_locating;

public class Solution {

  private Solution() {
    throw new IllegalStateException("Non-instantiable");
  }

  public static String solution(long x, long y) {
    return String.valueOf(seekCellId(x, y));
  }

  public static long seekCellId(long x, long y) {
    long addend = x;
    long accum = seekFloorCell(x);
    for (long i = 1; i < y; i++) {
      accum += addend;
      addend++;
    }
    return accum;
  }

  public static long seekFloorCell(long x) {
    long accum = 0;
    for (long i = 1; i <= x; i++) {
      accum += i;
    }
    return accum;
  }
}
