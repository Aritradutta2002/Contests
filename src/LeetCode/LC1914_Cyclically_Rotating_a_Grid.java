package LeetCode;
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

    public static void main(String[] args) {
        // Test case 1: official example 1
        int[][] grid1 = {{40, 10}, {30, 20}};
        int k1 = 1;
        int[][] result1 = rotateGrid(grid1, k1);
        int[][] expected1 = {{10, 20}, {40, 30}};
        System.out.println("Test 1: " + (Arrays.deepEquals(result1, expected1) ? "Pass" : "Fail"));

        // Test case 2: official example 2
        int[][] grid2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int k2 = 2;
        int[][] result2 = rotateGrid(grid2, k2);
        int[][] expected2 = {{3, 4, 8, 12}, {2, 11, 10, 16}, {1, 7, 6, 15}, {5, 9, 13, 14}};
        System.out.println("Test 2: " + (Arrays.deepEquals(result2, expected2) ? "Pass" : "Fail"));

        // Test case 3: larger k that wraps around the ring length
        int[][] grid3 = {{1, 2}, {3, 4}};
        int k3 = 5;
        int[][] result3 = rotateGrid(grid3, k3);
        int[][] expected3 = {{2, 4}, {1, 3}};
        System.out.println("Test 3: " + (Arrays.deepEquals(result3, expected3) ? "Pass" : "Fail"));
    }

}
