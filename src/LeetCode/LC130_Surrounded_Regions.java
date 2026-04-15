package LeetCode;
import java.util.*;
/*
 * 130. Surrounded Regions
 *
 * Description:
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are
 * 4-directionally surrounded by 'X'. A region is captured by flipping all surrounded
 * 'O' cells into 'X'.
 *
 * Constraints:
 * - m == board.length
 * - n == board[i].length
 * - 1 <= m, n <= 200
 * - board[i][j] is 'X' or 'O'
 *
 * Example 1:
 * board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * -> [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * Example 2:
 * board = [["X"]] -> [["X"]]
 * Example 3:
 * board = [["O"]] -> [["O"]]
 */
public class LC130_Surrounded_Regions {
    public void solve(char[][] board) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    private static char[][] copyBoard(char[][] board) {
        char[][] out = new char[board.length][];
        for (int i = 0; i < board.length; i++) {
            out[i] = Arrays.copyOf(board[i], board[i].length);
        }
        return out;
    }

    public static void main(String[] args) {
        LC130_Surrounded_Regions solver = new LC130_Surrounded_Regions();

        TestCase[] tests = new TestCase[]{
                new TestCase(
                        new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}},
                        new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'O', 'X', 'X'}}),
                new TestCase(new char[][]{{'X'}}, new char[][]{{'X'}}),
                new TestCase(new char[][]{{'O'}}, new char[][]{{'O'}})
        };

        runAllTests(solver, tests);
    }

    private static void runAllTests(LC130_Surrounded_Regions solver, TestCase[] tests) {
        int passed = 0;
        for (int i = 0; i < tests.length; i++) {
            TestCase tc = tests[i];
            char[][] input = copyBoard(tc.board);
            try {
                solver.solve(input);
                boolean ok = Arrays.deepEquals(input, tc.expected);
                if (ok) {
                    passed++;
                }
                System.out.printf(
                        "Test %d | board=%s | expected=%s, actual=%s | %s%n",
                        i + 1, Arrays.deepToString(tc.board), Arrays.deepToString(tc.expected),
                        Arrays.deepToString(input), ok ? "PASS" : "FAIL");
            } catch (UnsupportedOperationException ex) {
                System.out.printf(
                        "Test %d | board=%s | expected=%s | SKIPPED (%s)%n",
                        i + 1, Arrays.deepToString(tc.board), Arrays.deepToString(tc.expected), ex.getMessage());
            }
        }
        System.out.printf("Summary: %d/%d tests passed.%n", passed, tests.length);
    }

    private static class TestCase {
        final char[][] board;
        final char[][] expected;

        TestCase(char[][] board, char[][] expected) {
            this.board = board;
            this.expected = expected;
        }
    }
}
