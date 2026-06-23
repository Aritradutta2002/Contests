package com.aritra.contests.leetcode;
import java.util.*;
/*
 * 417. Pacific Atlantic Water Flow
 *
 * Description:
 * Given an m x n matrix heights where heights[r][c] is the height above sea level,
 * water can flow from a cell to neighboring cells (up, down, left, right) with equal
 * or lower height. The Pacific touches the left and top edges, and the Atlantic touches
 * the right and bottom edges. Return all coordinates where water can flow to both oceans.
 *
 * Constraints:
 * - m == heights.length
 * - n == heights[r].length
 * - 1 <= m, n <= 200
 * - 0 <= heights[r][c] <= 10^5
 *
 * Example 1:
 * heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * -> [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * Example 2:
 * heights = [[1]] -> [[0,0]]
 * Example 3:
 * heights = [[1,1],[1,1]] -> [[0,0],[0,1],[1,0],[1,1]]
 */
public class LC417_Pacific_Atlantic_Water_Flow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    private static Set<String> toCoordSet(List<List<Integer>> points) {
        Set<String> s = new HashSet<>();
        for (List<Integer> p : points) {
            s.add(p.get(0) + "," + p.get(1));
        }
        return s;
    }
    private static void runAllTests(LC417_Pacific_Atlantic_Water_Flow solver, TestCase[] tests) {
        int passed = 0;
        for (int i = 0; i < tests.length; i++) {
            TestCase tc = tests[i];
            try {
                List<List<Integer>> actual = solver.pacificAtlantic(tc.heights);
                boolean ok = toCoordSet(actual).equals(toCoordSet(tc.expected));
                if (ok) {
                    passed++;
                }
                System.out.printf(
                        "Test %d | heights=%s | expected=%s, actual=%s | %s%n",
                        i + 1, Arrays.deepToString(tc.heights), tc.expected, actual, ok ? "PASS" : "FAIL");
            } catch (UnsupportedOperationException ex) {
                System.out.printf(
                        "Test %d | heights=%s | expected=%s | SKIPPED (%s)%n",
                        i + 1, Arrays.deepToString(tc.heights), tc.expected, ex.getMessage());
            }
        }
        System.out.printf("Summary: %d/%d tests passed.%n", passed, tests.length);
    }
    private static class TestCase {
        final int[][] heights;
        final List<List<Integer>> expected;

        TestCase(int[][] heights, List<List<Integer>> expected) {
            this.heights = heights;
            this.expected = expected;
        }
    }
}
