package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1722_Minimize_Hamming_Distance_After_Swap_Operations_Test {

    @Test
    public void testMinimumHammingDistanceExample1() {
        LC1722_Minimize_Hamming_Distance_After_Swap_Operations solver = new LC1722_Minimize_Hamming_Distance_After_Swap_Operations();
        int[] source = {1, 2, 3, 4};
        int[] target = {2, 1, 4, 5};
        int[][] allowedSwaps = {{0, 1}, {2, 3}};
        assertEquals(1, solver.minimumHammingDistance(source, target, allowedSwaps));
    }
}
