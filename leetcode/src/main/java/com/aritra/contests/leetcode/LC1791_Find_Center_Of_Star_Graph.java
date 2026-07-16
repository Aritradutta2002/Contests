package com.aritra.contests.leetcode;

import java.util.*;

/*
 * 1791. Find Center of Star Graph
 *
 * There is an undirected star graph consisting of n nodes labeled from 1 to n. A star graph is a
 * graph where there is one center node connected to all other nodes. You are given a 2D integer
 * array edges where each edges[i] = [ui, vi]. Return the center of the star graph.
 *
 * Constraints:
 * - 3 <= n <= 10^5
 * - edges.length == n - 1
 * - edges[i].length == 2
 */
public class LC1791_Find_Center_Of_Star_Graph {
    public static int findCenter(int[][] edges) {
        
        int a = edges[0][0];
        int b = edges[0][1];
        int c = edges[1][0];
        int d = edges[1][1];

        if (a == c || a == d) {
            return a;
        } else {
            return b;
        }

    }
}

