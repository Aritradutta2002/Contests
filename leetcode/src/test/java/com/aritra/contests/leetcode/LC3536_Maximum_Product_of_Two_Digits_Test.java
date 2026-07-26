package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC3536_Maximum_Product_of_Two_Digits_Test {

    private final LC3536_Maximum_Product_of_Two_Digits solution = new LC3536_Maximum_Product_of_Two_Digits();

    @Test
    void testExample1() {
        // n = 31, digits [3,1], max product = 3*1 = 3
        assertEquals(3, solution.maxProduct(31));
    }

    @Test
    void testExample2() {
        // n = 22, digits [2,2], max product = 2*2 = 4
        assertEquals(4, solution.maxProduct(22));
    }

    @Test
    void testExample3() {
        // n = 124, digits [1,2,4], max product = 2*4 = 8
        assertEquals(8, solution.maxProduct(124));
    }
}
