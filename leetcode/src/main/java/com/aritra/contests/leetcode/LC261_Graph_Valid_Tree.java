package com.aritra.contests.leetcode;
import java.util.*;
/*
 * 261. Graph Valid Tree
 *
 * Description:
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges, return
 * true if these edges make up a valid tree.
 *
 * Constraints:
 * - 1 <= n <= 2000
 * - 0 <= edges.length <= 5000
 * - edges[i].length == 2
 * - 0 <= ai, bi < n
 * - ai != bi
 * - There are no self-loops or duplicate edges
 *
 * Example 1:
 * n = 5, edges = [[0,1],[0,2],[0,3],[1,4]] -> true
 * Example 2:
 * n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]] -> false
 * Example 3:
 * n = 4, edges = [[0,1],[2,3]] -> false
 */
public class LC261_Graph_Valid_Tree {
    public boolean validTree(int n, int[][] edges) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    private static void runAllTests(LC261_Graph_Valid_Tree solver, TestCase[] tests) {
        int passed = 0;
        for (int i = 0; i < tests.length; i++) {
            TestCase tc = tests[i];
            try {
                boolean actual = solver.validTree(tc.n, tc.edges);
                boolean ok = actual == tc.expected;
                if (ok) {
                    passed++;
                }
                System.out.printf(
                        "Test %d | n=%d, edges=%s | expected=%s, actual=%s | %s%n",
                        i + 1, tc.n, Arrays.deepToString(tc.edges), tc.expected, actual, ok ? "PASS" : "FAIL");
            } catch (UnsupportedOperationException ex) {
                System.out.printf(
                        "Test %d | n=%d, edges=%s | expected=%s | SKIPPED (%s)%n",
                        i + 1, tc.n, Arrays.deepToString(tc.edges), tc.expected, ex.getMessage());
            }
        }
        System.out.printf("Summary: %d/%d tests passed.%n", passed, tests.length);
    }
    private static class TestCase {
        final int n;
        final int[][] edges;
        final boolean expected;

        TestCase(int n, int[][] edges, boolean expected) {
            this.n = n;
            this.edges = edges;
            this.expected = expected;
        }
    }
}
