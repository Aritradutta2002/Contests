package com.aritra.contests.leetcode;
import java.util.*;
/**
 * 2540. Minimum Common Value
 *
 * Given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * return the minimum integer common to both arrays. If there is no common
 * integer, return -1.
 *
 * Note: An integer is considered common if it appears in both arrays.
 *
 * Constraints:
 * - 1 <= nums1.length, nums2.length <= 10^5
 * - 1 <= nums1[i], nums2[j] <= 10^9
 * - Both nums1 and nums2 are sorted in non-decreasing order.
 *
 * Example 1:
 * Input:  nums1 = [1,2,3], nums2 = [2,4]
 * Output: 2
 * Explanation: The smallest common element is 2.
 *
 * Example 2:
 * Input:  nums1 = [1,2,3,6], nums2 = [2,3,4,5]
 * Output: 2
 * Explanation: There are two common elements: 2 and 3. The minimum is 2.
 */
class LC2540_Minimum_Common_Value {

    public int getCommon(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums1){
            set.add(i);
        }
        for(int i : nums2){
            if(set.contains(i)){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        LC2540_Minimum_Common_Value solution = new LC2540_Minimum_Common_Value();

        // Test 1: single common element
        try {
            int[] nums1 = {1, 2, 3};
            int[] nums2 = {2, 4};
            int expected = 2;
            int result = solution.getCommon(nums1, nums2);
            if (result == expected) {
                System.out.println("Test 1: PASS");
            } else {
                System.out.println("Test 1: FAIL");
                System.out.println("  Expected: " + expected);
                System.out.println("  Got:      " + result);
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Test 1: SKIPPED");
        }

        // Test 2: multiple common elements — return the minimum
        try {
            int[] nums1 = {1, 2, 3, 6};
            int[] nums2 = {2, 3, 4, 5};
            int expected = 2;
            int result = solution.getCommon(nums1, nums2);
            if (result == expected) {
                System.out.println("Test 2: PASS");
            } else {
                System.out.println("Test 2: FAIL");
                System.out.println("  Expected: " + expected);
                System.out.println("  Got:      " + result);
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Test 2: SKIPPED");
        }

        // Test 3: no common element — return -1
        try {
            int[] nums1 = {1, 3, 5};
            int[] nums2 = {2, 4, 6};
            int expected = -1;
            int result = solution.getCommon(nums1, nums2);
            if (result == expected) {
                System.out.println("Test 3: PASS");
            } else {
                System.out.println("Test 3: FAIL");
                System.out.println("  Expected: " + expected);
                System.out.println("  Got:      " + result);
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Test 3: SKIPPED");
        }

        // Test 4: identical single-element arrays
        try {
            int[] nums1 = {7};
            int[] nums2 = {7};
            int expected = 7;
            int result = solution.getCommon(nums1, nums2);
            if (result == expected) {
                System.out.println("Test 4: PASS");
            } else {
                System.out.println("Test 4: FAIL");
                System.out.println("  Expected: " + expected);
                System.out.println("  Got:      " + result);
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Test 4: SKIPPED");
        }
    }

}
