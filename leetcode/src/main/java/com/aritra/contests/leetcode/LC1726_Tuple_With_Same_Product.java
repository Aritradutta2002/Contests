package com.aritra.contests.leetcode;

import java.util.Scanner;

public class LC1726_Tuple_With_Same_Product {
    static public int tupleSameProduct(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] * nums[j] == nums[j + 1] * nums[i + 1]) {
                    count++;
                }
            }
        }
        return count;
    }
}
