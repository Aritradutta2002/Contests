package LeetCode;

import java.util.*;

/**
 * LeetCode 154. Find Minimum in Rotated Sorted Array II
 * 
 * Problem: Given a rotated sorted array with possible duplicates, find the minimum element.
 * 
 * Key Constraints:
 * - Array is rotated at some unknown pivot
 * - Array may contain duplicate values
 * - Must handle the case where duplicates cause ambiguity
 * 
 * Time Complexity: O(log n) average, O(n) worst case (due to duplicates)
 * Space Complexity: O(1)
 */

public class LC154_Find_Minimum_in_Rotated_Sorted_Array_II {
    
    /**
     * Find the minimum element in a rotated sorted array with duplicates
     * @param nums rotated sorted array with possible duplicates
     * @return the minimum element in the array
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[right]) {
                // Minimum is in the right half
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                // Minimum is in the left half (including mid)
                right = mid;
            } else {
                // nums[mid] == nums[right], cannot determine which side
                // Shrink from the right to avoid duplicates
                right--;
            }
        }
        
        return nums[left];
    }
    
    public static void main(String[] args) {
        LC154_Find_Minimum_in_Rotated_Sorted_Array_II solution = 
            new LC154_Find_Minimum_in_Rotated_Sorted_Array_II();
        
        // Test case 1: Rotated array without duplicates
        int[] test1 = {3, 4, 5, 1, 2};
        int expected1 = 1;
        int result1 = solution.findMin(test1);
        System.out.println("Test 1: " + (result1 == expected1 ? "Pass" : "Fail") + 
                         " (Expected: " + expected1 + ", Got: " + result1 + ")");
        
        // Test case 2: Array with duplicates at the minimum
        int[] test2 = {3, 1, 1};
        int expected2 = 1;
        int result2 = solution.findMin(test2);
        System.out.println("Test 2: " + (result2 == expected2 ? "Pass" : "Fail") + 
                         " (Expected: " + expected2 + ", Got: " + result2 + ")");
        
        // Test case 3: Array with duplicates throughout
        int[] test3 = {1, 3};
        int expected3 = 1;
        int result3 = solution.findMin(test3);
        System.out.println("Test 3: " + (result3 == expected3 ? "Pass" : "Fail") + 
                         " (Expected: " + expected3 + ", Got: " + result3 + ")");
        
        // Test case 4: Many duplicates
        int[] test4 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1};
        int expected4 = 1;
        int result4 = solution.findMin(test4);
        System.out.println("Test 4: " + (result4 == expected4 ? "Pass" : "Fail") + 
                         " (Expected: " + expected4 + ", Got: " + result4 + ")");
    }
}
