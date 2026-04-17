package LeetCode;
import java.util.*;
/*
 * 3761. Minimum Absolute Distance Between Mirror Pairs
 *
 * Description:
 * You are given an integer array nums.
 * A mirror pair is a pair of indices (i, j) such that:
 * - 0 <= i < j < nums.length
 * - reverse(nums[i]) == nums[j]
 * where reverse(x) is the integer formed by reversing the digits of x.
 * Leading zeros are omitted after reversing (for example, reverse(120) = 21).
 * Return the minimum absolute distance between indices of any mirror pair.
 * If no mirror pair exists, return -1.
 *
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - 1 <= nums[i] <= 10^9
 *
 * Example 1:
 * nums = [12,21,45,33,54] -> 1
 * Example 2:
 * nums = [120,21] -> 1
 * Example 3:
 * nums = [21,120] -> -1
 */
public class LC3761_Minimum_Absolute_Distance_Between_Mirror_Pairs {

    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        int minimumDistance = n + 1;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                minimumDistance = Math.min(minimumDistance, i - map.get(nums[i]));
            }
            map.put(reverse(nums[i]), i);
        }

        return minimumDistance == n + 1 ? -1 : minimumDistance;
    }

    public int reverse(int n) {
        int x = 0;
        while (n > 0) {
            x = x * 10 + (n % 10);
            n /= 10;
        }
        return x;
    }

    public static void main(String[] args) {
        LC3761_Minimum_Absolute_Distance_Between_Mirror_Pairs solver = new LC3761_Minimum_Absolute_Distance_Between_Mirror_Pairs();

        TestCase[] tests = new TestCase[] {
                new TestCase(new int[] { 12, 21, 45, 33, 54 }, 1),
                new TestCase(new int[] { 120, 21 }, 1),
                new TestCase(new int[] { 21, 120 }, -1)
        };

        runAllTests(solver, tests);
    }

    private static void runAllTests(
            LC3761_Minimum_Absolute_Distance_Between_Mirror_Pairs solver,
            TestCase[] tests) {
        int passed = 0;

        for (int i = 0; i < tests.length; i++) {
            TestCase tc = tests[i];
            try {
                int actual = solver.minMirrorPairDistance(tc.nums);
                boolean ok = actual == tc.expected;
                if (ok) {
                    passed++;
                }
                System.out.printf(
                        "Test %d | nums=%s | expected=%d, actual=%d | %s%n",
                        i + 1,
                        Arrays.toString(tc.nums),
                        tc.expected,
                        actual,
                        ok ? "PASS" : "FAIL");
            } catch (UnsupportedOperationException ex) {
                System.out.printf(
                        "Test %d | nums=%s | expected=%d | SKIPPED (%s)%n",
                        i + 1,
                        Arrays.toString(tc.nums),
                        tc.expected,
                        ex.getMessage());
            }
        }

        System.out.printf("Summary: %d/%d tests passed.%n", passed, tests.length);
    }

    private static class TestCase {
        final int[] nums;
        final int expected;

        TestCase(int[] nums, int expected) {
            this.nums = nums;
            this.expected = expected;
        }
    }
}
