package com.leetcode;

import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3622_Check_Divisibility_by_Digit_Sum_and_Product_Test {

    private final LC3622_Check_Divisibility_by_Digit_Sum_and_Product solver = new LC3622_Check_Divisibility_by_Digit_Sum_and_Product();

    @Test
    public void testExample1() {
        int param1 = 99;
        boolean expected = true;
        boolean actual = solver.checkDivisibility(param1);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample2() {
        int param1 = 23;
        boolean expected = false;
        boolean actual = solver.checkDivisibility(param1);
        assertEquals(expected, actual);
    }
}