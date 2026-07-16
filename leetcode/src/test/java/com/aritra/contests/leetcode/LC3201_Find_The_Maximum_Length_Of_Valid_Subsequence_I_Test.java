package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3201_Find_The_Maximum_Length_Of_Valid_Subsequence_I_Test {

    @Test
    public void testExample1() {
        int[] nums = {1, 2, 3, 4};
        assertEquals(4, LC3201_Find_The_Maximum_Length_Of_Valid_Subsequence_I.maximumLength(nums));
    }

    @Test
    public void testExample2() {
        int[] nums = {1, 2, 1, 1, 2, 1, 2};
        assertEquals(6, LC3201_Find_The_Maximum_Length_Of_Valid_Subsequence_I.maximumLength(nums));
    }

    @Test
    public void testExample3() {
        int[] nums = {1, 3};
        assertEquals(2, LC3201_Find_The_Maximum_Length_Of_Valid_Subsequence_I.maximumLength(nums));
    }
}
