package com.aritra.contests.leetcode;

import java.util.*;

/*
 *   Author : Aritra
 *   Created On: Sunday,29.06.2025 02:40 pm
 */
public class LC01_Two_Sum {
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }

        return new int[] { -1, -1 };
    }
}
