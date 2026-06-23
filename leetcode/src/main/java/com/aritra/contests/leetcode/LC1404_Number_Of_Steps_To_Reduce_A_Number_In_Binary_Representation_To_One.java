package com.aritra.contests.leetcode;

import java.util.Scanner;

public class LC1404_Number_Of_Steps_To_Reduce_A_Number_In_Binary_Representation_To_One {
    public static int numSteps(String s) {
        int steps = 0;
        int carry = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) - '0' + carry == 1) {
                carry = 1;
                steps += 2;
            } else {
                steps += 1;
            }
        }
        return steps + carry;
    }
}