package com.aritra.contests.leetcode;

import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1140_Stone_Game_II_Test {

    private final LC1140_Stone_Game_II solver = new LC1140_Stone_Game_II();

    @Test
    public void testExample1() {
        int[] param1 = new int[]{2,7,9,4,4};
        int expected = 10;
        int actual = solver.stoneGameII(param1);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample2() {
        int[] param1 = new int[]{1,2,3,4,5,100};
        int expected = 104;
        int actual = solver.stoneGameII(param1);
        assertEquals(expected, actual);
    }
}