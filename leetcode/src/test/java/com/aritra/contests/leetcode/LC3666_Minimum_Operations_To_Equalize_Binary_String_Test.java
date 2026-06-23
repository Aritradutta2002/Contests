package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3666_Minimum_Operations_To_Equalize_Binary_String_Test {

    @Test
    public void testExample1() {
        LC3666_Minimum_Operations_To_Equalize_Binary_String solver = new LC3666_Minimum_Operations_To_Equalize_Binary_String();
        assertEquals(-1, solver.minOperations("101", 2));
    }

    @Test
    public void testExample2() {
        LC3666_Minimum_Operations_To_Equalize_Binary_String solver = new LC3666_Minimum_Operations_To_Equalize_Binary_String();
        assertEquals(1, solver.minOperations("1010", 2));
    }

    @Test
    public void testAllOnes() {
        LC3666_Minimum_Operations_To_Equalize_Binary_String solver = new LC3666_Minimum_Operations_To_Equalize_Binary_String();
        assertEquals(0, solver.minOperations("111", 1));
    }
}
