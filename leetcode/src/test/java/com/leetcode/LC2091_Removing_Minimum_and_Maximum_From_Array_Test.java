package com.leetcode;

import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2091_Removing_Minimum_and_Maximum_From_Array_Test {

    private final LC2091_Removing_Minimum_and_Maximum_From_Array solver = new LC2091_Removing_Minimum_and_Maximum_From_Array();

    @Test
    public void testExample1() {
        int[] param1 = new int[]{2,10,7,5,4,1,8,6};
        int expected = 5;
        int actual = solver.minimumDeletions(param1);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample2() {
        int[] param1 = new int[]{0,-4,19,1,8,-2,-3,5};
        int expected = 3;
        int actual = solver.minimumDeletions(param1);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample3() {
        int[] param1 = new int[]{101};
        int expected = 1;
        int actual = solver.minimumDeletions(param1);
        assertEquals(expected, actual);
    }
}