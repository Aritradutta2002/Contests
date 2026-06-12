package com.aritra.contests.leetcode;

/*
 * LeetCode 1888. Minimum Number of Flips to Make the Binary String Alternating
 *
 * Description:
 * You are given a binary string s. In one step, you can do one of the following:
 * 1) Remove the first character of s and append it to the end.
 * 2) Choose any character in s and flip it ('0' -> '1' or '1' -> '0').
 *
 * Return the minimum number of flips needed to make s alternating after any number
 * of type-1 operations.
 *
 * Constraints:
 * 1 <= s.length <= 10^5
 * s[i] is either '0' or '1'.
 */
public class LC1888_Minimum_Number_Of_Flips_To_Make_The_Binary_String_Alternating_B {

    public int minFlips(String s) {
        int n = s.length();
        String doubled = s + s;
        int mismatchesStartWithZero = 0; // pattern: 010101...
        int mismatchesStartWithOne = 0;  // pattern: 101010...
        int answer = Integer.MAX_VALUE;

        for (int right = 0; right < doubled.length(); right++) {
            char current = doubled.charAt(right);
            char expectedZero = (right % 2 == 0) ? '0' : '1';
            char expectedOne = (right % 2 == 0) ? '1' : '0';

            if (current != expectedZero) {
                mismatchesStartWithZero++;
            }
            if (current != expectedOne) {
                mismatchesStartWithOne++;
            }

            int windowSize = right + 1;
            if (windowSize > n) {
                int left = right - n;
                char leftChar = doubled.charAt(left);
                char leftExpectedZero = (left % 2 == 0) ? '0' : '1';
                char leftExpectedOne = (left % 2 == 0) ? '1' : '0';

                if (leftChar != leftExpectedZero) {
                    mismatchesStartWithZero--;
                }
                if (leftChar != leftExpectedOne) {
                    mismatchesStartWithOne--;
                }
            }

            if (right + 1 >= n) {
                answer = Math.min(answer, Math.min(mismatchesStartWithZero, mismatchesStartWithOne));
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        LC1888_Minimum_Number_Of_Flips_To_Make_The_Binary_String_Alternating_B solver = new LC1888_Minimum_Number_Of_Flips_To_Make_The_Binary_String_Alternating_B();

        TestCase[] tests = new TestCase[] {
                // Official sample tests
                new TestCase("111000", 2),
                new TestCase("010", 0),
                new TestCase("1110", 1),

                // Extra sanity tests
                new TestCase("0", 0),
                new TestCase("1", 0),
                new TestCase("101010", 0)
        };

        runAllTests(solver, tests);
    }

    private static void runAllTests(
            LC1888_Minimum_Number_Of_Flips_To_Make_The_Binary_String_Alternating_B solver,
            TestCase[] tests) {

        int passed = 0;

        for (int i = 0; i < tests.length; i++) {
            TestCase tc = tests[i];
            try {
                int actual = solver.minFlips(tc.s);
                boolean ok = actual == tc.expected;
                if (ok) {
                    passed++;
                }

                System.out.printf(
                        "Test %d | s=%s | expected=%d, actual=%d | %s%n",
                        i + 1,
                        tc.s,
                        tc.expected,
                        actual,
                        ok ? "PASS" : "FAIL");
            } catch (UnsupportedOperationException ex) {
                System.out.printf(
                        "Test %d | s=%s | expected=%d | SKIPPED (%s)%n",
                        i + 1,
                        tc.s,
                        tc.expected,
                        ex.getMessage());
            }
        }

        System.out.printf("Summary: %d/%d tests passed.%n", passed, tests.length);
    }

    private static class TestCase {
        String s;
        int expected;

        TestCase(String s, int expected) {
            this.s = s;
            this.expected = expected;
        }
    }
}
