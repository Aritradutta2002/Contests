package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1404_Number_Of_Steps_To_Reduce_A_Number_In_Binary_Representation_To_One_Test {

    @Test
    public void testStandardCase() {
        assertEquals(6, LC1404_Number_Of_Steps_To_Reduce_A_Number_In_Binary_Representation_To_One.numSteps("1101"));
    }

    @Test
    public void testCaseTwo() {
        assertEquals(1, LC1404_Number_Of_Steps_To_Reduce_A_Number_In_Binary_Representation_To_One.numSteps("10"));
    }

    @Test
    public void testOnesOnly() {
        assertEquals(0, LC1404_Number_Of_Steps_To_Reduce_A_Number_In_Binary_Representation_To_One.numSteps("1"));
    }
}
