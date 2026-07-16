package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1888_Minimum_Number_Of_Flips_To_Make_The_Binary_String_Alternating_B_Test {

    @Test
    public void testMinFlipsExample1() {
        LC1888_Minimum_Number_Of_Flips_To_Make_The_Binary_String_Alternating_B solver = new LC1888_Minimum_Number_Of_Flips_To_Make_The_Binary_String_Alternating_B();
        assertEquals(2, solver.minFlips("111000"));
    }

    @Test
    public void testMinFlipsExample2() {
        LC1888_Minimum_Number_Of_Flips_To_Make_The_Binary_String_Alternating_B solver = new LC1888_Minimum_Number_Of_Flips_To_Make_The_Binary_String_Alternating_B();
        assertEquals(0, solver.minFlips("010"));
    }

    @Test
    public void testMinFlipsExample3() {
        LC1888_Minimum_Number_Of_Flips_To_Make_The_Binary_String_Alternating_B solver = new LC1888_Minimum_Number_Of_Flips_To_Make_The_Binary_String_Alternating_B();
        assertEquals(1, solver.minFlips("1110"));
    }
}
