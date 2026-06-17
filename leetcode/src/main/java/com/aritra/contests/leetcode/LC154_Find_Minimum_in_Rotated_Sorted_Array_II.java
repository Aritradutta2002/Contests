package com.aritra.contests.leetcode;

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
    }}
