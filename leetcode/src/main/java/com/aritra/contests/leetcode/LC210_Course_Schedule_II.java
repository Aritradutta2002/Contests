package com.aritra.contests.leetcode;
import java.util.*;
/*
 * 210. Course Schedule II
 *
 * Description:
 * There are numCourses courses labeled from 0 to numCourses - 1. You are given
 * prerequisites where prerequisites[i] = [ai, bi] means you must take course bi
 * before course ai. Return an ordering of courses you should take to finish all
 * courses. If there are many valid answers, return any of them. If impossible, return [].
 *
 * Constraints:
 * - 1 <= numCourses <= 2000
 * - 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * - prerequisites[i].length == 2
 * - 0 <= ai, bi < numCourses
 * - ai != bi
 *
 * Example 1:
 * numCourses = 2, prerequisites = [[1,0]] -> [0,1]
 * Example 2:
 * numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]] -> [0,1,2,3] or [0,2,1,3]
 * Example 3:
 * numCourses = 1, prerequisites = [] -> [0]
 */
public class LC210_Course_Schedule_II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    private static boolean isValidOrder(int[] order, int numCourses, int[][] prerequisites) {
        if (order.length != numCourses) {
            return false;
        }
        int[] pos = new int[numCourses];
        for (int i = 0; i < order.length; i++) {
            if (order[i] < 0 || order[i] >= numCourses) {
                return false;
            }
            pos[order[i]] = i;
        }
        for (int[] p : prerequisites) {
            if (pos[p[1]] > pos[p[0]]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC210_Course_Schedule_II solver = new LC210_Course_Schedule_II();

        TestCase[] tests = new TestCase[]{
                new TestCase(2, new int[][]{{1, 0}}, true, new int[]{0, 1}),
                new TestCase(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}, true, new int[]{0, 2, 1, 3}),
                new TestCase(1, new int[][]{}, true, new int[]{0})
        };

        runAllTests(solver, tests);
    }

    private static void runAllTests(LC210_Course_Schedule_II solver, TestCase[] tests) {
        int passed = 0;
        for (int i = 0; i < tests.length; i++) {
            TestCase tc = tests[i];
            try {
                int[] actual = solver.findOrder(tc.numCourses, tc.prerequisites);
                boolean ok = tc.expectPossible
                        ? isValidOrder(actual, tc.numCourses, tc.prerequisites)
                        : actual.length == 0;
                if (ok) {
                    passed++;
                }
                System.out.printf(
                        "Test %d | numCourses=%d, prerequisites=%s | expectedPossible=%s, sampleExpected=%s, actual=%s | %s%n",
                        i + 1, tc.numCourses, Arrays.deepToString(tc.prerequisites), tc.expectPossible,
                        Arrays.toString(tc.sampleExpected), Arrays.toString(actual), ok ? "PASS" : "FAIL");
            } catch (UnsupportedOperationException ex) {
                System.out.printf(
                        "Test %d | numCourses=%d, prerequisites=%s | expectedPossible=%s | SKIPPED (%s)%n",
                        i + 1, tc.numCourses, Arrays.deepToString(tc.prerequisites), tc.expectPossible, ex.getMessage());
            }
        }
        System.out.printf("Summary: %d/%d tests passed.%n", passed, tests.length);
    }

    private static class TestCase {
        final int numCourses;
        final int[][] prerequisites;
        final boolean expectPossible;
        final int[] sampleExpected;

        TestCase(int numCourses, int[][] prerequisites, boolean expectPossible, int[] sampleExpected) {
            this.numCourses = numCourses;
            this.prerequisites = prerequisites;
            this.expectPossible = expectPossible;
            this.sampleExpected = sampleExpected;
        }
    }
}
