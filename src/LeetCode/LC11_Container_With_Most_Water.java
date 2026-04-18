package LeetCode;
import java.util.*;
/**
 * Container With Most Water
 *
 * You are given an integer array height of length n. There are n vertical lines drawn such that
 * the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container
 * contains the most water. Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 *
 *  8 |  |           |
 *  7 |  |~~~~~~~~~~~|~~~ |
 *  6 |  |  |        |   |
 *  5 |  |  |   |    |   |
 *  4 |  |  |   |  | |   |
 *  3 |  |  |   |  | | | |
 *  2 |  |  |   |  | | | |
 *  1 || |  |   |  | | | |
 *    +--+--+---+--+-+-+-+
 *     1  8  6  2  5 4 8 3 7
 *        ^-----------^
 *        left=1    right=6  area = min(8,7) * (6-1) = 7*5 = 35? No...
 *        left=1    right=8  area = min(8,7) * (8-1) = 7*7 = 49 ✓
 *
 * Constraints:
 * - n == height.length
 * - 2 <= n <= 10^5
 * - 0 <= height[i] <= 10^4
 *
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The max area of water the container can contain is 49.
 *
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 */
class LC11_Container_With_Most_Water {

    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxArea = 0;

        while(start <= end){
            int area = Math.min(height[start], height[end]) * (end - start);
            maxArea = Math.max(maxArea, area);
            if(height[start] <= height[end]){
                start++;
            } else{
                end--;
            }
        }
        return maxArea;
    }


    public static void main(String[] args) {
        LC11_Container_With_Most_Water solution = new LC11_Container_With_Most_Water();

        try {
            int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
            int expected1 = 49;
            int result1 = solution.maxArea(height1);
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
            int[] height2 = {1, 1};
            int expected2 = 1;
            int result2 = solution.maxArea(height2);
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
            int[] height3 = {4, 3, 2, 1, 4};
            int expected3 = 16;
            int result3 = solution.maxArea(height3);
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
