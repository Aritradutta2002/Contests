package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC2200_Find_All_K_Distant_Indices_In_An_Array_Test {

    @Test
    public void testExample1() {
        int[] nums = new int[]{3,4,9,1,3,9,5};
        List<Integer> expected = List.of(1,2,3,4,5,6);
        List<Integer> actual = LC2200_Find_All_K_Distant_Indices_In_An_Array.findKDistantIndices(nums, 9, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample2() {
        int[] nums = new int[]{2,2,2,2,2};
        List<Integer> expected = List.of(0,1,2,3,4);
        List<Integer> actual = LC2200_Find_All_K_Distant_Indices_In_An_Array.findKDistantIndices(nums, 2, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void testEdgeCases() {
        assertEquals(List.of(0), LC2200_Find_All_K_Distant_Indices_In_An_Array.findKDistantIndices(
            new int[]{7}, 7, 1), "single element is its own match");
        assertEquals(List.of(0, 1), LC2200_Find_All_K_Distant_Indices_In_An_Array.findKDistantIndices(
            new int[]{1, 2}, 1, 1), "window is clipped at the right edge");
        assertEquals(List.of(1, 2, 3), LC2200_Find_All_K_Distant_Indices_In_An_Array.findKDistantIndices(
            new int[]{1, 2, 3, 4}, 3, 1), "window sits in the middle");
        assertEquals(List.of(0, 1, 2, 3, 4), LC2200_Find_All_K_Distant_Indices_In_An_Array.findKDistantIndices(
            new int[]{5, 1, 1, 1, 5}, 5, 4), "overlapping windows are merged, not duplicated");
        assertEquals(List.of(0, 1, 3, 4), LC2200_Find_All_K_Distant_Indices_In_An_Array.findKDistantIndices(
            new int[]{6, 1, 1, 1, 6}, 6, 1), "disjoint windows leave a gap");
    }

    /* The sweep must agree with the definition checked pair by pair, and stay sorted. */
    @Test
    public void testMatchesBruteForceOnRandomInput() {
        Random random = new Random(42);
        for (int iteration = 0; iteration < 500; iteration++) {
            int n = 1 + random.nextInt(20);
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = 1 + random.nextInt(4);
            }
            int key = 1 + random.nextInt(4);
            int k = 1 + random.nextInt(n);

            String label = "nums=" + Arrays.toString(nums) + ", key=" + key + ", k=" + k;
            assertEquals(bruteForceIndices(nums, key, k),
                LC2200_Find_All_K_Distant_Indices_In_An_Array.findKDistantIndices(nums, key, k), label);
        }
    }

    /* Oracle: test every (i, j) pair straight from the definition. */
    private List<Integer> bruteForceIndices(int[] nums, int key, int k) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == key && Math.abs(i - j) <= k) {
                    indices.add(i);
                    break;
                }
            }
        }
        return indices;
    }
}
