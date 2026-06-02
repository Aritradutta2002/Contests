package LeetCode;
import java.util.*;
/*
 * 3633. Earliest Finish Time for Land and Water Rides I
 *
 * You are given two categories of theme park attractions: land rides and water rides.
 *   - landStartTime[i] - the earliest time the i-th land ride can be boarded.
 *   - landDuration[i]  - how long the i-th land ride lasts.
 *   - waterStartTime[j] - the earliest time the j-th water ride can be boarded.
 *   - waterDuration[j]  - how long the j-th water ride lasts.
 *
 * A tourist must experience exactly one ride from each category, in either order.
 *   - A ride may be started at its opening time or any later moment.
 *   - If a ride is started at time t, it finishes at time t + duration.
 *   - Immediately after finishing one ride, the tourist may board the other
 *     (if it is already open) or wait until it opens.
 *
 * Return the earliest possible time at which the tourist can finish both rides.
 *
 * Constraints:
 * - 1 <= n, m <= 100
 * - landStartTime.length == landDuration.length == n
 * - waterStartTime.length == waterDuration.length == m
 * - 1 <= landStartTime[i], landDuration[i], waterStartTime[j], waterDuration[j] <= 1000
 */
public class LC3633_Earliest_Finish_Time_For_Land_And_Water_Rides_I {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int land = landStartTime[i] + landDuration[i];
                int land_water =
                        Math.max(land, waterStartTime[j]) + waterDuration[j];
                res = Math.min(res, land_water);

                int water = waterStartTime[j] + waterDuration[j];
                int water_land =
                        Math.max(water, landStartTime[i]) + landDuration[i];
                res = Math.min(res, water_land);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC3633_Earliest_Finish_Time_For_Land_And_Water_Rides_I solver = new LC3633_Earliest_Finish_Time_For_Land_And_Water_Rides_I();
        runTest(solver, 1,
                new int[] { 2, 8 }, new int[] { 4, 1 },
                new int[] { 6 }, new int[] { 3 },
                9);

        runTest(solver, 2,
                new int[] { 5 }, new int[] { 3 },
                new int[] { 1 }, new int[] { 10 },
                14);

        runTest(solver, 3,
                new int[] { 1 }, new int[] { 2 },
                new int[] { 3 }, new int[] { 4 },
                7);
    }

    private static void runTest(LC3633_Earliest_Finish_Time_For_Land_And_Water_Rides_I solver,
            int testId,
            int[] landStartTime, int[] landDuration,
            int[] waterStartTime, int[] waterDuration,
            int expected) {
        try {
            int result = solver.earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration);
            if (result == expected) {
                System.out.println("Test " + testId + ": PASS");
            } else {
                System.out.println("Test " + testId + ": FAIL");
                System.out.println("  Expected: " + expected);
                System.out.println("  Actual:   " + result);
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Test " + testId + ": SKIPPED (Not implemented)");
        } catch (Exception e) {
            System.out.println("Test " + testId + ": ERROR (" + e.getMessage() + ")");
        }
    }

}
