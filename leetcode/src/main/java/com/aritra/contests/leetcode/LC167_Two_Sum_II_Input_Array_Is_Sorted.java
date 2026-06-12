package com.aritra.contests.leetcode;
import java.util.*;
/**
 * Two Sum II - Input Array Is Sorted
 * 
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 * 
 * Return the indices of the two numbers (1-indexed) as an integer array [index1, index2] of length 2.
 * 
 * Constraints:
 * - 2 <= numbers.length <= 3 * 10^4
 * - -1000 <= numbers[i] <= 1000
 * - numbers is sorted in non-decreasing order.
 * - -1000 <= target <= 1000
 * - The tests are generated such that there is exactly one solution.
 * 
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2.
 */
class LC167_Two_Sum_II_Input_Array_Is_Sorted {
    
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = numbers.length;
        int start = -1;
        int end = -1;
        for(int i = 0; i < n; i++){
            int remaining = target - numbers[i];
            if(map.containsKey(numbers[i])){
                start = map.get(numbers[i])+1;
                end = i + 1;
                return new int[]{start, end};
            }
            map.put(remaining, i);
        }
        return new int[]{start, end};
    }
    
    public static void main(String[] args) {
        LC167_Two_Sum_II_Input_Array_Is_Sorted solution = new LC167_Two_Sum_II_Input_Array_Is_Sorted();
        
        try {
            int[] numbers1 = {2, 7, 11, 15};
            int target1 = 9;
            int[] expected1 = {1, 2};
            int[] result1 = solution.twoSum(numbers1, target1);
            if (arraysEqual(result1, expected1)) {
                System.out.println("Test 1: PASS");
            } else {
                System.out.println("Test 1: FAIL");
                System.out.println("  Expected: " + java.util.Arrays.toString(expected1));
                System.out.println("  Got:      " + java.util.Arrays.toString(result1));
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Test 1: SKIPPED");
        }
        
        try {
            int[] numbers2 = {2, 3, 4};
            int target2 = 6;
            int[] expected2 = {1, 3};
            int[] result2 = solution.twoSum(numbers2, target2);
            if (arraysEqual(result2, expected2)) {
                System.out.println("Test 2: PASS");
            } else {
                System.out.println("Test 2: FAIL");
                System.out.println("  Expected: " + java.util.Arrays.toString(expected2));
                System.out.println("  Got:      " + java.util.Arrays.toString(result2));
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Test 2: SKIPPED");
        }
        
        try {
            int[] numbers3 = {-1, 0};
            int target3 = -1;
            int[] expected3 = {1, 2};
            int[] result3 = solution.twoSum(numbers3, target3);
            if (arraysEqual(result3, expected3)) {
                System.out.println("Test 3: PASS");
            } else {
                System.out.println("Test 3: FAIL");
                System.out.println("  Expected: " + java.util.Arrays.toString(expected3));
                System.out.println("  Got:      " + java.util.Arrays.toString(result3));
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Test 3: SKIPPED");
        }
    }
    
    
    private static boolean arraysEqual(int[] a, int[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

}