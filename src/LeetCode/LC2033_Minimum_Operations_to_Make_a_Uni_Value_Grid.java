package LeetCode;
import java.util.*;
/*
 * 2033. Minimum Operations to Make a Uni-Value Grid
 *
 * Problem:
 *   You are given a 2D integer grid of size m x n and an integer x.
 *   In one operation, you can add x to or subtract x from any element in the grid.
 *   Return the minimum number of operations to make the grid uni-value.
 *   If it is not possible, return -1.
 *
 * Key Constraints:
 *   - m == grid.length, n == grid[i].length
 *   - 1 <= m, n <= 10^5
 *   - 1 <= m * n <= 10^5
 *   - 1 <= x, grid[i][j] <= 10^4
 */

public class LC2033_Minimum_Operations_to_Make_a_Uni_Value_Grid {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        int[] arr = new int[total];
        int idx = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[idx++] = grid[i][j];
            }
        }

        int mod = arr[0] % x;
        for (int val : arr) {
            if (val % x != mod) {
                return -1;
            }
        }

        Arrays.sort(arr);
        int median = arr[total / 2];
        long ops = 0;
        for (int val : arr) {
            ops += Math.abs(val - median) / x;
        }

        return (int) ops;
    }

    public static void main(String[] args) {
        LC2033_Minimum_Operations_to_Make_a_Uni_Value_Grid solver = new LC2033_Minimum_Operations_to_Make_a_Uni_Value_Grid();

        int[][][] grids = {
            {{2, 4}, {6, 8}},
            {{1, 5}, {2, 3}},
            {{1, 2}, {3, 4}}
        };
        int[] xs = {2, 1, 2};
        int[] expected = {4, 5, -1};

        int passed = 0;
        for (int i = 0; i < grids.length; i++) {
            int actual = solver.minOperations(grids[i], xs[i]);
            boolean ok = actual == expected[i];
            if (ok) passed++;
            System.out.println(
                "Test " + (i + 1) + " -> expected=" + expected[i]
                + ", actual=" + actual
                + " | " + (ok ? "PASS" : "FAIL")
            );
        }

        System.out.println("\nSummary: " + passed + "/" + grids.length + " tests passed.");
    }
}
