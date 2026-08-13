package com.leetcode;
import java.util.*;
/**
 * LeetCode 1914 - Cyclically Rotating a Grid
 * 
 * Problem Description:
 * You are given an m x n integer matrix grid where m and n are both even integers.
 * You must perform an operation which:
 * - Takes every element at grid[i][j] and rotates the element by rotating the
 *   concentric rectangular groups in the matrix, outward from the center.
 * 
 * Key Constraints:
 * - m and n are even integers
 * - Grid dimensions: 2 <= m, n <= 50
 * - grid[i][j] is between 1 and 5000
 * - k is between 1 and 10^9
 * 
 * @author Contest Solutions
 */
public class LC1914_Cyclically_Rotating_a_Grid {

    /**
     * Rotates the grid cyclically k times.
     * 
     * @param grid The input m x n grid to rotate
     * @param k    Number of rotations to perform
     * @return The rotated grid
     */
    public static int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int r1 = 0, c1 = 0, r2 = m - 1, c2 = n - 1;
        while (r1 < r2 && c1 < c2) {
            // Extract the ring elements
            List<Integer> ring = new ArrayList<>();
            for (int i = c1; i <= c2; i++) ring.add(grid[r1][i]);
            for (int i = r1 + 1; i <= r2; i++) ring.add(grid[i][c2]);
            for (int i = c2 - 1; i >= c1; i--) ring.add(grid[r2][i]);
            for (int i = r2 - 1; i > r1; i--) ring.add(grid[i][c1]);

            // Rotate the ring counter-clockwise as required by the problem.
            int rotations = k % ring.size();
            Collections.rotate(ring, -rotations);

            // Put the rotated elements back
            int idx = 0;
            for (int i = c1; i <= c2; i++) grid[r1][i] = ring.get(idx++);
            for (int i = r1 + 1; i <= r2; i++) grid[i][c2] = ring.get(idx++);
            for (int i = c2 - 1; i >= c1; i--) grid[r2][i] = ring.get(idx++);
            for (int i = r2 - 1; i > r1; i--) grid[i][c1] = ring.get(idx++);

            // Move to the next inner ring
            r1++; c1++; r2--; c2--;
        }
        return grid;        
    }

}
