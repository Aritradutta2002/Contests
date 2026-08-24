package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 *   Author : Aritra
 *   Created On: Tuesday,24.06.2025 08:38 pm
 */

/**
 * 2200. Find All K-Distant Indices in an Array
 *
 * You are given a 0-indexed integer array nums and two integers key and k. A k-distant index is an index i of nums for which there exists at least one index j such that |i - j| <= k and nums[j] == key.
 * Return a list of all k-distant indices sorted in increasing order.
 * Example 1:
 * Input: nums = [3,4,9,1,3,9,5], key = 9, k = 1
 * Output: [1,2,3,4,5,6]
 * Explanation: Here, nums[2] == key and nums[5] == key.
 * - For index 0, |0 - 2| > k and |0 - 5| > k, so there is no j where |0 - j| <= k and nums[j] == key. Thus, 0 is not a k-distant index.
 * - For index 1, |1 - 2| <= k and nums[2] == key, so 1 is a k-distant index.
 * - For index 2, |2 - 2| <= k and nums[2] == key, so 2 is a k-distant index.
 * - For index 3, |3 - 2| <= k and nums[2] == key, so 3 is a k-distant index.
 * - For index 4, |4 - 5| <= k and nums[5] == key, so 4 is a k-distant index.
 * - For index 5, |5 - 5| <= k and nums[5] == key, so 5 is a k-distant index.
 * - For index 6, |6 - 5| <= k and nums[5] == key, so 6 is a k-distant index.
 * Thus, we return [1,2,3,4,5,6] which is sorted in increasing order.
 * Example 2:
 * Input: nums = [2,2,2,2,2], key = 2, k = 2
 * Output: [0,1,2,3,4]
 * Explanation: For all indices i in nums, there exists some index j such that |i - j| <= k and nums[j] == key, so every index is a k-distant index.
 * Hence, we return [0,1,2,3,4].
 * Constraints:
 *  - 1 <= nums.length <= 1000
 *  - 1 <= nums[i] <= 1000
 *  - key is an integer from the array nums.
 *  - 1 <= k <= nums.length
 */
public class LC2200_Find_All_K_Distant_Indices_In_An_Array {
    /*
     * Approach: one left-to-right sweep that emits each window as it is found.
     *
     * Index i qualifies exactly when it falls inside [j - k, j + k] for some j with
     * nums[j] == key, so the answer is the union of one window per occurrence of key. Those
     * windows appear in increasing order as j grows, so remembering the lowest index not emitted
     * yet is enough to merge overlaps on the fly: a window starts at max(next, j - k) and never
     * revisits an index. The result therefore comes out already sorted and duplicate-free,
     * without a set or a sort.
     *
     * Time: O(n), Space: O(1) beyond the returned list.
     */
    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> indices = new ArrayList<>();
        int next = 0;                                   // lowest index not emitted yet
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != key) {
                continue;
            }
            int start = Math.max(next, j - k);
            int end = Math.min(nums.length - 1, j + k);
            for (int i = start; i <= end; i++) {
                indices.add(i);
            }
            next = end + 1;
        }
        return indices;
    }
}
