package LeetCode;

import java.util.*;

/**
 * LeetCode 1306. Jump Game III
 * 
 * Problem: Given an array of non-negative integers, you are initially positioned at the start index.
 * When you are at index i, you can jump to i + arr[i] or i - arr[i].
 * Check if you can reach any index with value 0.
 * 
 * Key Constraints:
 * - From index i, you can jump to: i + arr[i] or i - arr[i]
 * - Goal: reach any index where arr[j] == 0
 * - Cannot jump outside the array bounds
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class LC1306_Jump_Game_III {
    
    /**
     * Determine if we can reach any index with value 0
     * @param arr array of non-negative integers
     * @param start starting index for jumping
     * @return true if any index with value 0 is reachable, false otherwise
     */
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int index = queue.poll();
            
            // Check if current index has value 0
            if (arr[index] == 0) {
                return true;
            }
            
            // Jump forward by arr[index]
            int nextIdx = index + arr[index];
            if (nextIdx < arr.length && !visited[nextIdx]) {
                visited[nextIdx] = true;
                queue.offer(nextIdx);
            }
            
            // Jump backward by arr[index]
            int prevIdx = index - arr[index];
            if (prevIdx >= 0 && !visited[prevIdx]) {
                visited[prevIdx] = true;
                queue.offer(prevIdx);
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        LC1306_Jump_Game_III solution = new LC1306_Jump_Game_III();
        
        // Test case 1: Can reach index 3 which has value 0
        int[] test1 = {4, 2, 3, 0, 3, 1, 2};
        int start1 = 5;
        boolean expected1 = true;
        boolean result1 = solution.canReach(test1, start1);
        System.out.println("Test 1: " + (result1 == expected1 ? "Pass" : "Fail") + 
                         " (Expected: " + expected1 + ", Got: " + result1 + ")");
        
        // Test case 2: Can reach index with value 0
        int[] test2 = {3, 2, 1, 0, 4};
        int start2 = 0;
        boolean expected2 = true;
        boolean result2 = solution.canReach(test2, start2);
        System.out.println("Test 2: " + (result2 == expected2 ? "Pass" : "Fail") + 
                         " (Expected: " + expected2 + ", Got: " + result2 + ")");
        
        // Test case 3: Already at index with value 0
        int[] test3 = {0};
        int start3 = 0;
        boolean expected3 = true;
        boolean result3 = solution.canReach(test3, start3);
        System.out.println("Test 3: " + (result3 == expected3 ? "Pass" : "Fail") + 
                         " (Expected: " + expected3 + ", Got: " + result3 + ")");
        
        // Test case 4: Cannot reach any index with value 0
        int[] test4 = {2, 0, 6, 9, 8, 4};
        int start4 = 0;
        boolean expected4 = false;
        boolean result4 = solution.canReach(test4, start4);
        System.out.println("Test 4: " + (result4 == expected4 ? "Pass" : "Fail") + 
                         " (Expected: " + expected4 + ", Got: " + result4 + ")");
    }
}
