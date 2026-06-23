package com.aritra.contests.leetcode;
import java.util.*;

/*
 * 73. Set Matrix Zeroes
 *
 * Given an m x n integer matrix, if an element is 0, set its entire row and column to 0. Do this
 * in-place.
 *
 * Constraints:
 * - 1 <= matrix.length, matrix[0].length <= 200
 * - -2^31 <= matrix[i][j] <= 2^31 - 1
 */
public class LC73_Set_Matrix_Zeroes {
    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] rows = new int[n];
        int[] cols = new int[m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(rows[i] == 1 || cols[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
