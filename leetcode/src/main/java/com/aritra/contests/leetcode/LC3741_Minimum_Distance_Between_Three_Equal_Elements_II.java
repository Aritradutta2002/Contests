package com.aritra.contests.leetcode;
import java.util.*;
/**
 * 3741. Minimum Distance Between Three Equal Elements II
 * 
 * Problem Description:
 * You are given an integer array nums. A tuple (i, j, k) of 3 distinct indices is "valid"
 * if nums[i] == nums[j] == nums[k].
 * The distance of a valid tuple is calculated as: abs(i - j) + abs(j - k) + abs(k - i).
 * Return the minimum possible distance among all valid tuples, or -1 if no valid tuples exist.
 * 
 * Constraints:
 * - 1 <= n == nums.length <= 10^5
 * - 1 <= nums[i] <= n
 */
public class LC3741_Minimum_Distance_Between_Three_Equal_Elements_II {
    /**
     * Finds the minimum distance between three equal elements.
     * 
     * @param nums The input array.
     * @return The minimum distance, or -1 if no valid tuple exists.
     */
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int[] first = new int[n + 1];
        int[] second = new int[n + 1];
        int[] count = new int[n + 1];
        Arrays.fill(first, -1);
        Arrays.fill(second, -1);
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int value = nums[i];

            if (count[value] >= 2) {
                minDistance = Math.min(minDistance, 2 * (i - first[value]));
            }

            if (count[value] == 0) {
                first[value] = i;
            } else if (count[value] == 1) {
                second[value] = i;
            } else {
                first[value] = second[value];
                second[value] = i;
            }

            count[value]++;
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}
