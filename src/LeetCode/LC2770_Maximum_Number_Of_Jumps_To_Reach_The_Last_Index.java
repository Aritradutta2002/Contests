package LeetCode;

import java.util.*;

/**
 * LeetCode 2770: Maximum Number of Jumps to Reach the Last Index
 * 
 * Problem:
 * You are given a 0-indexed array nums of n integers and an integer target.
 * You are initially positioned at index 0. In one step, you can jump from index i 
 * to any index j such that 0 <= i < j < n and -target <= nums[j] - nums[i] <= target.
 * 
 * Return the maximum number of jumps you can make to reach index n - 1.
 * If there is no way to reach index n - 1, return -1.
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
     * Find the maximum number of jumps to reach the last index.
     * 
     * @param nums array of integers
     * @param target the maximum difference allowed for a jump
     * @return maximum number of jumps to reach last index, or -1 if unreachable
     */
    public int maximumJumps(int[] nums, int target) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
    public static void main(String[] args) {
        LC2770_Maximum_Number_Of_Jumps_To_Reach_The_Last_Index solution = 
            new LC2770_Maximum_Number_Of_Jumps_To_Reach_The_Last_Index();
        
        // Test Case 1: Example from problem
        // nums = [1,3,6,4,1,2], target = 2
        // Expected: 3
        // Explanation: Jump 0 -> 1 -> 3 -> 5, making 3 jumps total
        int[] nums1 = {1, 3, 6, 4, 1, 2};
        int target1 = 2;
        int result1 = solution.maximumJumps(nums1, target1);
        System.out.println("Test Case 1: " + (result1 == 3 ? "Pass" : "Fail") + 
                         " (Expected: 3, Got: " + result1 + ")");
        
        // Test Case 2: Example from problem with larger target
        // nums = [1,3,6,4,1,2], target = 3
        // Expected: 5
        // Explanation: Jump 0 -> 1 -> 2 -> 3 -> 4 -> 5, making 5 jumps
        int[] nums2 = {1, 3, 6, 4, 1, 2};
        int target2 = 3;
        int result2 = solution.maximumJumps(nums2, target2);
        System.out.println("Test Case 2: " + (result2 == 5 ? "Pass" : "Fail") + 
                         " (Expected: 5, Got: " + result2 + ")");
        
        // Test Case 3: Example from problem where no path exists
        // nums = [1,3,6,4,1,2], target = 0
        // Expected: -1
        // Explanation: Cannot jump since no element has difference <= 0 with nums[i]
        int[] nums3 = {1, 3, 6, 4, 1, 2};
        int target3 = 0;
        int result3 = solution.maximumJumps(nums3, target3);
        System.out.println("Test Case 3: " + (result3 == -1 ? "Pass" : "Fail") + 
                         " (Expected: -1, Got: " + result3 + ")");
    }
}
