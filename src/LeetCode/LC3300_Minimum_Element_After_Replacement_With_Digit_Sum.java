package LeetCode;
import java.util.*;
/*
 * 3300. Minimum Element After Replacement With Digit Sum
 *
 * You are given an integer array nums.
 * You replace each element in nums with the sum of its digits.
 * Return the minimum element in nums after all replacements.
 *
 * Constraints:
 *   - 1 <= nums.length <= 100
 *   - 1 <= nums[i] <= 10^4
 */

class LC3300_Minimum_Element_After_Replacement_With_Digit_Sum {

    public int minElement(int[] nums) {
        int n = nums.length;
        int minimum = Integer.MAX_VALUE;
        for(int i : nums){
            minimum = Math.min(minimum, digitSum(i));
        }
        return minimum;
    }

    public int digitSum (int n) {
        int sum = 0;
        while(n >  0){
            sum += n%10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        LC3300_Minimum_Element_After_Replacement_With_Digit_Sum solution = new LC3300_Minimum_Element_After_Replacement_With_Digit_Sum();

        // Test Case 1: [10,12,13,14] -> [1,3,4,5] -> min is 1
        int[] nums1 = {10, 12, 13, 14};
        int expected1 = 1;
        int result1 = solution.minElement(nums1);
        System.out.println("Test 1: " + (result1 == expected1 ? "Pass" : "Fail") + " (Expected: " + expected1 + ", Got: " + result1 + ")");

        // Test Case 2: [1,2,3,4] -> [1,2,3,4] -> min is 1
        int[] nums2 = {1, 2, 3, 4};
        int expected2 = 1;
        int result2 = solution.minElement(nums2);
        System.out.println("Test 2: " + (result2 == expected2 ? "Pass" : "Fail") + " (Expected: " + expected2 + ", Got: " + result2 + ")");

        // Test Case 3: [999,19,199] -> [27,10,19] -> min is 10
        int[] nums3 = {999, 19, 199};
        int expected3 = 10;
        int result3 = solution.minElement(nums3);
        System.out.println("Test 3: " + (result3 == expected3 ? "Pass" : "Fail") + " (Expected: " + expected3 + ", Got: " + result3 + ")");
    }
}
