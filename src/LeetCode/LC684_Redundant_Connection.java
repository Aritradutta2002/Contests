package LeetCode;
import java.util.*;
/*
 * 684. Redundant Connection
 *
 * Description:
 * You are given a tree with n nodes (labeled 1 to n) plus one additional edge.
 * The added edge creates exactly one cycle. Return the edge that can be removed so
 * that the resulting graph is a tree of n nodes. If multiple answers exist, return
 * the one that occurs last in the input.
 *
 * Constraints:
 * - n == edges.length
 * - 3 <= n <= 1000
 * - edges[i].length == 2
 * - 1 <= ai < bi <= edges.length
 * - ai != bi
 * - There are no repeated edges
 * - The graph is connected
 *
 * Example 1:
 * edges = [[1,2],[1,3],[2,3]] -> [2,3]
 * Example 2:
 * edges = [[1,2],[2,3],[3,4],[1,4],[1,5]] -> [1,4]
 * Example 3:
 * edges = [[1,2],[2,3],[3,1]] -> [3,1]
 */
public class LC684_Redundant_Connection {
    public int[] findRedundantConnection(int[][] edges) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public static void main(String[] args) {
        LC684_Redundant_Connection solver = new LC684_Redundant_Connection();

        TestCase[] tests = new TestCase[]{
                new TestCase(new int[][]{{1, 2}, {1, 3}, {2, 3}}, new int[]{2, 3}),
                new TestCase(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}}, new int[]{1, 4}),
                new TestCase(new int[][]{{1, 2}, {2, 3}, {3, 1}}, new int[]{3, 1})
        };

        runAllTests(solver, tests);
    }

    private static void runAllTests(LC684_Redundant_Connection solver, TestCase[] tests) {
        int passed = 0;
        for (int i = 0; i < tests.length; i++) {
            TestCase tc = tests[i];
            try {
                int[] actual = solver.findRedundantConnection(tc.edges);
                boolean ok = Arrays.equals(actual, tc.expected);
                if (ok) {
                    passed++;
                }
                System.out.printf(
                        "Test %d | edges=%s | expected=%s, actual=%s | %s%n",
                        i + 1, Arrays.deepToString(tc.edges), Arrays.toString(tc.expected),
                        Arrays.toString(actual), ok ? "PASS" : "FAIL");
            } catch (UnsupportedOperationException ex) {
                System.out.printf(
                        "Test %d | edges=%s | expected=%s | SKIPPED (%s)%n",
                        i + 1, Arrays.deepToString(tc.edges), Arrays.toString(tc.expected), ex.getMessage());
            }
        }
        System.out.printf("Summary: %d/%d tests passed.%n", passed, tests.length);
    }

    private static class TestCase {
        final int[][] edges;
        final int[] expected;

        TestCase(int[][] edges, int[] expected) {
            this.edges = edges;
            this.expected = expected;
        }
    }
}
