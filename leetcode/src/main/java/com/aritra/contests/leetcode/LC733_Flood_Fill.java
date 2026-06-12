package com.aritra.contests.leetcode;
import java.util.*;
/*
 * 733. Flood Fill
 * 
 * An image is represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image.
 * You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].
 * To perform a flood fill:
 * 1. Begin with the starting pixel and change its color to color.
 * 2. Change any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel.
 * 3. Repeat the process for those newly-changed pixels.
 * 
 * Constraints:
 * - m == image.length
 * - n == image[i].length
 * - 1 <= m, n <= 50
 * - 0 <= image[i][j], color < 2^16
 * - 0 <= sr < m
 * - 0 <= sc < n
 */
public class LC733_Flood_Fill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor == color) {
            return image;
        }
        int m = image.length;
        int n = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        image[sr][sc] = color;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == originalColor) {
                    image[nr][nc] = color;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        LC733_Flood_Fill solver = new LC733_Flood_Fill();
        Scanner sc = new Scanner(System.in);

        // Test Case 1
        int[][] image1 = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr1 = 1, sc1 = 1, color1 = 2;
        int[][] expected1 = {{2, 2, 2}, {2, 2, 0}, {2, 0, 1}};
        runTest(solver, 1, image1, sr1, sc1, color1, expected1);

        // Test Case 2
        int[][] image2 = {{0, 0, 0}, {0, 0, 0}};
        int sr2 = 0, sc2 = 0, color2 = 0;
        int[][] expected2 = {{0, 0, 0}, {0, 0, 0}};
        runTest(solver, 2, image2, sr2, sc2, color2, expected2);

        // Test Case 3 (Edge case: starting pixel already has the target color)
        int[][] image3 = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr3 = 1, sc3 = 1, color3 = 1;
        int[][] expected3 = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        runTest(solver, 3, image3, sr3, sc3, color3, expected3);

        sc.close();
    }

    private static void runTest(LC733_Flood_Fill solver, int testId, int[][] image, int sr, int sc, int color, int[][] expected) {
        try {
            int[][] result = solver.floodFill(deepCopy(image), sr, sc, color);
            if (Arrays.deepEquals(result, expected)) {
                System.out.println("Test " + testId + ": PASS");
            } else {
                System.out.println("Test " + testId + ": FAIL");
                System.out.println("  Expected: " + Arrays.deepToString(expected));
                System.out.println("  Actual:   " + Arrays.deepToString(result));
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Test " + testId + ": SKIPPED (Not implemented)");
        } catch (Exception e) {
            System.out.println("Test " + testId + ": ERROR (" + e.getMessage() + ")");
        }
    }

    private static int[][] deepCopy(int[][] original) {
        if (original == null) return null;
        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }
}
