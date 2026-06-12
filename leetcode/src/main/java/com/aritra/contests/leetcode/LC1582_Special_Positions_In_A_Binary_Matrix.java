package com.aritra.contests.leetcode;
import java.util.*;
/*
 * 1582. Special Positions in a Binary Matrix
 *
 * Given an m x n binary matrix mat, return the number of special positions in mat.
 *
 * A position (i, j) is called special if:
 *   - mat[i][j] == 1
 *   - All other elements in row i are 0
 *   - All other elements in column j are 0
 *
 * Constraints:
 *   - m == mat.length
 *   - n == mat[i].length
 *   - 1 <= m, n <= 100
 *   - mat[i][j] is either 0 or 1
 *
 * Example 1:
 *   Input:  mat = [[1,0,0],[0,0,1],[1,0,0]]
 *   Output: 1
 *
 * Example 2:
 *   Input:  mat = [[1,0,0],[0,1,0],[0,0,1]]
 *   Output: 3
 */

public class LC1582_Special_Positions_In_A_Binary_Matrix {

    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] row = new int[m];
        int [] col = new int[n];

        /* Marking the 1 containing row and columns */
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1){
                    row[i]++;
                    col[j]++;
                }
            }
        }

        /* Now checking more than one 1 have or not */
        int count = 0;
        for(int i = 0;  i <m; i++){
            for(int j = 0; j < n; j++){
                if((row[i] == 1) && (col[j] == 1) && (mat[i][j] == 1)){
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        LC1582_Special_Positions_In_A_Binary_Matrix sol = new LC1582_Special_Positions_In_A_Binary_Matrix();

        int[][][] inputs = {
                { { 1, 0, 0 }, { 0, 0, 1 }, { 1, 0, 0 } },
                { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } },
                { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } },
                { { 1 } },
                { { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 0 } },
        };

        int[] expected = { 1, 3, 0, 1, 2 };

        for (int t = 0; t < inputs.length; t++) {
            try {
                int result = sol.numSpecial(inputs[t]);
                String status = result == expected[t] ? "PASS" : "FAIL";
                System.out.printf("Test %d: %s (expected=%d, got=%d)%n", t + 1, status, expected[t], result);
            } catch (UnsupportedOperationException e) {
                System.out.printf("Test %d: SKIPPED%n", t + 1);
            }
        }
    }
}
