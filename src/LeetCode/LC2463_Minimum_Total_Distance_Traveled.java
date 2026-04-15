package LeetCode;
import java.util.*;
/**
 * 2463. Minimum Total Distance Traveled
 *
 * Description:
 * There are some robots and factories on the X-axis. You are given an integer array robot 
 * where robot[i] is the position of the ith robot. You are also given a 2D integer array 
 * factory where factory[j] = [positionj, limitj] indicates that positionj is the position 
 * of the jth factory and that the jth factory can repair at most limitj robots.
 *
 * The positions of each robot are unique. The positions of each factory are also unique. 
 * Note that a robot can be in the same position as a factory initially.
 *
 * Constraints:
 * - 1 <= robot.length, factory.length <= 100
 * - factory[j].length == 2
 * - -10^9 <= robot[i], positionj <= 10^9
 * - 0 <= limitj <= robot.length
 * - The input will be generated such that it is always possible to repair every robot.
 */
public class LC2463_Minimum_Total_Distance_Traveled {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));

        int n = robot.size();
        int m = factory.length;

        // dp[i][j] = min distance using first i factories to repair first j robots
        long[][] dp = new long[m + 1][n + 1];
        
        // Initialize with a large value
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE / 2);
        }
        
        // Base case: 0 robots fixed with any number of factories cost 0
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= m; i++) {
            int factoryPos = factory[i-1][0];
            int factoryLimit = factory[i-1][1];

            for (int j = 0; j <= n; j++) {
                // Option 1: Current factory repairs 0 robots
                dp[i][j] = dp[i-1][j];

                // Option 2: Current factory repairs k robots (1 <= k <= limit)
                long currentDistance = 0;
                for (int k = 1; k <= factoryLimit && j - k >= 0; k++) {
                    currentDistance += Math.abs((long)robot.get(j - k) - factoryPos);
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-k] + currentDistance);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        LC2463_Minimum_Total_Distance_Traveled solver = new LC2463_Minimum_Total_Distance_Traveled();

        TestCase[] tests = new TestCase[] {
                new TestCase(Arrays.asList(0, 4, 6), new int[][] { { 2, 2 }, { 6, 2 } }, 4),
                new TestCase(Arrays.asList(1, -1), new int[][] { { -2, 1 }, { 2, 1 } }, 2)
        };

        runAllTests(solver, tests);
    }

    private static void runAllTests(
            LC2463_Minimum_Total_Distance_Traveled solver,
            TestCase[] tests) {
        int passed = 0;
        for (int i = 0; i < tests.length; i++) {
            TestCase tc = tests[i];
            try {
                long actual = solver.minimumTotalDistance(tc.robot, tc.factory);
                boolean ok = actual == tc.expected;
                if (ok) {
                    passed++;
                }
                System.out.printf(
                        "Test %d | robot=%s, factory=%s | expected=%d, actual=%d | %s%n",
                        i + 1, tc.robot.toString(), Arrays.deepToString(tc.factory),
                        tc.expected, actual, ok ? "PASS" : "FAIL");
            } catch (UnsupportedOperationException ex) {
                System.out.printf(
                        "Test %d | robot=%s, factory=%s | expected=%d | SKIPPED (%s)%n",
                        i + 1, tc.robot.toString(), Arrays.deepToString(tc.factory),
                        tc.expected, ex.getMessage());
            }
        }
        System.out.printf("Summary: %d/%d tests passed.%n", passed, tests.length);
    }

    private static class TestCase {
        final List<Integer> robot;
        final int[][] factory;
        final long expected;

        TestCase(List<Integer> robot, int[][] factory, long expected) {
            this.robot = robot;
            this.factory = factory;
            this.expected = expected;
        }
    }
}
