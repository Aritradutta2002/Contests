package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2657_Find_The_Prefix_Common_Array_Of_Two_Arrays_Test {

    @Test
    public void testStandardCase() {
        LC2657_Find_The_Prefix_Common_Array_Of_Two_Arrays solver = new LC2657_Find_The_Prefix_Common_Array_Of_Two_Arrays();
        int[] A = {1,3,2,4};
        int[] B = {3,1,2,4};
        int[] expected = {0,2,3,4};
        assertArrayEquals(expected, solver.findThePrefixCommonArray(A, B));
    }

    @Test
    public void testSimpleCase() {
        LC2657_Find_The_Prefix_Common_Array_Of_Two_Arrays solver = new LC2657_Find_The_Prefix_Common_Array_Of_Two_Arrays();
        int[] A = {2,3,1};
        int[] B = {3,1,2};
        int[] expected = {0,1,3};
        assertArrayEquals(expected, solver.findThePrefixCommonArray(A, B));
    }
}
