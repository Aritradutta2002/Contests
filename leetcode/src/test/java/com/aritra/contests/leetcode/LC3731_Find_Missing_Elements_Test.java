package com.aritra.contests.leetcode;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3731_Find_Missing_Elements_Test {

    private final LC3731_Find_Missing_Elements solver = new LC3731_Find_Missing_Elements();

    @Test
    public void testExample1() {
        int[] nums = {1, 4, 2, 5};
        assertEquals(List.of(3), solver.findMissingElements(nums));
    }

    @Test
    public void testExample2() {
        int[] nums = {7, 8, 6, 9};
        assertEquals(List.of(), solver.findMissingElements(nums));
    }

    @Test
    public void testExample3() {
        int[] nums = {5, 1};
        assertEquals(List.of(2, 3, 4), solver.findMissingElements(nums));
    }
}