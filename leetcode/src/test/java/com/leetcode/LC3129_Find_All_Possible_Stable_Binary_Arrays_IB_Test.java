package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3129_Find_All_Possible_Stable_Binary_Arrays_IB_Test {

    @Test
    public void testNumberOfStableArraysExample1() {
        LC3129_Find_All_Possible_Stable_Binary_Arrays_IB solver = new LC3129_Find_All_Possible_Stable_Binary_Arrays_IB();
        assertEquals(2, solver.numberOfStableArrays(1, 1, 2));
    }

    @Test
    public void testNumberOfStableArraysExample2() {
        LC3129_Find_All_Possible_Stable_Binary_Arrays_IB solver = new LC3129_Find_All_Possible_Stable_Binary_Arrays_IB();
        assertEquals(1, solver.numberOfStableArrays(1, 2, 1));
    }

    @Test
    public void testNumberOfStableArraysExample3() {
        LC3129_Find_All_Possible_Stable_Binary_Arrays_IB solver = new LC3129_Find_All_Possible_Stable_Binary_Arrays_IB();
        assertEquals(14, solver.numberOfStableArrays(3, 3, 2));
    }
}
