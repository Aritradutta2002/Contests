package com.leetcode;
import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3471_Find_the_Largest_Almost_Missing_Integer_Test {

    private final LC3471_Find_the_Largest_Almost_Missing_Integer solver = new LC3471_Find_the_Largest_Almost_Missing_Integer();

    @Test
    public void testExample1() {
        int[] param1 = new int[]{3,9,2,1,7};
        int param2 = 3;
        int expected = 7;
        int actual = solver.largestInteger(param1, param2);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample2() {
        int[] param1 = new int[]{3,9,7,2,1,7};
        int param2 = 4;
        int expected = 3;
        int actual = solver.largestInteger(param1, param2);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample3() {
        int[] param1 = new int[]{0,0};
        int param2 = 1;
        int expected = -1;
        int actual = solver.largestInteger(param1, param2);
        assertEquals(expected, actual);
    }
}