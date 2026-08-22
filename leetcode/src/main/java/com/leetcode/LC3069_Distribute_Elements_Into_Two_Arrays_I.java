package com.leetcode;
import java.util.ArrayList;
import java.util.List;
/**
 * 3069. Distribute Elements Into Two Arrays I
 *
 * You are given a 1-indexed array of distinct integers nums of length n.
 * 
 * You need to distribute all the elements of nums between two arrays arr1 and arr2 using n operations. In the first operation, append nums[1] to arr1. In the second operation, append nums[2] to arr2. Afterwards, in the ith operation:
 * 
 * 	
 *  - If the last element of arr1 is greater than the last element of arr2, append nums[i] to arr1. Otherwise, append nums[i] to arr2.
 * 
 * The array result is formed by concatenating the arrays arr1 and arr2. For example, if arr1 == [1,2,3] and arr2 == [4,5,6], then result = [1,2,3,4,5,6].
 * 
 * Return the array result.
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: nums = [2,1,3]
 * Output: [2,3,1]
 * Explanation: After the first 2 operations, arr1 = [2] and arr2 = [1].
 * In the 3rd operation, as the last element of arr1 is greater than the last element of arr2 (2 > 1), append nums[3] to arr1.
 * After 3 operations, arr1 = [2,3] and arr2 = [1].
 * ...
 */
public class LC3069_Distribute_Elements_Into_Two_Arrays_I {
    public int[] resultArray(int[] nums) {
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        first.add(nums[0]);
        second.add(nums[1]);
        for (int index = 2; index < nums.length; index++) {
            List<Integer> target = first.get(first.size() - 1) > second.get(second.size() - 1)
                    ? first : second;
            target.add(nums[index]);
        }
        int[] result = new int[nums.length];
        int resultIndex = 0;
        for (int value : first) result[resultIndex++] = value;
        for (int value : second) result[resultIndex++] = value;
        return result;
    }
}