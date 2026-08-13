package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC62_Unique_Paths_Test {

    @Test
    public void test3x7() {
        assertEquals(28, LC62_Unique_Paths.uniquePaths(3, 7));
    }

    @Test
    public void test3x2() {
        assertEquals(3, LC62_Unique_Paths.uniquePaths(3, 2));
    }

    @Test
    public void test1x1() {
        assertEquals(1, LC62_Unique_Paths.uniquePaths(1, 1));
    }
}
