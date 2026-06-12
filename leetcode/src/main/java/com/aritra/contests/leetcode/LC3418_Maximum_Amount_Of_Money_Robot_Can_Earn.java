package com.aritra.contests.leetcode;

import java.util.*;

/**
 * 3418. Maximum Amount of Money Robot Can Earn
 * 
 * Problem Statement:
 * You are given an m x n grid coins. A robot starts at the top-left corner (0,
 * 0)
 * and wants to reach the bottom-right corner (m - 1, n - 1).
 * 
 * - Movement: The robot can only move either right or down at any point.
 * - Grid Values: Each cell (i, j) contains a value coins[i][j]:
 * - If coins[i][j] >= 0, the robot collects that many coins.
 * - If coins[i][j] < 0, the robot encounters a robber who steals the absolute
 * value
 * of coins[i][j] (i.e., the robot's total coins decrease by that value).
 * - Special Ability: The robot has the ability to neutralize robbers in at most
 * 2 cells
 * along its entire path. When a robber is neutralized, the robot loses 0 coins
 * for that cell.
 * - Goal: Find the maximum total coins (profit) the robot can have upon
 * reaching the destination.
 * Note: The robot's total coin count can be negative during its journey.
 * 
 * Constraints:
 * - m == coins.length
 * - n == coins[i].length
 * - 1 <= m, n <= 500
 * - -1000 <= coins[i][j] <= 1000
 */
public class LC3418_Maximum_Amount_Of_Money_Robot_Can_Earn {

    public long maximumAmount(int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;
        Long[][][] memo = new Long[n][m][3];
        return dfs(0, 0, n, m, coins, memo, 2);
    }

    public static long dfs(int i, int j, int n, int m, int[][] coins, Long[][][] memo, int k) {
        if (i >= n || j >= m) {
            return Long.MIN_VALUE / 2; 
        }

        if (i == n - 1 && j == m - 1) {
            if (coins[i][j] < 0 && k > 0) {
                return 0; 
            }
            return coins[i][j];
        }

        if (memo[i][j][k] != null) {
            return memo[i][j][k];
        }

        long currentVal = coins[i][j];

  
        long takeMove = currentVal + Math.max(
            dfs(i + 1, j, n, m, coins, memo, k),
            dfs(i, j + 1, n, m, coins, memo, k)
        );

    
        long neutralizeMove = Long.MIN_VALUE / 2;
        if (currentVal < 0 && k > 0) {
            neutralizeMove = 0 + Math.max(
                dfs(i + 1, j, n, m, coins, memo, k - 1),
                dfs(i, j + 1, n, m, coins, memo, k - 1)
            );
        }
       
        return memo[i][j][k] = Math.max(takeMove, neutralizeMove);
    }

    public static void main(String[] args) {
        LC3418_Maximum_Amount_Of_Money_Robot_Can_Earn solution = new LC3418_Maximum_Amount_Of_Money_Robot_Can_Earn();

        // Test Cases
        int[][][] testCoins = {
                { { 0, 1, -1 }, { 1, -2, 3 }, { 2, -3, 4 } },
                { { 10, 10, 10 }, { 10, 10, 10 } },
                { { 1, -2 }, { -3, 4 } }
        };
        long[] expectedOutputs = { 8L, 40L, 5L };

        boolean allPassed = true;

        for (int i = 0; i < testCoins.length; i++) {
            System.out.print("Test Case " + (i + 1) + ": ");
            try {
                long result = solution.maximumAmount(testCoins[i]);
                if (result == expectedOutputs[i]) {
                    System.out.println("PASS");
                } else {
                    System.out.println("FAIL (Expected " + expectedOutputs[i] + ", got " + result + ")");
                    allPassed = false;
                }
            } catch (UnsupportedOperationException e) {
                System.out.println("SKIPPED (Not implemented yet)");
                allPassed = false;
            } catch (Exception e) {
                System.out.println("FAIL (Exception: " + e.getMessage() + ")");
                allPassed = false;
            }
        }

        System.out.println("========================================");
        if (allPassed) {
            System.out.println("All test cases passed!");
        } else {
            System.out.println("Some test cases failed or were skipped.");
        }
    }
}
