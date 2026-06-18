package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1922_Count_Good_Numbers_Test {

    @Test
    public void testStandardCase() {
        assertEquals(5, LC1922_Count_Good_Numbers.countGoodNumbers(1));
    }

    @Test
    public void testCaseFour() {
        assertEquals(400, LC1922_Count_Good_Numbers.countGoodNumbers(4));
    }

    @Test
    public void testCaseLarge() {
        assertEquals(564908303, LC1922_Count_Good_Numbers.countGoodNumbers(50));
    }
}
