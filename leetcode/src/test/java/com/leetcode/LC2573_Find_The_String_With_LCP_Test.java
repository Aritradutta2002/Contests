package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2573_Find_The_String_With_LCP_Test {

    @Test
    public void testFindTheStringExample1() {
        LC2573_Find_The_String_With_LCP solver = new LC2573_Find_The_String_With_LCP();
        int[][] lcp = {{4, 0, 2, 0}, {0, 3, 0, 1}, {2, 0, 2, 0}, {0, 1, 0, 1}};
        String result = solver.findTheString(lcp);
        assertNotNull(result);
    }
}
