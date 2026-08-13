package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2833_Furthest_Point_From_Origin_Test {

    @Test
    public void testStandardCase() {
        LC2833_Furthest_Point_From_Origin solver = new LC2833_Furthest_Point_From_Origin();
        assertEquals(3, solver.furthestDistanceFromOrigin("L_RL__R"));
    }

    @Test
    public void testAllUnderscore() {
        LC2833_Furthest_Point_From_Origin solver = new LC2833_Furthest_Point_From_Origin();
        assertEquals(5, solver.furthestDistanceFromOrigin("_____"));
    }
}
