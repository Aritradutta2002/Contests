package LeetCode;
import java.util.*;
/*
 * 325. Maximum Size Subarray Sum Equals k
 * 
 * Given an integer array nums and an integer k, return the maximum length of a
 * subarray that sums to k. If there is not one, return 0 instead.
 * 
 * Constraints:
 * - 1 <= nums.length <= 2 * 10^5
 * - -10^4 <= nums[i] <= 10^4
 * - -10^9 <= k <= 10^9
 * - The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
 */
public class LC325_Maximum_Size_Subarray_Sum_Equals_k {
    public int maxSubArrayLen(int[] nums, int k) {
        int prefixSum = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> firstIndex = new HashMap<>();
        firstIndex.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (firstIndex.containsKey(prefixSum - k)) {
                maxLen = Math.max(maxLen, i - firstIndex.get(prefixSum - k));
            }
            firstIndex.putIfAbsent(prefixSum, i);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LC325_Maximum_Size_Subarray_Sum_Equals_k solver = new LC325_Maximum_Size_Subarray_Sum_Equals_k();
        Scanner sc = new Scanner(System.in);

        // Test Case 1
        int[] nums1 = {1, -1, 5, -2, 3};
        runTest(solver, 1, nums1, 3, 4);

        // Test Case 2
        int[] nums2 = {-2, -1, 2, 1};
        runTest(solver, 2, nums2, 1, 2);

        // Test Case 3
        int[] nums3 = {1, 2, 3};
        runTest(solver, 3, nums3, 7, 0);

        sc.close();
    }

    private static void runTest(LC325_Maximum_Size_Subarray_Sum_Equals_k solver, int testId, int[] nums, int k, int expected) {
        try {
            int result = solver.maxSubArrayLen(nums, k);
            if (result == expected) {
                System.out.println("Test " + testId + ": PASS");
            } else {
                System.out.println("Test " + testId + ": FAIL");
                System.out.println("  Expected: " + expected);
                System.out.println("  Actual:   " + result);
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Test " + testId + ": SKIPPED (Not implemented)");
        } catch (Exception e) {
            System.out.println("Test " + testId + ": ERROR (" + e.getMessage() + ")");
        }
    }
}
