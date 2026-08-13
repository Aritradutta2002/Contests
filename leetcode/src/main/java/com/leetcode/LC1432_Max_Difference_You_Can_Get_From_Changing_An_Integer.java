package com.leetcode;

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

/*
 *   Author : Aritra
 *   Created On: Sunday,15.06.2025 10:45 am
 */
public class LC1432_Max_Difference_You_Can_Get_From_Changing_An_Integer {
    public static int maxDiff(int num) {
            int minNum = num;
            int maxNum = num;
            for (int x = 0; x < 10; ++x) {
                for (int y = 0; y < 10; ++y) {
                    String rest = change(num, x, y);
                    if (rest.charAt(0) != '0') {
                        int resi = Integer.parseInt(rest);
                        minNum = Math.min(minNum, resi);
                        maxNum = Math.max(maxNum, resi);
                    }
                }
            }

            return maxNum - minNum;
        }
    public static String change(int num, int x, int y) {
            StringBuilder nums = new StringBuilder(String.valueOf(num));
            int length = nums.length();
            for (int i = 0; i < length; i++) {
                char digit = nums.charAt(i);
                if (digit - '0' == x) {
                    nums.setCharAt(i, (char) ('0' + y));
                }
            }
            return nums.toString();
        }
}

