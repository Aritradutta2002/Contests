package LeetCode;
import java.util.*;
/*
 * 286. Walls and Gates
 *
 * Description:
 * You are given an m x n grid rooms initialized with:
 * -1 for a wall or obstacle, 0 for a gate, and INF for an empty room.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to
 * reach a gate, it should be filled with INF.
 *
 * Constraints:
 * - 1 <= m, n <= 250
 * - rooms[i][j] is -1, 0, or 2^31 - 1
 *
 * Example 1:
 * rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
 * -> [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
 * Example 2:
 * rooms = [[-1]] -> [[-1]]
 * Example 3:
 * rooms = [[0]] -> [[0]]
 */
public class LC286_Walls_And_Gates {
    public void wallsAndGates(int[][] rooms) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    private static int[][] copyGrid(int[][] g) {
        int[][] out = new int[g.length][];
        for (int i = 0; i < g.length; i++) {
            out[i] = Arrays.copyOf(g[i], g[i].length);
        }
        return out;
    }

    public static void main(String[] args) {
        LC286_Walls_And_Gates solver = new LC286_Walls_And_Gates();
        final int INF = 2147483647;

        TestCase[] tests = new TestCase[]{
                new TestCase(
                        new int[][]{{INF, -1, 0, INF}, {INF, INF, INF, -1}, {INF, -1, INF, -1}, {0, -1, INF, INF}},
                        new int[][]{{3, -1, 0, 1}, {2, 2, 1, -1}, {1, -1, 2, -1}, {0, -1, 3, 4}}),
                new TestCase(new int[][]{{-1}}, new int[][]{{-1}}),
                new TestCase(new int[][]{{0}}, new int[][]{{0}})
        };

        runAllTests(solver, tests);
    }

    private static void runAllTests(LC286_Walls_And_Gates solver, TestCase[] tests) {
        int passed = 0;
        for (int i = 0; i < tests.length; i++) {
            TestCase tc = tests[i];
            int[][] input = copyGrid(tc.rooms);
            try {
                solver.wallsAndGates(input);
                boolean ok = Arrays.deepEquals(input, tc.expected);
                if (ok) {
                    passed++;
                }
                System.out.printf(
                        "Test %d | rooms=%s | expected=%s, actual=%s | %s%n",
                        i + 1, Arrays.deepToString(tc.rooms), Arrays.deepToString(tc.expected),
                        Arrays.deepToString(input), ok ? "PASS" : "FAIL");
            } catch (UnsupportedOperationException ex) {
                System.out.printf(
                        "Test %d | rooms=%s | expected=%s | SKIPPED (%s)%n",
                        i + 1, Arrays.deepToString(tc.rooms), Arrays.deepToString(tc.expected), ex.getMessage());
            }
        }
        System.out.printf("Summary: %d/%d tests passed.%n", passed, tests.length);
    }

    private static class TestCase {
        final int[][] rooms;
        final int[][] expected;

        TestCase(int[][] rooms, int[][] expected) {
            this.rooms = rooms;
            this.expected = expected;
        }
    }
}
