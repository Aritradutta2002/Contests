package com.aritra.contests.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.math.BigInteger;

public class LC3826_Minimum_Partition_Score {
    public long minPartitionScore(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        long inf = Long.MAX_VALUE / 4;
        long[] prev = new long[n + 1];
        long[] curr = new long[n + 1];
        Arrays.fill(prev, inf);
        prev[0] = 0;

        for (int parts = 1; parts <= k; parts++) {
            Arrays.fill(curr, inf);
            ArrayDeque<Line> hull = new ArrayDeque<>();
            hull.addLast(buildLine(parts - 1, prefix, prev));

            for (int i = parts; i <= n; i++) {
                long x = prefix[i];
                while (hull.size() >= 2 && firstLine(hull).valueAt(x) >= secondLine(hull).valueAt(x)) {
                    hull.removeFirst();
                }

                Line best = hull.peekFirst();
                curr[i] = x * x + x + best.valueAt(x);

                if (i < n && prev[i] < inf) {
                    Line nextLine = buildLine(i, prefix, prev);
                    while (hull.size() >= 2) {
                        Line last = hull.removeLast();
                        Line secondLast = hull.peekLast();
                        if (isRedundant(secondLast, last, nextLine)) {
                            continue;
                        }
                        hull.addLast(last);
                        break;
                    }
                    hull.addLast(nextLine);
                }
            }

            long[] swap = prev;
            prev = curr;
            curr = swap;
        }

        return prev[n] / 2L;
    }

    private Line buildLine(int index, long[] prefix, long[] dp) {
        long sum = prefix[index];
        return new Line(-2L * sum, dp[index] + sum * sum - sum);
    }

    private boolean isRedundant(Line a, Line b, Line c) {
        BigInteger left = BigInteger.valueOf(b.intercept - a.intercept)
                .multiply(BigInteger.valueOf(a.slope - c.slope));
        BigInteger right = BigInteger.valueOf(c.intercept - a.intercept)
                .multiply(BigInteger.valueOf(a.slope - b.slope));
        return left.compareTo(right) >= 0;
    }

    private Line firstLine(ArrayDeque<Line> hull) {
        return hull.peekFirst();
    }

    private Line secondLine(ArrayDeque<Line> hull) {
        Iterator<Line> iterator = hull.iterator();
        iterator.next();
        return iterator.next();
    }

    private static final class Line {
        final long slope;
        final long intercept;

        Line(long slope, long intercept) {
            this.slope = slope;
            this.intercept = intercept;
        }

        long valueAt(long x) {
            return slope * x + intercept;
        }
    }

    public static void main(String[] args) {
        /*
         * LeetCode 3826. Minimum Partition Score
         *
         * Description:
         * Partition nums into exactly k non-empty contiguous subarrays.
         * The value of a subarray with sum = sumArr is:
         *   sumArr * (sumArr + 1) / 2
         * Return the minimum possible total score across all k-partitions.
         *
         * Constraints:
         * 1 <= nums.length <= 1000
         * 1 <= nums[i] <= 10^4
         * 1 <= k <= nums.length
         */

        LC3826_Minimum_Partition_Score solver = new LC3826_Minimum_Partition_Score();

        TestCase[] tests = new TestCase[]{
                // Official examples
                new TestCase(new int[]{5, 1, 2, 1}, 2, 25L),
                new TestCase(new int[]{1, 2, 3, 4}, 1, 55L),
                new TestCase(new int[]{1, 1, 1}, 3, 3L),

                // Extra sanity checks
                new TestCase(new int[]{7}, 1, 28L),
                new TestCase(new int[]{2, 2, 2, 2}, 4, 12L)
        };

        runAllTests(solver, tests);
    }

    private static void runAllTests(LC3826_Minimum_Partition_Score solver, TestCase[] tests) {
        int passed = 0;

        for (int i = 0; i < tests.length; i++) {
            TestCase tc = tests[i];
            try {
                long actual = solver.minPartitionScore(tc.nums, tc.k);
                boolean ok = actual == tc.expected;
                if (ok) {
                    passed++;
                }

                System.out.printf(
                        "Test %d | nums=%s, k=%d | expected=%d, actual=%d | %s%n",
                        i + 1,
                        Arrays.toString(tc.nums),
                        tc.k,
                        tc.expected,
                        actual,
                        ok ? "PASS" : "FAIL"
                );
            } catch (UnsupportedOperationException ex) {
                System.out.printf(
                        "Test %d | nums=%s, k=%d | expected=%d | SKIPPED (%s)%n",
                        i + 1,
                        Arrays.toString(tc.nums),
                        tc.k,
                        tc.expected,
                        ex.getMessage()
                );
            }
        }

        System.out.printf("Summary: %d/%d tests passed.%n", passed, tests.length);
    }

    private static class TestCase {
        int[] nums;
        int k;
        long expected;

        TestCase(int[] nums, int k, long expected) {
            this.nums = nums;
            this.k = k;
            this.expected = expected;
        }
    }
}
