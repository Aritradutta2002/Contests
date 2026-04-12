package LeetCode;
import java.util.*;
/*
 * 3212. Count Submatrices With Equal Frequency of X and Y
 *
 * Description:
 * Given a 2D character matrix grid where each cell is 'X', 'Y', or '.',
 * return the number of submatrices that:
 * 1) include grid[0][0],
 * 2) contain an equal frequency of 'X' and 'Y', and
 * 3) contain at least one 'X'.
 *
 * Constraints:
 * 1 <= grid.length, grid[i].length <= 1000
 * grid[i][j] is either 'X', 'Y', or '.'.
 *
 * Input format (method):
 * char[][] grid
 *
 * Output format (method):
 * int count of valid submatrices
 */
public class LC3212_Count_Submatrices_With_Equal_Frequency_of_X_and_Y {

    public static int numberOfSubmatrices(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][][] pref = prefixCount(grid);
        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pref[r][c][0] > 0 && pref[r][c][0] == pref[r][c][1]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isSameFreq(int i, int j, char[][] grid){
        int[][][] pref = prefixCount(grid);
        int x = pref[i][j][0];
        int y = pref[i][j][1];
        return x > 0 && x == y;
    }

    // pref[i][j][0] = X count in (0,0) to (i,j), pref[i][j][1] = Y count in (0,0) to (i,j)
    public static int[][][] prefixCount(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][][] pref = new int[rows][cols][2];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int xHere = grid[i][j] == 'X' ? 1 : 0;
                int yHere = grid[i][j] == 'Y' ? 1 : 0;

                int topX = i > 0 ? pref[i - 1][j][0] : 0;
                int leftX = j > 0 ? pref[i][j - 1][0] : 0;
                int diagX = (i > 0 && j > 0) ? pref[i - 1][j - 1][0] : 0;

                int topY = i > 0 ? pref[i - 1][j][1] : 0;
                int leftY = j > 0 ? pref[i][j - 1][1] : 0;
                int diagY = (i > 0 && j > 0) ? pref[i - 1][j - 1][1] : 0;

                pref[i][j][0] = xHere + topX + leftX - diagX;
                pref[i][j][1] = yHere + topY + leftY - diagY;
            }
        }

        return pref;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();

        runTest(
            "Example 1",
            new char[][] {
                {'X', 'Y', '.'},
                {'Y', '.', '.'}
            },
            3
        );

        runTest(
            "Example 2",
            new char[][] {
                {'X', 'X'},
                {'X', 'Y'}
            },
            0
        );

        runTest(
            "Example 3",
            new char[][] {
                {'.', '.'},
                {'.', '.'}
            },
            0
        );
    }

    private static void runTest(String testName, char[][] grid, int expected) {
        try {
            int actual = numberOfSubmatrices(grid);
            if (actual == expected) {
                System.out.println(testName + ": PASS (expected=" + expected + ", actual=" + actual + ")");
            } else {
                System.out.println(testName + ": FAIL (expected=" + expected + ", actual=" + actual + ")");
            }
        } catch (UnsupportedOperationException ex) {
            System.out.println(testName + ": SKIPPED (Not implemented yet.)");
        }
    }
}
