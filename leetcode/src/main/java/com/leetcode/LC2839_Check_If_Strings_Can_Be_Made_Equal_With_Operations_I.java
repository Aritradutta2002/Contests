package com.leetcode;

import java.util.*;

public class LC2839_Check_If_Strings_Can_Be_Made_Equal_With_Operations_I {
    /*
     * Problem: 2839. Check if Strings Can be Made Equal With Operations I
     *
     * Description:
     * You are given two strings s1 and s2 of length 4.
     * In one operation, you can swap characters at indices 0 and 2 in s1,
     * and you can swap characters at indices 1 and 3 in s1.
     * Return true if s1 can be made equal to s2 after any number of operations;
     * otherwise, return false.
     *
     * Constraints:
     * - s1.length == s2.length == 4
     * - s1 and s2 consist only of lowercase English letters.
     */

    public static boolean canBeEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        if(s1.equals(s2)) return true;

        char[] c1 = s2.toCharArray();
        if (s1.equals(swap(c1, 0, 2))) return true;
        char[] c2 = s2.toCharArray();
        if (s1.equals(swap(c2, 1, 3))) return true;
        char[] c3 = s2.toCharArray();
        swap(c3, 0, 2);
        swap(c3, 1, 3);
        if (s1.equals(new String(c3))) return true;

        return false;
    }
    public static String swap(char[] temp, int i, int j) {
        char t = temp[i];
        temp[i] = temp[j];
        temp[j] = t;
        return new String(temp);
    }
}