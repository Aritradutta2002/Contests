package com.leetcode;
/**
 * 2091. Removing Minimum and Maximum From Array
 *
 * You are given a 0-indexed array of distinct integers nums.
 * 
 * There is an element in nums that has the lowest value and an element that has the highest value. We call them the minimum and maximum respectively. Your goal is to remove both these elements from the array.
 * 
 * A deletion is defined as either removing an element from the front of the array or removing an element from the back of the array.
 * 
 * Return the minimum number of deletions it would take to remove both the minimum and maximum element from the array.
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: nums = [2,10,7,5,4,1,8,6]
 * Output: 5
 * Explanation: 
 * The minimum element in the array is nums[5], which is 1.
 * The maximum element in the array is nums[1], which is 10.
 * We can remove both the minimum and maximum by removing 2 elements from the front and 3 elements from the back.
 * This results in 2 + 3 = 5 deletions, which is the minimum number possible.
 * 
 * ...
 */
public class LC2091_Removing_Minimum_and_Maximum_From_Array {
    public int minimumDeletions(int[] nums) { 
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        int minIdx = -1;
        int maxIdx = -1;

        for(int i = 0; i < n; i++){
            if(nums[i] >= max){
                max = nums[i];
                maxIdx = i;
            }

            if(nums[i] <= min){
                min = nums[i];
                minIdx = i;
            }
        }

        // total possible ways i) both front side ii) both back side iii) min from front + max from back iv) max from front and min from back 

        int firstOption = Math.max(minIdx + 1, maxIdx + 1);
        int secondOption = n - Math.min(minIdx, maxIdx);
        int thirdOption = (minIdx + 1) + (n - maxIdx);
        int fourthOption = (maxIdx + 1) + (n - minIdx);

        return Math.min(Math.min(firstOption, secondOption), Math.min(thirdOption, fourthOption));
    }
}