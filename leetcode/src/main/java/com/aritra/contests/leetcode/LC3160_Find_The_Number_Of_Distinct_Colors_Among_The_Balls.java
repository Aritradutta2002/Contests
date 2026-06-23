package com.aritra.contests.leetcode;
import java.util.*;
@SuppressWarnings("unused")

/*
 * 3160. Find the Number of Distinct Colors Among the Balls
 *
 * You are given an integer limit and a 2D array queries. Initially, there are limit balls labeled
 * 1..limit with no color. For each query (ball, color), assign that color to the ball. After each
 * query, return the number of distinct colors among all balls.
 *
 * Constraints:
 * - 1 <= limit <= 10^9
 * - 1 <= queries.length <= 10^5
 * - queries[i].length == 2
 * - 0 <= ball <= limit
 * - 1 <= color <= 10^9
 */
public class LC3160_Find_The_Number_Of_Distinct_Colors_Among_The_Balls {
    static public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;

        HashMap<Integer, Integer> ballColor = new HashMap<>(); // Color of each ball
        HashMap<Integer, Integer> colorFrequency = new HashMap<>(); // Frequency of each color
        Set<Integer> distinctColors = new HashSet<>(); // Set to keep track of distinct colors

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballColor.containsKey(ball)) {
                int prevColor = ballColor.get(ball);
                colorFrequency.put(prevColor, colorFrequency.get(prevColor) - 1);
                if (colorFrequency.get(prevColor) == 0) {
                    distinctColors.remove(prevColor);
                }
            }

            ballColor.put(ball, color);
            colorFrequency.put(color, colorFrequency.getOrDefault(color, 0) + 1);
            distinctColors.add(color);

            result[i] = distinctColors.size();
        }

        return result;
    }

}
