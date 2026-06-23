package com.aritra.contests.leetcode;
import java.util.*;
/**
 * LeetCode 2770: Maximum Number of Jumps to Reach the Last Index
 * 
 * Short description:
 * Find the maximum number of valid jumps from index 0 to index n - 1.
 * A jump from i to j is valid when 0 <= i < j < n and
 * -target <= nums[j] - nums[i] <= target.
 * 
 * Constraints:
 * - 2 <= nums.length == n <= 1000
 * - -10^9 <= nums[i] <= 10^9
 * - 0 <= target <= 2 * 10^9
 * 
 * Key Insights:
 * - Use dynamic programming where dp[i] = maximum number of jumps to reach index i
 * - For each position j, check all previous positions i that can jump to j
 * - A jump from i to j is valid if -target <= nums[j] - nums[i] <= target
 */

public class LC2770_Maximum_Number_Of_Jumps_To_Reach_The_Last_Index {

    /**
     * LeetCode method signature.
     */
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1); // Initialize dp with -1 (unreachable)
        dp[0] = 0; // Starting point, no jumps needed
        for(int j = 1; j < n; j++) {
            for(int i = 0; i < j; i++) {
                if(dp[i] != -1 && Math.abs(nums[j] - nums[i]) <= target) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        return dp[n - 1]; // Return the maximum jumps to reach the last index
    }
    private static void runTest(LC2770_Maximum_Number_Of_Jumps_To_Reach_The_Last_Index solution,
                                int[] nums,
                                int target,
                                int expected,
                                String label) {
        try {
            int actual = solution.maximumJumps(nums, target);
            boolean passed = Objects.equals(actual, expected);
            System.out.println(label + ": " + (passed ? "Pass" : "Fail") +
                    " (Expected: " + expected + ", Got: " + actual + ")");
        } catch (UnsupportedOperationException ex) {
            System.out.println(label + ": Fail (Expected: " + expected + ", Got: Not implemented yet.)");
        }
    }
}
