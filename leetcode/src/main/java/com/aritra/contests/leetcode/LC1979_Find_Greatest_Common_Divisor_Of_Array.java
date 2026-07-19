package com.aritra.contests.leetcode;
/**
 * 1979. Find Greatest Common Divisor of Array
 * https://leetcode.com/problems/find-greatest-common-divisor-of-array/
 *
 * Given an integer array nums, return the greatest common divisor of the smallest
 * number and largest number in nums.
 *
 * Constraints:
 * - 2 <= nums.length <= 1000
 * - 1 <= nums[i] <= 1000
 */
public class LC1979_Find_Greatest_Common_Divisor_Of_Array {

    public int findGCD(int[] nums) {
        int largest = nums[0];
        int smallest = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > largest) {
                largest = nums[i];
            }
            if (nums[i] < smallest) {
                smallest = nums[i];
            }
        }
        return gcd(largest, smallest);
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}