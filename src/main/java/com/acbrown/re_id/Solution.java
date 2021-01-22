package com.acbrown.re_id;

public class Solution {
  public static final String STRING_OF_PRIMES;
  public static final int MAX_ARG_REQUIRED = 20_233;
  public static final int MAX_CHARS_PRODUCED_BY_SIEVE = 20_233;

  static {
    STRING_OF_PRIMES = produceStringFromSieveOfEratosthenes(MAX_ARG_REQUIRED);
  }

  private Solution() {
    throw new IllegalStateException("Non-instantiable");
  }

  public static String solution(int n) {
    StringBuilder sb = new StringBuilder(5);
    for (int i = 0; i < 5; i++) {
      sb.append(STRING_OF_PRIMES.charAt(n + i));
    }
    return sb.toString();
  }

  public static String produceStringFromSieveOfEratosthenes(int n) {
    boolean[] prime = new boolean[n + 1];
    for (int i = 0; i < n; i++) {
      prime[i] = true;
    }
    for (int p = 2; p * p <= n; p++) {
      if (prime[p]) {
        for (int i = p * 2; i <= n; i += p) prime[i] = false;
      }
    }
    StringBuilder sb = new StringBuilder(MAX_CHARS_PRODUCED_BY_SIEVE);
    for (int i = 2; i <= n; i++) {
      if (prime[i]) sb.append(i);
    }
    return sb.toString();
  }
}
