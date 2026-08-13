package com.leetcode;

import java.util.*;

/**
 * 2144. Minimum Cost of Buying Candies With Discount
 *
 * A shop is selling candies where for every two candies you buy, you can get a third candy for free.
 * The condition for the free candy is that its cost must be less than or equal to the minimum cost
 * of the two candies you purchased.
 *
 * Constraints:
 * - 1 <= cost.length <= 100
 * - 1 <= cost[i] <= 100
 */
public class LC2144_Minimum_Cost_of_Buying_Candies_With_Discount {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int total = 0, n = cost.length;
        for (int i = n - 1; i >= 0; i -= 3) {
            total += cost[i];
            if (i - 1 >= 0) total += cost[i - 1];
        }
        return total;
    }}
