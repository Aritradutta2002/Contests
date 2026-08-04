package com.aritra.contests.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class LC1464_Maximum_Product_of_Two_Elements_in_an_Array_Test {

    /**
     * Validates the first LeetCode example: [3,4,5,2] -> 12.
     */
    @Test
    void testExample1() {
        Lc1464_Maximum_Product_of_Two_Elements_in_an_Array solution = new Lc1464_Maximum_Product_of_Two_Elements_in_an_Array();
        int[] nums = {3, 4, 5, 2};
        assertEquals(12, solution.maxProduct(nums));
    }

    /**
     * Validates the second LeetCode example: [1,5,4,5] -> 16.
     */
    @Test
    void testExample2() {
        Lc1464_Maximum_Product_of_Two_Elements_in_an_Array solution = new Lc1464_Maximum_Product_of_Two_Elements_in_an_Array();
        int[] nums = {1, 5, 4, 5};
        assertEquals(16, solution.maxProduct(nums));
    }

    /**
     * Validates the third LeetCode example: [3,7] -> 12.
     */
    @Test
    void testExample3() {
        Lc1464_Maximum_Product_of_Two_Elements_in_an_Array solution = new Lc1464_Maximum_Product_of_Two_Elements_in_an_Array();
        int[] nums = {3, 7};
        assertEquals(12, solution.maxProduct(nums));
    }
}
