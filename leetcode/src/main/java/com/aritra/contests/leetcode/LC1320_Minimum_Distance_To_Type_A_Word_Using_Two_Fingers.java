package com.aritra.contests.leetcode;
import java.util.*;
/*
 * 1320. Minimum Distance to Type a Word Using Two Fingers
 *
 * You have a keyboard layout that looks like:
 *   Q W E R T Y U I O P
 *   A S D F G H J K L
 *   Z X C V B N M
 *
 * You have two fingers placed on the keyboard. Initially, each finger is at
 * some character. Typing a character means moving one of the two fingers to
 * that character. The distance between two characters is the absolute difference
 * of row and column indices (Manhattan distance).
 *
 * Given a string word, return the minimum total distance to type word using
 * two fingers. You can start with any two characters under the two fingers.
 *
 * Constraints:
 * - 2 <= word.length <= 10^4
 * - word consists of uppercase English letters only.
 */
public class LC1320_Minimum_Distance_To_Type_A_Word_Using_Two_Fingers {
    public int minimumDistance(String word) {
        int n = word.length();
        int[][][] dp = new int[n + 1][26][26];
        for (int i = 0; i <= n; i++)
            for (int f1 = 0; f1 < 26; f1++)
                for (int f2 = 0; f2 < 26; f2++)
                    dp[i][f1][f2] = Integer.MAX_VALUE;

        for (int f1 = 0; f1 < 26; f1++)
            for (int f2 = 0; f2 < 26; f2++)
                dp[0][f1][f2] = 0;

        for (int i = 1; i <= n; i++) {
            char c = word.charAt(i - 1);
            int cur = c - 'A';
            for (int f1 = 0; f1 < 26; f1++) {
                for (int f2 = 0; f2 < 26; f2++) {
                    if (dp[i - 1][f1][f2] == Integer.MAX_VALUE) continue;
                    dp[i][cur][f2] = Math.min(dp[i][cur][f2], dp[i - 1][f1][f2] + dist(f1, cur));
                    dp[i][f1][cur] = Math.min(dp[i][f1][cur], dp[i - 1][f1][f2] + dist(f2, cur));
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int f1 = 0; f1 < 26; f1++)
            for (int f2 = 0; f2 < 26; f2++)
                ans = Math.min(ans, dp[n][f1][f2]);
        return ans;
    }
    private int dist(int a, int b) {
        int[] posA = getPos(a);
        int[] posB = getPos(b);
        return Math.abs(posA[0] - posB[0]) + Math.abs(posA[1] - posB[1]);
    }
    private int[] getPos(int idx) {
        int row = idx / 6;
        int col = idx % 6;
        return new int[]{row, col};
    }
    private static void runTest(LC1320_Minimum_Distance_To_Type_A_Word_Using_Two_Fingers solver, int testId, String word, int expected) {
        try {
            int result = solver.minimumDistance(word);
            if (result == expected) {
                System.out.println("Test " + testId + ": PASS");
            } else {
                System.out.println("Test " + testId + ": FAIL");
                System.out.println("  Expected: " + expected);
                System.out.println("  Actual:   " + result);
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Test " + testId + ": SKIPPED (Not implemented)");
        } catch (Exception e) {
            System.out.println("Test " + testId + ": ERROR (" + e.getMessage() + ")");
        }
    }
}
