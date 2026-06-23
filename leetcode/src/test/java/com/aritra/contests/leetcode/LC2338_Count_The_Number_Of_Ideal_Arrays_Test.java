package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2338_Count_The_Number_Of_Ideal_Arrays_Test {

    @Test
    public void testIdealArraysExample1() {
        assertEquals(10, LC2338_Count_The_Number_Of_Ideal_Arrays.idealArrays(2, 5));
    }

    @Test
    public void testIdealArraysExample2() {
        assertEquals(11, LC2338_Count_The_Number_Of_Ideal_Arrays.idealArrays(5, 3));
    }

    @Test
    public void testIdealArraysExample3() {
        assertEquals(4, LC2338_Count_The_Number_Of_Ideal_Arrays.idealArrays(3, 2));
    }
}
