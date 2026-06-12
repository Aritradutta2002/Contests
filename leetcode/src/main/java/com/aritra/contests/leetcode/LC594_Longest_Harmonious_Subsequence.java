package com.aritra.contests.leetcode;

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

/*
 *   Author : Aritra
 *   Created On: Monday,30.06.2025 08:55 pm
 */
public class LC594_Longest_Harmonious_Subsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = findLHS(nums);
        System.out.println(result);
    }
    public static int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int maxLength = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            if(map.containsKey(key + 1)) {
                maxLength = Math.max(maxLength, entry.getValue() + map.get(key + 1));
            }
        }

        return maxLength;
    }
}

