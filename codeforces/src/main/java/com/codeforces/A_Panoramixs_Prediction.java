package com.codeforces;
import java.util.*;
/*
 * Problem: A. Panoramix's Prediction
 * Platform: Codeforces
 *
 * Short Description:
 * Given two integers n and m, determine whether m is the immediate next prime
 * number after n.
 *
 * Constraints:
 * 2 <= n < m <= 50
 *
 * Input Format:
 * One line containing two space-separated integers n and m.
 *
 * Output Format:
 * Print "YES" if m is the next prime after n, otherwise print "NO".
 */
public class A_Panoramixs_Prediction {
    public static String panoramixPrediction(int n, int m) {
        return sieve(n, m) ? "YES" : "NO";
    }
    static boolean sieve(int n, int m) {
        boolean[] isPrime = new boolean[m + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= m; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= m; j += i) isPrime[j] = false;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= m; i++) {
            if (isPrime[i]) {
                list.add(i);
            }
        }

        // Check if m is in the list (is prime) and n is the prime right before it
        if (list.size() < 2) return false;
        return (list.get(list.size() - 1) == m && list.get(list.size() - 2) == n);
    }
    private static void runTests(List<TestCase> tests) {
        int passed = 0;
        int failed = 0;
        int skipped = 0;

        for (TestCase tc : tests) {
            String actual;
            try {
                actual = panoramixPrediction(tc.n, tc.m);
            } catch (UnsupportedOperationException ex) {
                System.out.println(tc.name + " -> SKIPPED (method not implemented)");
                skipped++;
                continue;
            } catch (Exception ex) {
                System.out.println(tc.name + " -> FAIL (unexpected error: " + ex.getMessage() + ")");
                failed++;
                continue;
            }

            if (tc.expected.equals(actual)) {
                System.out.println(tc.name + " -> PASS");
                passed++;
            } else {
                System.out.println(tc.name + " -> FAIL (expected: " + tc.expected + ", actual: " + actual + ")");
                failed++;
            }
        }

        System.out.println();
        System.out.println("Summary: PASS=" + passed + ", FAIL=" + failed + ", SKIPPED=" + skipped);
    }
    private static class TestCase {
        final int n;
        final int m;
        final String expected;
        final String name;

        TestCase(int n, int m, String expected, String name) {
            this.n = n;
            this.m = m;
            this.expected = expected;
            this.name = name;
        }
    }
}