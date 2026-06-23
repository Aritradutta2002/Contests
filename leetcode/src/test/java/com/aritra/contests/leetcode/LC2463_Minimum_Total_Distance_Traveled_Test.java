package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class LC2463_Minimum_Total_Distance_Traveled_Test {

    @Test
    public void testStandardCase() {
        LC2463_Minimum_Total_Distance_Traveled solver = new LC2463_Minimum_Total_Distance_Traveled();
        List<Integer> robot = Arrays.asList(0,4,6);
        int[][] factory = {{2,2},{6,2}};
        assertEquals(4, solver.minimumTotalDistance(robot, factory));
    }

    @Test
    public void testSimpleCase() {
        LC2463_Minimum_Total_Distance_Traveled solver = new LC2463_Minimum_Total_Distance_Traveled();
        List<Integer> robot = Arrays.asList(1);
        int[][] factory = {{0,1}};
        assertEquals(1, solver.minimumTotalDistance(robot, factory));
    }
}
