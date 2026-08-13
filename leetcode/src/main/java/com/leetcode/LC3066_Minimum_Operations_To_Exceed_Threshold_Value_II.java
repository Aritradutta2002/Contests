package com.leetcode;
import java.util.*;
@SuppressWarnings("unused")

/*
 * 3066. Minimum Operations to Exceed Threshold Value II
 *
 * Repeatedly take the two smallest numbers from nums, remove them, and add (min * 2 + max) back.
 * Count the number of operations until all elements are >= k.
 *
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - 1 <= nums[i] <= 10^9
 * - 1 <= k <= 10^9
 */
public class LC3066_Minimum_Operations_To_Exceed_Threshold_Value_II {
    static public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int count = 0;

        for (int num : nums) {
            pq.offer((long) num);
        }

        while (pq.size() > 1 && pq.peek() < k) {
            count++;
            
            long first = pq.poll();
            long second = pq.poll();
            pq.offer((long) Math.max(first, second) + 2 * Math.min(first, second));
        }

        if (pq.peek() >= k) {
            return count;
        } else {
            return -1;
        }
    }
}
