package LeetCode;
import java.util.*;
/*
 * Problem 396: Rotate Function
 * 
 * Description:
 * You are given an integer array nums of length n.
 * Assume arrk to be an array obtained by rotating nums by k positions clock-wise.
 * We define the rotation function F on nums as follow:
 *   F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1].
 * Return the maximum value of F(0), F(1), ..., F(n-1).
 * 
 * Constraints:
 * - n == nums.length
 * - 1 <= n <= 10^5
 * - -100 <= nums[i] <= 100
 */
public class LC396_Rotate_Function {

    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int currentFunctionValue = 0;
        int totalSum = 0;
        for(int i = 0; i < n; i++){
            currentFunctionValue += (i * nums[i]);
            totalSum += nums[i];
        }

        int maxValue = currentFunctionValue;
        for(int j = 0; j < n; j++){
            currentFunctionValue = currentFunctionValue + totalSum - (n * nums[n - j - 1]);
            maxValue = Math.max(maxValue, currentFunctionValue);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        LC396_Rotate_Function solution = new LC396_Rotate_Function();
        int passed = 0;
        int failed = 0;

        // Test case 1
        int[] nums1 = {4, 3, 2, 6};
        int expected1 = 26;
        int result1 = solution.maxRotateFunction(nums1);
        if (result1 == expected1) { passed++; System.out.println("Test 1: PASS"); }
        else { failed++; System.out.println("Test 1: FAIL (expected " + expected1 + ", got " + result1 + ")"); }

        // Test case 2
        int[] nums2 = {100};
        int expected2 = 0;
        int result2 = solution.maxRotateFunction(nums2);
        if (result2 == expected2) { passed++; System.out.println("Test 2: PASS"); }
        else { failed++; System.out.println("Test 2: FAIL (expected " + expected2 + ", got " + result2 + ")"); }

        // Test case 3
        int[] nums3 = {2, 3, 4, 5, 6};
        int expected3 = 50;
        int result3 = solution.maxRotateFunction(nums3);
        if (result3 == expected3) { passed++; System.out.println("Test 3: PASS"); }
        else { failed++; System.out.println("Test 3: FAIL (expected " + expected3 + ", got " + result3 + ")"); }

        System.out.println("\nResults: " + passed + " passed, " + failed + " failed");
    }

}
