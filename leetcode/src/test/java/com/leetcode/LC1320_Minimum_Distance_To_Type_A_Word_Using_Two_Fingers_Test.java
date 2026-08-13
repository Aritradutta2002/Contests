package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1320_Minimum_Distance_To_Type_A_Word_Using_Two_Fingers_Test {

    @Test
    public void testStandardCase() {
        LC1320_Minimum_Distance_To_Type_A_Word_Using_Two_Fingers solver = new LC1320_Minimum_Distance_To_Type_A_Word_Using_Two_Fingers();
        assertEquals(3, solver.minimumDistance("CAKE"));
    }

    @Test
    public void testCaseTwo() {
        LC1320_Minimum_Distance_To_Type_A_Word_Using_Two_Fingers solver = new LC1320_Minimum_Distance_To_Type_A_Word_Using_Two_Fingers();
        assertEquals(6, solver.minimumDistance("HAPPY"));
    }
}
