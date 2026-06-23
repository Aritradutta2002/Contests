package com.aritra.contests.leetcode;

import java.util.*;

public class LC1128_Number_Of_Equivalent_Domino_Pairs {
    public static int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100];
        int result = 0;

        for (int[] d : dominoes) {
            int a = d[0], b = d[1];
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            int num = a * 10 + b;
            result += count[num];
            count[num]++;
        }

        return result;

    }
}

