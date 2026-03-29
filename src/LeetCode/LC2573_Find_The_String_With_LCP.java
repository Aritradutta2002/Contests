package LeetCode;
import java.util.*;
/*
 * LeetCode 2573. Find the String with LCP
 *
 * Description:
 * You are given an n x n matrix lcp where lcp[i][j] is the length of the longest
 * common prefix between the suffixes word[i:] and word[j:].
 * Return the lexicographically smallest lowercase English string word that
 * produces the given matrix. If no such string exists, return an empty string.
 *
 * Constraints:
 * 1 <= n == lcp.length == lcp[i].length <= 1000
 * 0 <= lcp[i][j] <= n
 */
public class LC2573_Find_The_String_With_LCP {

    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] word = new char[n];

        char nextChar = 'a';
        for (int i = 0; i < n; i++) {
            if (word[i] != '\0') {
                continue;
            }
            if (nextChar > 'z') {
                return "";
            }

            word[i] = nextChar;
            for (int j = i + 1; j < n; j++) {
                if (lcp[i][j] > 0) {
                    word[j] = nextChar;
                }
            }
            nextChar++;
        }

        int[][] computed = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word[i] == word[j]) {
                    computed[i][j] = computed[i + 1][j + 1] + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computed[i][j] != lcp[i][j]) {
                    return "";
                }
            }
        }

        return new String(word);

    }

    public static void main(String[] args) {
        LC2573_Find_The_String_With_LCP solver = new LC2573_Find_The_String_With_LCP();

        TestCase[] tests = new TestCase[]{
                new TestCase(
                        new int[][]{
                                {4, 0, 2, 0},
                                {0, 3, 0, 1},
                                {2, 0, 2, 0},
                                {0, 1, 0, 1}
                        },
                        "abab"
                ),
                new TestCase(
                        new int[][]{
                                {4, 2, 1, 0},
                                {2, 3, 1, 0},
                                {1, 1, 2, 0},
                                {0, 0, 0, 1}
                        },
                    "aaab"
                ),
                new TestCase(
                        new int[][]{
                                {4, 3, 2, 1},
                                {3, 3, 2, 1},
                                {2, 2, 2, 1},
                                {1, 1, 1, 1}
                        },
                        "aaaa"
                )
        };

        runAllTests(solver, tests);
    }

    private static void runAllTests(LC2573_Find_The_String_With_LCP solver, TestCase[] tests) {
        int passed = 0;

        for (int i = 0; i < tests.length; i++) {
            TestCase tc = tests[i];
            try {
                String actual = solver.findTheString(tc.lcp);
                boolean ok = Objects.equals(tc.expected, actual);
                if (ok) {
                    passed++;
                }

                System.out.printf(
                        "Test %d | lcp=%s | expected=%s, actual=%s | %s%n",
                        i + 1,
                        Arrays.deepToString(tc.lcp),
                        quote(tc.expected),
                        quote(actual),
                        ok ? "PASS" : "FAIL"
                );
            } catch (UnsupportedOperationException ex) {
                System.out.printf(
                        "Test %d | lcp=%s | expected=%s | SKIPPED (%s)%n",
                        i + 1,
                        Arrays.deepToString(tc.lcp),
                        quote(tc.expected),
                        ex.getMessage()
                );
            }
        }

        System.out.printf("Summary: %d/%d tests passed.%n", passed, tests.length);
    }

    private static String quote(String value) {
        return "\"" + value + "\"";
    }

    private static class TestCase {
        int[][] lcp;
        String expected;

        TestCase(int[][] lcp, String expected) {
            this.lcp = lcp;
            this.expected = expected;
        }
    }
}
