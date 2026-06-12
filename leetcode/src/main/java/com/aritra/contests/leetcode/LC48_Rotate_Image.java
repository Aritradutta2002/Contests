package com.aritra.contests.leetcode;

import java.util.*;

/**
 * 48. Rotate Image
 *
 * Description:
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 *
 * Constraints:
 * - n == matrix.length == matrix[i].length
 * - 1 <= n <= 20
 * - -1000 <= matrix[i][j] <= 1000
 */
public class LC48_Rotate_Image {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        LC48_Rotate_Image solution = new LC48_Rotate_Image();

        // Test Case 1
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected1 = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        solution.rotate(matrix1);
        System.out.println("Test 1: " + (Arrays.deepEquals(matrix1, expected1) ? "Pass" : "Fail"));

        // Test Case 2
        int[][] matrix2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        int[][] expected2 = {{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}};
        solution.rotate(matrix2);
        System.out.println("Test 2: " + (Arrays.deepEquals(matrix2, expected2) ? "Pass" : "Fail"));

        // Test Case 3
        int[][] matrix3 = {{1}};
        int[][] expected3 = {{1}};
        solution.rotate(matrix3);
        System.out.println("Test 3: " + (Arrays.deepEquals(matrix3, expected3) ? "Pass" : "Fail"));
    }
}
