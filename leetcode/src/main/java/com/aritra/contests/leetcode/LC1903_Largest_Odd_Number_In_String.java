package com.aritra.contests.leetcode;
import java.util.*;
/*
 * 1903. Largest Odd Number in String
 *
 * You are given a string num, representing a large integer. Return the largest-valued odd integer
 * that is a substring of num. If no odd integer exists, return an empty string.
 *
 * Constraints:
 * - 1 <= num.length <= 10^5
 * - num consists of digits only and does not contain leading zeros
 */
public class LC1903_Largest_Odd_Number_In_String {
    public static String largeOddNum(String s) {
        String str = "";

        for(int i = 0; i < s.length(); i++) {
            for(int j = s.length(); j >= 0; j--) {
                if(s.charAt(i) == '0') {
                    continue;
                }
                
                str = s.substring(i, j);
                if(Integer.parseInt(str) % 2 != 0) {
                    return str;
                }
            }

        }

        return "";
    }
}
