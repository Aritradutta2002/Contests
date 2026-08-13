package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3043_Find_the_Length_of_the_Longest_Common_Prefix_Test {

    @Test
    public void testStandardCase() {
        LC3043_Find_the_Length_of_the_Longest_Common_Prefix solver = new LC3043_Find_the_Length_of_the_Longest_Common_Prefix();
        int[] arr1 = {1,10,100};
        int[] arr2 = {1000};
        assertEquals(3, solver.longestCommonPrefix(arr1, arr2));
    }

    @Test
    public void testNoCommonPrefix() {
        LC3043_Find_the_Length_of_the_Longest_Common_Prefix solver = new LC3043_Find_the_Length_of_the_Longest_Common_Prefix();
        int[] arr1 = {1,2,3};
        int[] arr2 = {4,5,6};
        assertEquals(0, solver.longestCommonPrefix(arr1, arr2));
    }
}
