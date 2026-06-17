package com.aritra.contests.leetcode;
import java.util.*;
/**
 * 1722. Minimize Hamming Distance After Swap Operations
 * 
 * You are given two integer arrays, source and target, both of length n.
 * You are also given an array allowedSwaps where each allowedSwaps[i] = [ai, bi]
 * indicates that you are allowed to swap the elements at index ai and index bi
 * (0-indexed) of array source. Note that you can swap elements at a specific pair
 * of indices multiple times and in any order.
 * 
 * The Hamming distance of two arrays of the same length, source and target, is
 * the number of positions where the elements are different. Formally, it is the
 * number of indices i for 0 <= i <= n-1 where source[i] != target[i] (0-indexed).
 * 
 * Return the minimum Hamming distance of source and target after performing any
 * amount of swap operations on array source.
 * 
 * Example 1:
 * Input: source = [1,2,3,4], target = [2,1,4,5], allowedSwaps = [[0,1],[2,3]]
 * Output: 1
 * 
 * Constraints:
 * n == source.length == target.length
 * 1 <= n <= 10^5
 * 1 <= source[i], target[i] <= 10^5
 * 0 <= allowedSwaps.length <= 10^5
 * allowedSwaps[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 */
public class LC1722_Minimize_Hamming_Distance_After_Swap_Operations {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        return 0;
    }
}
