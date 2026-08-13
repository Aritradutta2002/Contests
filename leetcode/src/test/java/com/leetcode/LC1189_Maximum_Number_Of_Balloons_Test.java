package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1189_Maximum_Number_Of_Balloons_Test {

    @Test
    public void testExample1() {
        // Example 1: "nlaebolko" -> 1
        // Contains: n, l, a, e, b, o, l, k, o
        // Can form "balloon" once (b, a, l, l, o, o, n)
        assertEquals(1, LC1189_Maximum_Number_Of_Balloons.maxNumberOfBalloons("nlaebolko"));
    }

    @Test
    public void testExample2() {
        // Example 2: "loonbalxballpoon" -> 2
        // Contains sufficient characters for 2 instances of "balloon"
        assertEquals(2, LC1189_Maximum_Number_Of_Balloons.maxNumberOfBalloons("loonbalxballpoon"));
    }

    @Test
    public void testExample3() {
        // Example 3: "leetcode" -> 0
        // Missing required characters (no 'b', insufficient 'l' and 'o')
        assertEquals(0, LC1189_Maximum_Number_Of_Balloons.maxNumberOfBalloons("leetcode"));
    }
}
