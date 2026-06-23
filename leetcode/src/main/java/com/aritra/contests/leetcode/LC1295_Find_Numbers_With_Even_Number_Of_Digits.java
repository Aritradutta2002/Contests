package com.aritra.contests.leetcode;
import java.util.*;
/*
 * 1295. Find Numbers with Even Number of Digits
 *
 * Given an array nums of integers, return how many of them contain an even number of digits.
 *
 * Constraints:
 * - 1 <= nums.length <= 500
 * - 1 <= nums[i] <= 10^5
 */
public class LC1295_Find_Numbers_With_Even_Number_Of_Digits {
    public static int findNumbers(int[] nums) {
        int count = 0;
        for(int i : nums){
            int len = (int) Math.log10(i) + 1;
            if(len % 2 == 0){
                count++;
            }
        }
        return count;
    }
}

