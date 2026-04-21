package LeetCode;
import java.util.*;
/**
 * Maximum Distance Between a Pair of Values
 *
 * You are given two non-increasing 0-indexed integer arrays nums1 and nums2.
 *
 * A pair of indices (i, j), where 0 <= i < nums1.length and 0 <= j < nums2.length,
 * is valid if both i <= j and nums1[i] <= nums2[j]. The distance of the pair is j - i.
 *
 * Return the maximum distance of any valid pair (i, j). If there are no valid pairs, return 0.
 *
 * Constraints:
 * - 1 <= nums1.length <= 10^5
 * - 1 <= nums2.length <= 10^5
 * - 1 <= nums1[i], nums2[j] <= 10^5
 * - Both nums1 and nums2 are non-increasing.
 *
 * Example:
 * Input: nums1 = [55,30,5,4,2], nums2 = [100,20,10,10,5]
 * Output: 2
 * Explanation: The valid pairs are (0,0), (2,2), (2,3), (2,4), (3,3), (3,4), and (4,4).
 *              The maximum distance is 2 with pair (2,4).
 */
class LC1855_Maximum_Distance_Between_A_Pair_Of_Values {

    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0, j = 0, ans = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                ans = Math.max(ans, j - i);
                j++;
            } else {
                i++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        LC1855_Maximum_Distance_Between_A_Pair_Of_Values solution = new LC1855_Maximum_Distance_Between_A_Pair_Of_Values();

        try {
            int[] nums1 = {55, 30, 5, 4, 2};
            int[] nums2 = {100, 20, 10, 10, 5};
            int expected = 2;
            int result = solution.maxDistance(nums1, nums2);
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

        try {
            int[] nums1 = {2, 2, 2};
            int[] nums2 = {10, 10, 1};
            int expected = 1;
            int result = solution.maxDistance(nums1, nums2);
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

        try {
            int[] nums1 = {30, 29, 19, 5};
            int[] nums2 = {25, 25, 25, 25, 25};
            int expected = 2;
            int result = solution.maxDistance(nums1, nums2);
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
    }

}
