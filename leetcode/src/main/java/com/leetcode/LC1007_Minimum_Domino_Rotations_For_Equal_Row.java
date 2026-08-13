package com.leetcode;

/*
 * 1007. Minimum Domino Rotations For Equal Row
 *
 * In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the i-th domino.
 * Return the minimum number of rotations so that all values in tops or all values in bottoms are the same,
 * or -1 if impossible.
 *
 * Constraints:
 * - 2 <= tops.length <= 2 * 10^4
 * - bottoms.length == tops.length
 * - 1 <= tops[i], bottoms[i] <= 6
 */
public class LC1007_Minimum_Domino_Rotations_For_Equal_Row {
    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int rotations = check(tops[0], tops, bottoms);
        if (rotations != -1 || tops[0] == bottoms[0])
            return rotations;
        return check(bottoms[0], tops, bottoms);
    }
    private static int check(int x, int[] tops, int[] bottoms) {
        int rotationsTop = 0, rotationsBottom = 0;
        int n = tops.length;
        for (int i = 0; i < n; i++) {
            if (tops[i] != x && bottoms[i] != x)
                return -1;
            else {
                if (tops[i] != x)
                    rotationsTop++;
                if (bottoms[i] != x)
                    rotationsBottom++;
            }
        }
        return Math.min(rotationsTop, rotationsBottom);
    }
}
