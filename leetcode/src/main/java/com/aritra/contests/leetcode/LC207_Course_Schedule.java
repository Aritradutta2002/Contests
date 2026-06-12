package com.aritra.contests.leetcode;
import java.util.*;
/*
 * 207. Course Schedule
 *
 * Description:
 * There are numCourses courses labeled from 0 to numCourses - 1. You are given
 * prerequisites where prerequisites[i] = [ai, bi] means you must take course bi
 * before course ai. Return true if you can finish all courses.
 *
 * Constraints:
 * - 1 <= numCourses <= 2000
 * - 0 <= prerequisites.length <= 5000
 * - prerequisites[i].length == 2
 * - 0 <= ai, bi < numCourses
 * - ai != bi
 *
 * Example 1:
 * numCourses = 2, prerequisites = [[1,0]] -> true
 * Example 2:
 * numCourses = 2, prerequisites = [[1,0],[0,1]] -> false
 * Example 3:
 * numCourses = 5, prerequisites = [[1,4],[2,4],[3,1],[3,2]] -> true
 */
public class LC207_Course_Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public static void main(String[] args) {
        LC207_Course_Schedule solver = new LC207_Course_Schedule();

        TestCase[] tests = new TestCase[]{
                new TestCase(2, new int[][]{{1, 0}}, true),
                new TestCase(2, new int[][]{{1, 0}, {0, 1}}, false),
                new TestCase(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}, true)
        };

        runAllTests(solver, tests);
    }

    private static void runAllTests(LC207_Course_Schedule solver, TestCase[] tests) {
        int passed = 0;
        for (int i = 0; i < tests.length; i++) {
            TestCase tc = tests[i];
            try {
                boolean actual = solver.canFinish(tc.numCourses, tc.prerequisites);
                boolean ok = actual == tc.expected;
                if (ok) {
                    passed++;
                }
                System.out.printf(
                        "Test %d | numCourses=%d, prerequisites=%s | expected=%s, actual=%s | %s%n",
                        i + 1, tc.numCourses, Arrays.deepToString(tc.prerequisites),
                        tc.expected, actual, ok ? "PASS" : "FAIL");
            } catch (UnsupportedOperationException ex) {
                System.out.printf(
                        "Test %d | numCourses=%d, prerequisites=%s | expected=%s | SKIPPED (%s)%n",
                        i + 1, tc.numCourses, Arrays.deepToString(tc.prerequisites),
                        tc.expected, ex.getMessage());
            }
        }
        System.out.printf("Summary: %d/%d tests passed.%n", passed, tests.length);
    }

    private static class TestCase {
        final int numCourses;
        final int[][] prerequisites;
        final boolean expected;

        TestCase(int numCourses, int[][] prerequisites, boolean expected) {
            this.numCourses = numCourses;
            this.prerequisites = prerequisites;
            this.expected = expected;
        }
    }
}
