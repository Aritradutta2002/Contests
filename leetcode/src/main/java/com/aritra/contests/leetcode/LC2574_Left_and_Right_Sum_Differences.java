package com.aritra.contests.leetcode;

import java.util.*;
import java.io.*;

/**
 * 2574. Left and Right Sum Differences
 *
 * Description: Given a 0-indexed integer array nums, find a 0-indexed integer
 * array answer where: - answer.length == nums.length. - answer[i] = |leftSum[i]
 * - rightSum[i]|.
 *
 * Where: - leftSum[i] is the sum of elements to the left of the index i in the
 * array nums. If there is no such element, leftSum[i] = 0. - rightSum[i] is the
 * sum of elements to the right of the index i in the array nums. If there is no
 * such element, rightSum[i] = 0.
 *
 * Return the array answer.
 *
 * Constraints: - 1 <= nums.length <= 1000 - 1 <= nums[i] <= 10^5
 */
public class LC2574_Left_and_Right_Sum_Differences {

	public int[] leftRightDifference(int[] nums) {
		int n = nums.length;
		int[] left = new int[n];
		int[] right = new int[n];
		int[] ans = new int[n];
		int arraySum = 0;
		left[0] = 0;

		for (int i : nums) {
			arraySum += i;
		}

		for (int i = 1; i <= n - 1; i++) {
			left[i] = left[i - 1] + nums[i - 1];
		}

		for (int i = 0; i < n; i++) {
			right[i] = arraySum - nums[i];
			arraySum -= nums[i];
		}

		for (int i = 0; i < n; i++) {
			ans[i] = Math.abs(left[i] - right[i]);
		}

		return ans;
	}

	public static void main(String[] args) {
		LC2574_Left_and_Right_Sum_Differences solution = new LC2574_Left_and_Right_Sum_Differences();

		// Test Case 1: Standard case
		int[] nums1 = { 10, 4, 8, 3 };
		int[] expected1 = { 15, 1, 11, 22 };
		int[] actual1 = solution.leftRightDifference(nums1);
		System.out.println("Test Case 1: " + (Arrays.equals(actual1, expected1) ? "Pass" : "Fail"));

		// Test Case 2: Single element
		int[] nums2 = { 1 };
		int[] expected2 = { 0 };
		int[] actual2 = solution.leftRightDifference(nums2);
		System.out.println("Test Case 2: " + (Arrays.equals(actual2, expected2) ? "Pass" : "Fail"));

		// Test Case 3: Incremental values
		int[] nums3 = { 1, 2, 3 };
		int[] expected3 = { 5, 2, 3 };
		int[] actual3 = solution.leftRightDifference(nums3);
		System.out.println("Test Case 3: " + (Arrays.equals(actual3, expected3) ? "Pass" : "Fail"));
	}
}
