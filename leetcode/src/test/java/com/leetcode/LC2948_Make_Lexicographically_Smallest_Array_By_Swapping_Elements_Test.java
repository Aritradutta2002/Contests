package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2948_Make_Lexicographically_Smallest_Array_By_Swapping_Elements_Test {

    @Test
    public void testLexicographicallySmallestArrayExample1() {
        int[] nums = {1, 5, 3, 9, 8};
        int limit = 2;
        int[] expected = {1, 3, 5, 8, 9};
        assertArrayEquals(expected, LC2948_Make_Lexicographically_Smallest_Array_By_Swapping_Elements.lexicographicallySmallestArray(nums, limit));
    }

    @Test
    public void testLexicographicallySmallestArrayExample2() {
        int[] nums = {1, 7, 6, 18, 2, 1};
        int limit = 3;
        int[] expected = {1, 6, 7, 18, 1, 2};
        assertArrayEquals(expected, LC2948_Make_Lexicographically_Smallest_Array_By_Swapping_Elements.lexicographicallySmallestArray(nums, limit));
    }

    @Test
    public void testLexicographicallySmallestArrayExample3() {
        int[] nums = {1, 7, 28, 19, 10};
        int limit = 3;
        int[] expected = {1, 7, 28, 19, 10};
        assertArrayEquals(expected, LC2948_Make_Lexicographically_Smallest_Array_By_Swapping_Elements.lexicographicallySmallestArray(nums, limit));
    }
}
