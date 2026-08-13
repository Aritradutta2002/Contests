package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2078_Two_Furthest_Houses_With_Different_Colors_Test {

    @Test
    public void testStandardCase() {
        LC2078_Two_Furthest_Houses_With_Different_Colors solver = new LC2078_Two_Furthest_Houses_With_Different_Colors();
        int[] colors = {1,1,1,6,1,1,1};
        assertEquals(3, solver.maxDistance(colors));
    }

    @Test
    public void testCaseTwo() {
        LC2078_Two_Furthest_Houses_With_Different_Colors solver = new LC2078_Two_Furthest_Houses_With_Different_Colors();
        int[] colors = {0,1};
        assertEquals(1, solver.maxDistance(colors));
    }
}
