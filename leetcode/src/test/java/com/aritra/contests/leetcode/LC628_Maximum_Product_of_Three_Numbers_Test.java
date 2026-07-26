package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC628_Maximum_Product_of_Three_Numbers_Test {

    @Test
    public void testExample1_SmallPositiveArray() {
        LC628_Maximum_Product_of_Three_Numbers sol = new LC628_Maximum_Product_of_Three_Numbers();
        int[] nums = {1, 2, 3};
        int expected = 6;
        assertEquals(expected, sol.maximumProduct(nums),
            "[1,2,3] -> product of all three is 6");
    }

    @Test
    public void testExample2_FourPositiveNumbers() {
        LC628_Maximum_Product_of_Three_Numbers sol = new LC628_Maximum_Product_of_Three_Numbers();
        int[] nums = {1, 2, 3, 4};
        int expected = 24;
        assertEquals(expected, sol.maximumProduct(nums),
            "[1,2,3,4] -> 2*3*4 = 24");
    }

    @Test
    public void testExample3_AllNegative() {
        LC628_Maximum_Product_of_Three_Numbers sol = new LC628_Maximum_Product_of_Three_Numbers();
        int[] nums = {-1, -2, -3};
        int expected = -6;
        assertEquals(expected, sol.maximumProduct(nums),
            "[-1,-2,-3] -> (-1)*(-2)*(-3) = -6");
    }
}
