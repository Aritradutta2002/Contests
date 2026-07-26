package com.aritra.contests.leetcode;
import java.util.ArrayList;
import java.util.List;
/**
 * 1260. Shift 2D Grid
 *
 * Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.
 *
 * In one shift operation:
 * - Element at grid[i][j] moves to grid[i][j + 1].
 * - Element at grid[i][n - 1] moves to grid[i + 1][0].
 * - Element at grid[m - 1][n - 1] moves to grid[0][0].
 *
 * Return the 2D grid after applying the shift operation k times.
 *
 * Constraints:
 * - m == grid.length
 * - n == grid[i].length
 * - 1 <= m <= 50
 * - 1 <= n <= 50
 * - -1000 <= grid[i][j] <= 1000
 * - 0 <= k <= 100
 */
public class LC1260_Shift_2D_Grid {
    /**
     * Shifts the 2D grid k times.
     *
     * @param grid the input 2D grid
     * @param k the number of shift operations
     * @return the shifted 2D grid
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int totalElements = rows * cols;
        k %= totalElements;
        if (k < 0) {
            k += totalElements;
        }

        List<Integer> flat = new ArrayList<>(totalElements);
        for (int[] row : grid) {
            for (int value : row) {
                flat.add(value);
            }
        }

        List<Integer> shifted = new ArrayList<>(totalElements);
        for (int i = 0; i < totalElements; i++) {
            shifted.add(flat.get((i - k + totalElements) % totalElements));
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<>(cols);
            for (int j = 0; j < cols; j++) {
                row.add(shifted.get(i * cols + j));
            }
            result.add(row);
        }
        return result;
    }
}
