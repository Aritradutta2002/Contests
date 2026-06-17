package com.aritra.contests.leetcode;

import java.util.*;

/*
 * 2553. Separate the Digits in an Array
 * Given an array of integers, return a new array containing all digits of the
 * numbers in order.
 * Constraints: 1 <= nums.length <= 1000, 1 <= nums[i] <= 100000.
 */
public class LC2553_Separate_The_Digits_In_An_Array {
    public static int[] separateDigits(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (int i : nums) {
            ans.addAll(addToArray(i));
        }
        int[] arr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            arr[i] = ans.get(i);
        }
        return arr;
    }
    public static List<Integer> addToArray(int num) {
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            int digit = num % 10;
            list.add(digit);
            num /= 10;
        }
        Collections.reverse(list);
        return list;
    }
    static void runTest(int[] nums, int[] expected, String description) {
        try {
            int[] actual = separateDigits(nums);
            boolean pass = Arrays.deepEquals(new Object[] { box(actual) }, new Object[] { box(expected) });
            System.out.println((pass ? "Pass" : "Fail") + " - " + description);
        } catch (UnsupportedOperationException ex) {
            System.out.println("Fail - " + description);
        }
    }
    static Integer[] box(int[] values) {
        Integer[] boxed = new Integer[values.length];
        for (int i = 0; i < values.length; i++) {
            boxed[i] = values[i];
        }
        return boxed;
    }
}