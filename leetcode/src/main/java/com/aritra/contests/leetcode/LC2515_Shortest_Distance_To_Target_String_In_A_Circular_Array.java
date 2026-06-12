package com.aritra.contests.leetcode;
import java.util.*;
/*
 * 2515. Shortest Distance to Target String in a Circular Array
 *
 * Description:
 * You are given a circular array words and a target string target. Return the shortest
 * distance from startIndex to any index i such that words[i] == target. Distance is the
 * minimum number of steps moving left or right in the circular array. Return -1 if target
 * does not exist in words.
 *
 * Constraints:
 * - 1 <= words.length <= 100
 * - 1 <= words[i].length <= 100
 * - words[i] and target consist of lowercase English letters
 * - 0 <= startIndex < words.length
 *
 * Example 1:
 * words = ["hello","i","am","leetcode","hello"], target = "hello", startIndex = 1 -> 1
 * Example 2:
 * words = ["a","b","leetcode"], target = "leetcode", startIndex = 0 -> 1
 * Example 3:
 * words = ["i","eat","leetcode"], target = "ate", startIndex = 0 -> -1
 */
public class LC2515_Shortest_Distance_To_Target_String_In_A_Circular_Array {
    public int closetTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDistance = Integer.MAX_VALUE;
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                found = true;
                int dist = Math.abs(i - startIndex);
                minDistance = Math.min(minDistance, Math.min(dist, n - dist));
            }
        }

        return found ? minDistance : -1;
    }

    public static void main(String[] args) {
        LC2515_Shortest_Distance_To_Target_String_In_A_Circular_Array solver = new LC2515_Shortest_Distance_To_Target_String_In_A_Circular_Array();

        TestCase[] tests = new TestCase[] {
                new TestCase(new String[] { "hello", "i", "am", "leetcode", "hello" }, "hello", 1, 1),
                new TestCase(new String[] { "a", "b", "leetcode" }, "leetcode", 0, 1),
                new TestCase(new String[] { "i", "eat", "leetcode" }, "ate", 0, -1)
        };

        runAllTests(solver, tests);
    }

    private static void runAllTests(
            LC2515_Shortest_Distance_To_Target_String_In_A_Circular_Array solver,
            TestCase[] tests) {
        int passed = 0;
        for (int i = 0; i < tests.length; i++) {
            TestCase tc = tests[i];
            try {
                int actual = solver.closetTarget(tc.words, tc.target, tc.startIndex);
                boolean ok = actual == tc.expected;
                if (ok) {
                    passed++;
                }
                System.out.printf(
                        "Test %d | words=%s, target=%s, startIndex=%d | expected=%d, actual=%d | %s%n",
                        i + 1, Arrays.toString(tc.words), tc.target, tc.startIndex,
                        tc.expected, actual, ok ? "PASS" : "FAIL");
            } catch (UnsupportedOperationException ex) {
                System.out.printf(
                        "Test %d | words=%s, target=%s, startIndex=%d | expected=%d | SKIPPED (%s)%n",
                        i + 1, Arrays.toString(tc.words), tc.target, tc.startIndex,
                        tc.expected, ex.getMessage());
            }
        }
        System.out.printf("Summary: %d/%d tests passed.%n", passed, tests.length);
    }

    private static class TestCase {
        final String[] words;
        final String target;
        final int startIndex;
        final int expected;

        TestCase(String[] words, String target, int startIndex, int expected) {
            this.words = words;
            this.target = target;
            this.startIndex = startIndex;
            this.expected = expected;
        }
    }
}
