package com.leetcode;

import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3718_Smallest_Missing_Multiple_of_K_Test {

    private final LC3718_Smallest_Missing_Multiple_of_K solver = new LC3718_Smallest_Missing_Multiple_of_K();

    @Test
    public void testExample1() {
        int[] param1 = new int[]{8,2,3,4,6};
        int param2 = 2;
        int expected = 10;
        int actual = solver.missingMultiple(param1, param2);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample2() {
        int[] param1 = new int[]{1,4,7,10,15};
        int param2 = 5;
        int expected = 5;
        int actual = solver.missingMultiple(param1, param2);
        assertEquals(expected, actual);
    }

    @Test
    public void testEdgeCase_AllMultipesPresent_k1() {
        // nums contains every value 1..100; smallest missing multiple of 1 is 101
        int[] nums = new int[100];
        for (int i = 0; i < 100; i++) nums[i] = i + 1;
        int expected = 101;
        int actual = solver.missingMultiple(nums, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void testEdgeCase_AllMultipesPresent_k5() {
        // all multiples of 5 up to 100 are present, plus other values; answer is 105
        int[] nums = new int[100];
        for (int i = 0; i < 100; i++) nums[i] = i + 1;
        int expected = 105;
        int actual = solver.missingMultiple(nums, 5);
        assertEquals(expected, actual);
    }
}