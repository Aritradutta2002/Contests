package com.leetcode;
/**
 * 1140. Stone Game II
 *
 * Alice and Bob continue their games with piles of stones. There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i]. The objective of the game is to end with the most stones.
 * 
 * Alice and Bob take turns, with Alice starting first.
 * 
 * On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M. Then, we set M = max(M, X). Initially, M = 1.
 * 
 * The game continues until all the stones have been taken.
 * 
 * Assuming Alice and Bob play optimally, return the maximum number of stones Alice can get.
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: piles = [2,7,9,4,4]
 * 
 * Output: 10
 * 
 * Explanation:
 * 
 * ...
 */
public class LC1140_Stone_Game_II {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffix = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) suffix[i] = suffix[i + 1] + piles[i];
        int[][] dp = new int[n + 1][n + 1];
        for (int index = n - 1; index >= 0; index--) {
            for (int limit = n; limit >= 1; limit--) {
                int best = 0;
                for (int take = 1; take <= 2 * limit && index + take <= n; take++) {
                    best = Math.max(best, suffix[index] - dp[index + take][Math.max(limit, take)]);
                }
                dp[index][limit] = best;
            }
        }
        return dp[0][1];
    }
}