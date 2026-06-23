package com.aritra.contests.leetcode;
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
}
