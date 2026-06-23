package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2770_Maximum_Number_Of_Jumps_To_Reach_The_Last_Index_Test {

    @Test
    public void testStandardCase() {
        LC2770_Maximum_Number_Of_Jumps_To_Reach_The_Last_Index solver = new LC2770_Maximum_Number_Of_Jumps_To_Reach_The_Last_Index();
        int[] nums = {1,3,6,4,1,2};
        assertEquals(5, solver.maximumJumps(nums, 3));
    }

    @Test
    public void testImpossibleCase() {
        LC2770_Maximum_Number_Of_Jumps_To_Reach_The_Last_Index solver = new LC2770_Maximum_Number_Of_Jumps_To_Reach_The_Last_Index();
        int[] nums = {0,2,1,3};
        assertEquals(-1, solver.maximumJumps(nums, 1));
    }
}
