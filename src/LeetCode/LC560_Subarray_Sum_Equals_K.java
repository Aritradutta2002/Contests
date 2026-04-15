package LeetCode;
import java.util.*;
/**
 * 560. Subarray Sum Equals K
 * 
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * 
 * Constraints:
 * 1 <= nums.length <= 2 * 10^4
 * -1000 <= nums[i] <= 1000
 * -10^7 <= k <= 10^7
 */
public class LC560_Subarray_Sum_Equals_K {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> prefixsum = new HashMap<>();
        prefixsum.put(0, 1); // A prefix sum of 0 has occurred exactly once at the beginning
        
        for (int num : nums) {
            sum += num;
            if (prefixsum.containsKey(sum - k)) {
                count += prefixsum.get(sum - k);
            }
            prefixsum.put(sum, prefixsum.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }

    public static void main(String[] args) {
        LC560_Subarray_Sum_Equals_K solution = new LC560_Subarray_Sum_Equals_K();

        // Test cases
        int[][] testNums = {
            {1, 1, 1},
            {1, 2, 3},
            {1, -1, 0}
        };
        int[] testK = {2, 3, 0};
        int[] expected = {2, 2, 3};

        for (int i = 0; i < testNums.length; i++) {
            System.out.print("Test Case " + (i + 1) + ": ");
            try {
                int result = solution.subarraySum(testNums[i], testK[i]);
                if (result == expected[i]) {
                    System.out.println("PASS");
                } else {
                    System.out.println("FAIL (Expected " + expected[i] + ", Got " + result + ")");
                }
            } catch (UnsupportedOperationException e) {
                System.out.println("SKIPPED - " + e.getMessage());
            } catch (Exception e) {
                System.out.println("FAIL - Exception: " + e.getMessage());
            }
        }
    }
}
