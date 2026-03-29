package LeetCode;
import java.util.*;
/*
 * 2946. Matrix Similarity After Cyclic Shifts
 * 
 * You are given a 0-indexed m x n integer matrix mat and an integer k.
 * You have to cyclically right shift odd indexed rows k times and cyclically
 * left shift even indexed rows k times.
 * Return true if the initial and final matrix are exactly the same and false otherwise.
 * 
 * Constraints:
 * - 1 <= mat.length <= 25
 * - 1 <= mat[i].length <= 25
 * - 1 <= mat[i][j] <= 25
 * - 1 <= k <= 50
 */
public class LC2946_Matrix_Similarity_After_Cyclic_Shifts {
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        k = k % m;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][(j + k) % m] != mat[i][j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC2946_Matrix_Similarity_After_Cyclic_Shifts solver = new LC2946_Matrix_Similarity_After_Cyclic_Shifts();
        Scanner sc = new Scanner(System.in);

        // Test Case 1
        int[][] mat1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        runTest(solver, 1, mat1, 4, false);

        // Test Case 2
        int[][] mat2 = {{1, 2, 1, 2}, {5, 5, 5, 5}, {6, 3, 6, 3}};
        runTest(solver, 2, mat2, 2, true);

        // Test Case 3
        int[][] mat3 = {{2, 2}, {2, 2}};
        runTest(solver, 3, mat3, 3, true);

        sc.close();
    }

    private static void runTest(LC2946_Matrix_Similarity_After_Cyclic_Shifts solver, int testId, int[][] mat, int k, boolean expected) {
        try {
            boolean result = solver.areSimilar(mat, k);
            if (result == expected) {
                System.out.println("Test " + testId + ": PASS");
            } else {
                System.out.println("Test " + testId + ": FAIL");
                System.out.println("  Expected: " + expected);
                System.out.println("  Actual:   " + result);
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Test " + testId + ": SKIPPED (Not implemented)");
        } catch (Exception e) {
            System.out.println("Test " + testId + ": ERROR (" + e.getMessage() + ")");
        }
    }
}
