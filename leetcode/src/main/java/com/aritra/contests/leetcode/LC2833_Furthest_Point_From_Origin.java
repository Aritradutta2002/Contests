package com.aritra.contests.leetcode;

import java.util.*;

/*
 * LeetCode 2833 - Furthest Point From Origin
 *
 * Description:
 * Given a string moves containing 'L', 'R', and '_', start from position 0.
 * Replace each '_' with either 'L' or 'R' to maximize the distance from origin
 * after processing all moves.
 *
 * Key Constraints:
 * 1 <= moves.length <= 50
 * moves[i] is one of 'L', 'R', '_'
 */
public class LC2833_Furthest_Point_From_Origin {
    public int furthestDistanceFromOrigin(String moves) {
        int l = 0;
        int r = 0;
        int t = 0;
        for (char c : moves.toCharArray()) {
            if(c == 'L') l++;
            if(c == 'R') r++;
            if(c == '_') t++;
        }
        return Math.abs(l-r)+t;
    }}
