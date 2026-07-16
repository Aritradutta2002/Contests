package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3487_Maximum_Unique_Subarray_Sum_After_Deletion_Test {

    @Test
    public void testExample1() {
        int[] nums = {1, 2, 3, 4, 5};
        assertEquals(15, LC3487_Maximum_Unique_Subarray_Sum_After_Deletion.maxSum(nums));
    }

    @Test
    public void testExample2() {
        int[] nums = {1, 1, 0, 1, 1};
        assertEquals(4, LC3487_Maximum_Unique_Subarray_Sum_After_Deletion.maxSum(nums));
    }

    @Test
    public void testExample3() {
        int[] nums = {1, 2, -1, -2, 1, 0, -1};
        assertEquals(3, LC3487_Maximum_Unique_Subarray_Sum_After_Deletion.maxSum(nums));
    }
}
