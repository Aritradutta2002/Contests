package LeetCode;
import java.util.*;
/*
 * LeetCode 3225: Maximum Score From Grid Operations
 *
 * You are given a 2D matrix grid of size n x n. Initially, all cells are white.
 * In one operation, you can select any cell (i, j) and color black all cells of the j-th column
 * from the top row down to the i-th row. The grid score is the sum of all grid[i][j] such that
 * cell (i, j) is white and it has a horizontally adjacent black cell.
 * Return the maximum score that can be achieved after some number of operations.
 *
 * Constraints:
 * - 1 <= n <= 100
 * - n == grid[i].length
 * - 0 <= grid[i][j] <= 10^9
 */
public class LC3225_Maximum_Score_From_Grid_Operations {

    public long maximumScore(int[][] grid) {
        int n = grid.length;
        long[][] prefix = new long[n][n + 1];
        long[] prevPick = new long[n + 1];
        long[] prevSkip = new long[n + 1];

        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                prefix[col][row + 1] = prefix[col][row] + grid[row][col];
            }
        }

        for (int col = 1; col < n; col++) {
            long[] currPick = new long[n + 1];
            long[] currSkip = new long[n + 1];

            for (int curr = 0; curr <= n; curr++) {
                for (int prev = 0; prev <= n; prev++) {
                    if (curr > prev) {
                        long score = prefix[col - 1][curr] - prefix[col - 1][prev];
                        currPick[curr] = Math.max(currPick[curr], prevSkip[prev] + score);
                        currSkip[curr] = Math.max(currSkip[curr], prevSkip[prev] + score);
                    } else {
                        long score = prefix[col][prev] - prefix[col][curr];
                        currPick[curr] = Math.max(currPick[curr], prevPick[prev] + score);
                        currSkip[curr] = Math.max(currSkip[curr], prevPick[prev]);
                    }
                }
            }

            prevPick = currPick;
            prevSkip = currSkip;
        }

        long ans = 0;
        for (long score : prevPick) {
            ans = Math.max(ans, score);
        }
        return ans;
    }

    public static void main(String[] args) {
        LC3225_Maximum_Score_From_Grid_Operations solver = new LC3225_Maximum_Score_From_Grid_Operations();

        int[][] grid1 = {
            {0, 0, 0, 0, 0},
            {0, 0, 3, 0, 0},
            {0, 1, 0, 0, 0},
            {5, 0, 0, 3, 0},
            {0, 0, 0, 0, 2}
        };
        System.out.println("Test 1: " + solver.maximumScore(grid1) + " (expected 11)");

        int[][] grid2 = {
            {10, 9, 0, 0, 15},
            {7, 1, 0, 8, 0},
            {5, 20, 0, 11, 0},
            {0, 0, 0, 1, 2},
            {8, 12, 1, 10, 3}
        };
        System.out.println("Test 2: " + solver.maximumScore(grid2) + " (expected 94)");

        int[][] grid3 = {
            {1, 2},
            {3, 4}
        };
        System.out.println("Test 3: " + solver.maximumScore(grid3) + " (expected 6)");
    }
}
