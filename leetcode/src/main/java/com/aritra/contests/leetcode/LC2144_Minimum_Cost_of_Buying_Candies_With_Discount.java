package com.aritra.contests.leetcode;

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
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public static void main(String[] args) {
        LC2144_Minimum_Cost_of_Buying_Candies_With_Discount solver = new LC2144_Minimum_Cost_of_Buying_Candies_With_Discount();

        // Test case 1: cost = [1, 2, 3] -> expected 5
        // Buy candies with cost 2 and 3, get candy with cost 1 for free.
        int[] cost1 = {1, 2, 3};
        int expected1 = 5;
        try {
            int result1 = solver.minimumCost(cost1);
            System.out.println("Test 1: " + (result1 == expected1 ? "Pass" : "Fail") +
                    " (expected=" + expected1 + ", got=" + result1 + ")");
        } catch (UnsupportedOperationException e) {
            System.out.println("Test 1: Not implemented (expected=" + expected1 + ")");
        }

        // Test case 2: cost = [6, 5, 7, 9, 2, 2] -> expected 23
        // Group (9, 7) pay, get 6 free. Group (5, 2) pay, get 2 free. Total = 9 + 7 + 5 + 2 = 23.
        int[] cost2 = {6, 5, 7, 9, 2, 2};
        int expected2 = 23;
        try {
            int result2 = solver.minimumCost(cost2);
            System.out.println("Test 2: " + (result2 == expected2 ? "Pass" : "Fail") +
                    " (expected=" + expected2 + ", got=" + result2 + ")");
        } catch (UnsupportedOperationException e) {
            System.out.println("Test 2: Not implemented (expected=" + expected2 + ")");
        }

        // Test case 3: cost = [5, 5] -> expected 10
        // Only 2 candies, must buy both of them.
        int[] cost3 = {5, 5};
        int expected3 = 10;
        try {
            int result3 = solver.minimumCost(cost3);
            System.out.println("Test 3: " + (result3 == expected3 ? "Pass" : "Fail") +
                    " (expected=" + expected3 + ", got=" + result3 + ")");
        } catch (UnsupportedOperationException e) {
            System.out.println("Test 3: Not implemented (expected=" + expected3 + ")");
        }
    }
}
