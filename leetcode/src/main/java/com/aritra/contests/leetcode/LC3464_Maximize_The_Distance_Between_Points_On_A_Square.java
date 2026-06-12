package com.aritra.contests.leetcode;
import java.util.Arrays;
/**
 * 3464. Maximize the Distance Between Points on a Square
 *
 * Problem (brief):
 * - You have a square of side length `side` with corners at (0,0), (0,side), (side,0), (side,side).
 * - Points are given as boundary coordinates.
 * - Map each boundary point to a 1D position by walking the perimeter from (0,0) counter‑clockwise.
 * - Perimeter position formula:
 *   - left edge   (x==0)  -> y
 *   - top edge    (y==side) -> side + x
 *   - right edge  (x==side)-> 3*side - y
 *   - bottom edge (y==0)  -> 4*side - x
 *
 * - Choose k points so that the minimum Manhattan distance between any two selected points is maximized.
 * - In the mapped circular order, feasibility for a candidate distance can be checked using perimeter-gap constraints.
 *
 * Solution idea (binary search + greedy on circular array):
 * 1) Convert points to perimeter positions and sort.
 * 2) Duplicate positions by adding perimeter to handle wrap‑around.
 * 3) Pre‑compute next[i] = first index j where doubled[j]-doubled[i] >= mid.
 * 4) Try each original start point, greedily jump k-1 steps and check if the final arc back to start is >= mid.
 * 5) Binary search the largest feasible mid.
 *
 * Complexity: O(n log n + n*k log(side))
 */
public class LC3464_Maximize_The_Distance_Between_Points_On_A_Square {

    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] pos = new long[n];
        long perimeter = 4L * side;

        // Map each point to its 1D perimeter position
        for (int i = 0; i < n; i++) {
            pos[i] = mapToPerimeterPosition(side, points[i][0], points[i][1]);
        }

        Arrays.sort(pos);

        // Duplicate positions shifted by perimeter for circular handling
        long[] d = new long[2 * n];
        for (int i = 0; i < n; i++) {
            d[i] = pos[i];
            d[i + n] = pos[i] + perimeter;
        }

        // Binary search on answer
        long low = 1, high = (4L * side) / k;
        while (low < high) {
            long mid = low + (high - low + 1) / 2;
            if (canSelect(d, n, k, mid, perimeter)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return (int) low;
    }

    private long mapToPerimeterPosition(int side, int x, int y) {
        if (x == 0) return y;                           // left edge
        if (y == side) return (long) side + x;          // top edge
        if (x == side) return 3L * side - y;            // right edge
        return 4L * side - x;                           // bottom edge
    }

    private boolean canSelect(long[] d, int n, int k, long dist, long perimeter) {
        // next[i]: first index j such that d[j] - d[i] >= dist
        int[] next = new int[2 * n];
        int right = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (right <= i) right = i + 1;
            while (right < 2 * n && d[right] - d[i] < dist) right++;
            next[i] = right;
        }

        // Try each original start point
        for (int start = 0; start < n; start++) {
            int cur = start;
            boolean ok = true;
            for (int step = 1; step < k; step++) {
                cur = next[cur];
                if (cur >= start + n) {
                    ok = false;
                    break;
                }
            }
            if (ok && d[cur] - d[start] <= perimeter - dist) {
                return true;
            }
        }
        return false;
    }

    // Simple tests
    public static void main(String[] args) {
        LC3464_Maximize_The_Distance_Between_Points_On_A_Square s = new LC3464_Maximize_The_Distance_Between_Points_On_A_Square();

        run(s, 1, 2, new int[][]{{0,2},{2,0},{2,2},{0,0}}, 4, 2);
        run(s, 2, 2, new int[][]{{0,0},{1,2},{2,0},{2,2},{2,1}}, 4, 1);
        run(s, 3, 2, new int[][]{{0,0},{0,1},{0,2},{1,2},{2,0},{2,2},{2,1}}, 5, 1);
        run(s, 4, 4, new int[][]{{0,0},{0,4},{4,4},{4,0}}, 4, 4);
    }

    private static void run(LC3464_Maximize_The_Distance_Between_Points_On_A_Square s,
                             int id, int side, int[][] points, int k, int expected) {
        int ans = s.maxDistance(side, points, k);
        System.out.println("Test " + id + ": " + (ans == expected ? "PASS" : ("FAIL (got " + ans + ", expected " + expected + ")")));
    }
}
