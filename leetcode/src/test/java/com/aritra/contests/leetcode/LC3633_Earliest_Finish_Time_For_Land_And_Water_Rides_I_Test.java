package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3633_Earliest_Finish_Time_For_Land_And_Water_Rides_I_Test {

    @Test
    public void testExample1() {
        LC3633_Earliest_Finish_Time_For_Land_And_Water_Rides_I solver = new LC3633_Earliest_Finish_Time_For_Land_And_Water_Rides_I();
        int[] landStartTime = {0, 5};
        int[] landDuration = {3, 2};
        int[] waterStartTime = {2, 4};
        int[] waterDuration = {4, 1};
        assertEquals(5, solver.earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration));
    }

    @Test
    public void testExample2() {
        LC3633_Earliest_Finish_Time_For_Land_And_Water_Rides_I solver = new LC3633_Earliest_Finish_Time_For_Land_And_Water_Rides_I();
        int[] landStartTime = {1};
        int[] landDuration = {5};
        int[] waterStartTime = {3};
        int[] waterDuration = {2};
        assertEquals(8, solver.earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration));
    }
}
