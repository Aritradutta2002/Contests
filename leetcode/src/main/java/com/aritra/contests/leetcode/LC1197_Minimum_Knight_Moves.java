package com.aritra.contests.leetcode;

/*
 * 1197. Minimum Knight Moves
 *
 * Problem Description (paraphrased):
 * You are given an infinite chessboard with coordinates extending in all directions.
 * A knight starts at position (0, 0). In one move, a knight can move to any of the
 * following 8 positions from (r, c):
 *   (r + 2, c + 1), (r + 2, c - 1), (r - 2, c + 1), (r - 2, c - 1),
 *   (r + 1, c + 2), (r + 1, c - 2), (r - 1, c + 2), (r - 1, c - 2)
 *
 * Your task is to return the minimum number of knight moves required to reach
 * target coordinate (x, y) from (0, 0).
 *
 * Constraints:
 * - -300 <= x, y <= 300
 *
 * Method Signature:
 *   int minKnightMoves(int x, int y)
 *
 * Return:
 * - Minimum number of moves to reach (x, y).
 *
 * Sample Test Cases:
 * 1)
 * Input:  x = 2, y = 1
 * Output: 1
 * Explanation: Move directly from (0,0) to (2,1).
 *
 * 2)
 * Input:  x = 5, y = 5
 * Output: 4
 * Explanation: One shortest path uses 4 knight moves.
 *
 * 3)
 * Input:  x = 0, y = 0
 * Output: 0
 * Explanation: Already at the target.
 */
public class LC1197_Minimum_Knight_Moves {
    public static int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);

        if (x > y) {
            int temp = x;
            x = y;
            y = temp;
        }

        if (x == 0 && y == 1)
            return 3;
        if (x == 1 && y == 1)
            return 2;
        if (y >= 2 * x) {
            return (y + 1) / 2 + (y / 2 - x) % 2;
        } else {
            return (y + x) / 3 + (y + x) % 3;
        }
    }
    private static void runTest(LC1197_Minimum_Knight_Moves solver, int testId, int x, int y, int expected) {
        try {
            int result = solver.minKnightMoves(x, y);
            if (result == expected) {
                System.out.println("Test " + testId + ": PASS");
            } else {
                System.out.println("Test " + testId + ": FAIL");
                System.out.println("  Input:    x = " + x + ", y = " + y);
                System.out.println("  Expected: " + expected);
                System.out.println("  Actual:   " + result);
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Test " + testId + ": SKIPPED (Not implemented)");
        }
    }
}
