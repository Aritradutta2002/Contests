package com.aritra.contests.leetcode;

import java.util.Arrays;

/*
 * 1886. Determine Whether Matrix Can Be Obtained By Rotation
 *
 * Given two n x n binary matrices mat and target, return true if mat can be made equal
 * to target by rotating mat in 90-degree increments (any number of times), or false otherwise.
 *
 * Constraints:
 *   n == mat.length == target.length
 *   n == mat[i].length == target[i].length
 *   1 <= n <= 10
 *   mat[i][j] and target[i][j] are 0 or 1
 *
 * Example 1:
 *   mat = [[0,1],[1,0]], target = [[1,0],[0,1]] -> true
 * Example 2:
 *   mat = [[0,1],[1,1]], target = [[1,0],[0,1]] -> false
 * Example 3:
 *   mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]] -> true
 */

public class LC1886_Determine_Whether_Matrix_Can_Be_Obtained_By_Rotation {

    public boolean findRotation(int[][] mat, int[][] target) {
        int[][] cur = mat;
        for (int k = 0; k < 4; k++) {
            if (same(cur, target)) {
                return true;
            }
            cur = rotate90Clockwise(cur);
        }
        return false;
    }

    private static boolean same(int[][] a, int[][] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] rotate90Clockwise(int[][] in) {
        int n = in.length;
        int[][] out = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out[j][n - 1 - i] = in[i][j];
            }
        }
        return out;
    }

    public static void main(String[] args) {
        LC1886_Determine_Whether_Matrix_Can_Be_Obtained_By_Rotation solver =
                new LC1886_Determine_Whether_Matrix_Can_Be_Obtained_By_Rotation();

        TestCase[] tests = new TestCase[]{
                new TestCase(
                        new int[][]{{0, 1}, {1, 0}},
                        new int[][]{{1, 0}, {0, 1}},
                        true),
                new TestCase(
                        new int[][]{{0, 1}, {1, 1}},
                        new int[][]{{1, 0}, {0, 1}},
                        false),
                new TestCase(
                        new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}},
                        new int[][]{{1, 1, 1}, {0, 1, 0}, {0, 0, 0}},
                        true),
                new TestCase(new int[][]{{1}}, new int[][]{{1}}, true),
                new TestCase(new int[][]{{0}}, new int[][]{{1}}, false),
                new TestCase(
                        new int[][]{{1, 0}, {0, 1}},
                        new int[][]{{1, 0}, {0, 1}},
                        true),
        };

        runAllTests(solver, tests);
    }

    private static void runAllTests(
            LC1886_Determine_Whether_Matrix_Can_Be_Obtained_By_Rotation solver, TestCase[] tests) {
        int passed = 0;

        for (int i = 0; i < tests.length; i++) {
            TestCase tc = tests[i];
            try {
                boolean actual = solver.findRotation(tc.mat, tc.target);
                boolean ok = actual == tc.expected;
                if (ok) {
                    passed++;
                }
                System.out.printf(
                        "Test %d | mat=%s, target=%s | expected=%s, actual=%s | %s%n",
                        i + 1,
                        Arrays.deepToString(tc.mat),
                        Arrays.deepToString(tc.target),
                        tc.expected,
                        actual,
                        ok ? "PASS" : "FAIL");
            } catch (UnsupportedOperationException ex) {
                System.out.printf(
                        "Test %d | mat=%s, target=%s | expected=%s | SKIPPED (%s)%n",
                        i + 1,
                        Arrays.deepToString(tc.mat),
                        Arrays.deepToString(tc.target),
                        tc.expected,
                        ex.getMessage());
            }
        }

        System.out.printf("Summary: %d/%d tests passed.%n", passed, tests.length);
    }

    private static class TestCase {
        final int[][] mat;
        final int[][] target;
        final boolean expected;

        TestCase(int[][] mat, int[][] target, boolean expected) {
            this.mat = mat;
            this.target = target;
            this.expected = expected;
        }
    }
}
