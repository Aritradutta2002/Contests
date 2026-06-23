package com.aritra.contests.leetcode;

import java.util.Scanner;

/*
 *   Author : Aritra
 *   Created On: Saturday,14.06.2025 07:45 pm
 */
public class LC2566_Maximum_Difference_By_Remapping_A_Digit {
    public static int minMaxDifference(int num) {
        String s = Integer.toString(num);
        String t = s;
        int pos = 0;
        while (pos < s.length() && s.charAt(pos) == '9') {
            pos++;
        }
        if (pos < s.length()) {
            s = s.replace(s.charAt(pos), '9');
        }
        t = t.replace(t.charAt(0), '0');
        return Integer.parseInt(s) - Integer.parseInt(t);
    }
}

