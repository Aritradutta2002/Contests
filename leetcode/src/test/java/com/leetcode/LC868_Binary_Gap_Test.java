package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC868_Binary_Gap_Test {

    @Test
    public void testBinaryGapExample1() {
        assertEquals(2, LC868_Binary_Gap.binaryGap(22));
    }

    @Test
    public void testBinaryGapExample2() {
        assertEquals(0, LC868_Binary_Gap.binaryGap(8));
    }

    @Test
    public void testBinaryGapExample3() {
        assertEquals(2, LC868_Binary_Gap.binaryGap(5));
    }

    @Test
    public void testBinaryGapNoGap() {
        assertEquals(0, LC868_Binary_Gap.binaryGap(1));
    }
}
