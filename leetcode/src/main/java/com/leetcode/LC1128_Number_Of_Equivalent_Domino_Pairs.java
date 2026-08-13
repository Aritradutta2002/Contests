package com.leetcode;

import java.util.*;

/*
 * 1128. Number of Equivalent Domino Pairs
 *
 * Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if either
 * (a == c and b == d) or (a == d and b == c). Return the number of pairs (i, j) where i < j and
 * dominoes[i] is equivalent to dominoes[j].
 *
 * Constraints:
 * - 1 <= dominoes.length <= 4 * 10^4
 * - dominoes[i].length == 2
 * - 1 <= dominoes[i][j] <= 9
 */
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

