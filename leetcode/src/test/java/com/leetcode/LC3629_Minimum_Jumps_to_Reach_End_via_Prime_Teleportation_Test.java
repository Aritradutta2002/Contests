package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LC3629_Minimum_Jumps_to_Reach_End_via_Prime_Teleportation_Test {

    @Test
    public void testMinimumJumps() {
        LC3629_Minimum_Jumps_to_Reach_End_via_Prime_Teleportation solver = new LC3629_Minimum_Jumps_to_Reach_End_via_Prime_Teleportation();
        int[] nums = {2, 3, 1, 1, 4};
        assertEquals(1, solver.minimumJumps(nums));
    }
}
