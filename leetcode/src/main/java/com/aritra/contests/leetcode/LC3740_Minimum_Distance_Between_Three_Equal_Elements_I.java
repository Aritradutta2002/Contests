package com.aritra.contests.leetcode;
import java.util.*;
/**
 * 3740. Minimum Distance Between Three Equal Elements I
 * 
 * Problem Description:
 * You are given an integer array nums. A tuple (i, j, k) of 3 distinct indices is "good" if nums[i] == nums[j] == nums[k].
 * The distance of a good tuple is calculated as: abs(i - j) + abs(j - k) + abs(k - i).
 * Return the minimum possible distance among all good tuples, or -1 if no good tuples exist.
 * 
 * Constraints:
 * - 1 <= n == nums.length <= 100
 * - 1 <= nums[i] <= n
 */
public class LC3740_Minimum_Distance_Between_Three_Equal_Elements_I {
    /**
     * Finds the minimum distance between three equal elements.
     * 
     * @param nums The input array.
     * @return The minimum distance, or -1 if no good tuple exists.
     */
    public int minimumDistance(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            if (num > maxVal) maxVal = num;
        }

        int[] last = new int[maxVal + 1];
        int[] secondLast = new int[maxVal + 1];
        Arrays.fill(last, -1);
        Arrays.fill(secondLast, -1);

        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (secondLast[x] != -1) {
                int dist = 2 * (i - secondLast[x]);
                minDistance = Math.min(minDistance, dist);
            }
            secondLast[x] = last[x];
            last[x] = i;
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
    private static void runTestCase(LC3740_Minimum_Distance_Between_Three_Equal_Elements_I solver, int testCaseNum, int[] nums, int expected) {
        System.out.print("Test Case " + testCaseNum + ": ");
        try {
            int result = solver.minimumDistance(nums);
            if (result == expected) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL (Expected: " + expected + ", Got: " + result + ")");
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("SKIPPED");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
