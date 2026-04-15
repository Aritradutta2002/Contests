package LeetCode;
import java.util.*;
/*
 * 323. Number of Connected Components in an Undirected Graph
 *
 * Description:
 * You have a graph of n nodes labeled from 0 to n - 1 and an edge list where each
 * edge connects two nodes. Return the number of connected components in the graph.
 *
 * Constraints:
 * - 1 <= n <= 2000
 * - 0 <= edges.length <= 5000
 * - edges[i].length == 2
 * - 0 <= ai, bi < n
 * - ai != bi
 * - There are no duplicate edges
 *
 * Example 1:
 * n = 5, edges = [[0,1],[1,2],[3,4]] -> 2
 * Example 2:
 * n = 5, edges = [[0,1],[1,2],[2,3],[3,4]] -> 1
 * Example 3:
 * n = 5, edges = [] -> 5
 */
public class LC323_Number_Of_Connected_Components_In_An_Undirected_Graph {
    public int countComponents(int n, int[][] edges) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public static void main(String[] args) {
        LC323_Number_Of_Connected_Components_In_An_Undirected_Graph solver =
                new LC323_Number_Of_Connected_Components_In_An_Undirected_Graph();

        TestCase[] tests = new TestCase[]{
                new TestCase(5, new int[][]{{0, 1}, {1, 2}, {3, 4}}, 2),
                new TestCase(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}, 1),
                new TestCase(5, new int[][]{}, 5)
        };

        runAllTests(solver, tests);
    }

    private static void runAllTests(
            LC323_Number_Of_Connected_Components_In_An_Undirected_Graph solver,
            TestCase[] tests) {
        int passed = 0;
        for (int i = 0; i < tests.length; i++) {
            TestCase tc = tests[i];
            try {
                int actual = solver.countComponents(tc.n, tc.edges);
                boolean ok = actual == tc.expected;
                if (ok) {
                    passed++;
                }
                System.out.printf(
                        "Test %d | n=%d, edges=%s | expected=%d, actual=%d | %s%n",
                        i + 1, tc.n, Arrays.deepToString(tc.edges), tc.expected, actual, ok ? "PASS" : "FAIL");
            } catch (UnsupportedOperationException ex) {
                System.out.printf(
                        "Test %d | n=%d, edges=%s | expected=%d | SKIPPED (%s)%n",
                        i + 1, tc.n, Arrays.deepToString(tc.edges), tc.expected, ex.getMessage());
            }
        }
        System.out.printf("Summary: %d/%d tests passed.%n", passed, tests.length);
    }

    private static class TestCase {
        final int n;
        final int[][] edges;
        final int expected;

        TestCase(int n, int[][] edges, int expected) {
            this.n = n;
            this.edges = edges;
            this.expected = expected;
        }
    }
}
