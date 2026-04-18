package LeetCode;
import java.util.*;
/**
 * Trapping Rain Water
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 * Constraints:
 * - n == height.length
 * - 1 <= n <= 2 * 10^4
 * - 0 <= height[i] <= 10^5
 *
 * Example 1:
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: 6 units of rain water are being trapped.
 *
 * Example 2:
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 */
class LC42_Trapping_Rain_Water {

    public int trap(int[] height) {
        
    }


    public static void main(String[] args) {
        LC42_Trapping_Rain_Water solution = new LC42_Trapping_Rain_Water();

        try {
            int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
            int expected1 = 6;
            int result1 = solution.trap(height1);
            if (result1 == expected1) {
                System.out.println("Test 1: PASS");
            } else {
                System.out.println("Test 1: FAIL");
                System.out.println("  Expected: " + expected1);
                System.out.println("  Got:      " + result1);
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Test 1: SKIPPED");
        }

        try {
            int[] height2 = {4, 2, 0, 3, 2, 5};
            int expected2 = 9;
            int result2 = solution.trap(height2);
            if (result2 == expected2) {
                System.out.println("Test 2: PASS");
            } else {
                System.out.println("Test 2: FAIL");
                System.out.println("  Expected: " + expected2);
                System.out.println("  Got:      " + result2);
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Test 2: SKIPPED");
        }

        try {
            int[] height3 = {3, 0, 2, 0, 4};
            int expected3 = 7;
            int result3 = solution.trap(height3);
            if (result3 == expected3) {
                System.out.println("Test 3: PASS");
            } else {
                System.out.println("Test 3: FAIL");
                System.out.println("  Expected: " + expected3);
                System.out.println("  Got:      " + result3);
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Test 3: SKIPPED");
        }
    }

}
