package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC75_Sort_Colors_Test {

    @Test
    public void testMixedColors() {
        int[] nums = {2, 0, 2, 1, 1, 0};
        LC75_Sort_Colors.sortColors(nums);
        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, nums);
    }

    @Test
    public void testAllSame() {
        int[] nums = {2, 2, 2};
        LC75_Sort_Colors.sortColors(nums);
        assertArrayEquals(new int[]{2, 2, 2}, nums);
    }

    @Test
    public void testEmptyArray() {
        int[] nums = {};
        LC75_Sort_Colors.sortColors(nums);
        assertArrayEquals(new int[]{}, nums);
    }
}
