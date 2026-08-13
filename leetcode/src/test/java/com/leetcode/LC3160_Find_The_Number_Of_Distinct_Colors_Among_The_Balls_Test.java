package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3160_Find_The_Number_Of_Distinct_Colors_Among_The_Balls_Test {

    @Test
    public void testExample1() {
        int limit = 4;
        int[][] queries = {{1, 4}, {2, 5}, {1, 3}, {3, 4}};
        int[] expected = {1, 2, 2, 3};
        assertArrayEquals(expected, LC3160_Find_The_Number_Of_Distinct_Colors_Among_The_Balls.queryResults(limit, queries));
    }

    @Test
    public void testExample2() {
        int limit = 4;
        int[][] queries = {{0, 1}, {1, 2}, {2, 2}, {3, 4}, {4, 5}};
        int[] expected = {1, 2, 2, 3, 4};
        assertArrayEquals(expected, LC3160_Find_The_Number_Of_Distinct_Colors_Among_The_Balls.queryResults(limit, queries));
    }
}
