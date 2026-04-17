package LeetCode;
import java.util.*;
/**
 * Problem: 3488. Closest Equal Element Queries
 * 
 * Description:
 * You are given a circular array nums and an array queries.
 * For each query i, you have to find the minimum distance between the element at index queries[i]
 * and any other index j in the circular array, where nums[j] == nums[queries[i]].
 * If no such index exists, the answer for that query should be -1.
 * 
 * Constraints:
 * - 1 <= queries.length <= nums.length <= 10^5
 * - 1 <= nums[i] <= 10^6
 * - 0 <= queries[i] < nums.length
 * 
 * Input Format:
 * - nums: array of integers
 * - queries: array of indices to query
 * 
 * Output Format:
 * - An array where answer[i] represents the minimum distance for query i
 */

public class LC3488_Closest_Equal_Element_Queries {
    /**
     * Solves the Closest Equal Element Queries problem
     * @param nums the circular array
     * @param queries array of query indices
     * @return array of minimum distances for each query
     */
    public int[] closestEqual(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> positionsByValue = new HashMap<>();
        for (int i = 0; i < n; i++) {
            positionsByValue.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int[] bestAtIndex = new int[n];
        Arrays.fill(bestAtIndex, -1);

        for (List<Integer> positions : positionsByValue.values()) {
            int m = positions.size();
            if (m == 1) {
                continue;
            }

            for (int k = 0; k < m; k++) {
                int cur = positions.get(k);
                int prev = positions.get((k - 1 + m) % m);
                int next = positions.get((k + 1) % m);

                int distPrev = circularDistance(cur, prev, n);
                int distNext = circularDistance(cur, next, n);
                bestAtIndex[cur] = Math.min(distPrev, distNext);
            }
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = bestAtIndex[queries[i]];
        }
        return answer;
    }

    private int circularDistance(int a, int b, int n) {
        int direct = Math.abs(a - b);
        return Math.min(direct, n - direct);
    }
    
    
    public static void main(String[] args) {
        LC3488_Closest_Equal_Element_Queries solution = new LC3488_Closest_Equal_Element_Queries();
        
        // Test Case 1
        int[] nums1 = {1, 3, 1, 4, 1, 3, 2};
        int[] queries1 = {0, 3, 5};
        int[] expected1 = {2, -1, 3};
        testCase(solution, nums1, queries1, expected1, "Test Case 1");
        
        // Test Case 2
        int[] nums2 = {1, 2, 3, 4};
        int[] queries2 = {0, 1, 2, 3};
        int[] expected2 = {-1, -1, -1, -1};
        testCase(solution, nums2, queries2, expected2, "Test Case 2");
        
        // Test Case 3
        int[] nums3 = {5, 5, 5};
        int[] queries3 = {0, 1, 2};
        int[] expected3 = {1, 1, 1};
        testCase(solution, nums3, queries3, expected3, "Test Case 3");
    }
    
    private static void testCase(LC3488_Closest_Equal_Element_Queries solution, 
                                 int[] nums, int[] queries, int[] expected, String testName) {
        try {
            int[] result = solution.closestEqual(nums, queries);
            if (Arrays.equals(result, expected)) {
                System.out.println(testName + ": PASS");
            } else {
                System.out.println(testName + ": FAIL");
                System.out.println("  Expected: " + Arrays.toString(expected));
                System.out.println("  Got:      " + Arrays.toString(result));
            }
        } catch (UnsupportedOperationException e) {
            System.out.println(testName + ": SKIPPED");
        }
    }
}
