package com.aritra.contests.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.math.BigInteger;

/*
 * 3826. Minimum Partition Score
 *
 * Partition an array into exactly k subarrays to minimize the sum of the maximum of each subarray.
 *
 * Constraints:
 * - 1 <= nums.length <= 1000
 * - 1 <= k <= nums.length
 * - 1 <= nums[i] <= 10^4
 */
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
}
