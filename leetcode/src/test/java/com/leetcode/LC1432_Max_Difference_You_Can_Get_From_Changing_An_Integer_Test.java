package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1432_Max_Difference_You_Can_Get_From_Changing_An_Integer_Test {

    @Test
    public void testStandardCase() {
        assertEquals(888, LC1432_Max_Difference_You_Can_Get_From_Changing_An_Integer.maxDiff(555));
    }

    @Test
    public void testCaseNine() {
        assertEquals(8, LC1432_Max_Difference_You_Can_Get_From_Changing_An_Integer.maxDiff(9));
    }

    @Test
    public void testLargeNumber() {
        assertEquals(820000, LC1432_Max_Difference_You_Can_Get_From_Changing_An_Integer.maxDiff(123456));
    }
}
