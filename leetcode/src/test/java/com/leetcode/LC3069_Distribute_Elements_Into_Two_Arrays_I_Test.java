package com.leetcode;

import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3069_Distribute_Elements_Into_Two_Arrays_I_Test {

    private final LC3069_Distribute_Elements_Into_Two_Arrays_I solver = new LC3069_Distribute_Elements_Into_Two_Arrays_I();

    @Test
    public void testExample1() {
        int[] param1 = new int[]{2,1,3};
        int[] expected = new int[]{2,3,1};
        int[] actual = solver.resultArray(param1);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testExample2() {
        int[] param1 = new int[]{5,4,3,8};
        int[] expected = new int[]{5,3,4,8};
        int[] actual = solver.resultArray(param1);
        assertArrayEquals(expected, actual);
    }
}