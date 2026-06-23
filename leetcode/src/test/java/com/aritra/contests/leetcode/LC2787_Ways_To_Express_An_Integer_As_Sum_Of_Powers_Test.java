package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2787_Ways_To_Express_An_Integer_As_Sum_Of_Powers_Test {

    @Test
    public void testNumberOfWaysExample1() {
        assertEquals(1, LC2787_Ways_To_Express_An_Integer_As_Sum_Of_Powers.numberOfWays(10, 2));
    }

    @Test
    public void testNumberOfWaysExample2() {
        assertEquals(2, LC2787_Ways_To_Express_An_Integer_As_Sum_Of_Powers.numberOfWays(4, 1));
    }

    @Test
    public void testNumberOfWaysExample3() {
        assertEquals(1, LC2787_Ways_To_Express_An_Integer_As_Sum_Of_Powers.numberOfWays(1, 1));
    }
}
