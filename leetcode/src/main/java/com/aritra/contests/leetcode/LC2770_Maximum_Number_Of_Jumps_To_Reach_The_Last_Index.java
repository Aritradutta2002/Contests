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

    public static void main(String[] args) {
        LC2770_Maximum_Number_Of_Jumps_To_Reach_The_Last_Index solution = new LC2770_Maximum_Number_Of_Jumps_To_Reach_The_Last_Index();

        // Example 1: validates the basic reachable path with 3 jumps.
        runTest(solution, new int[]{1, 3, 6, 4, 1, 2}, 2, 3, "Test Case 1");

        // Example 2: validates the longest example path with 5 jumps.
        runTest(solution, new int[]{1, 3, 6, 4, 1, 2}, 3, 5, "Test Case 2");

        // Example 3: validates the unreachable case that returns -1.
        runTest(solution, new int[]{1, 3, 6, 4, 1, 2}, 0, -1, "Test Case 3");
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
