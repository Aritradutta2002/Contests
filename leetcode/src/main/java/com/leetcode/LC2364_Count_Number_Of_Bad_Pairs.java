package com.leetcode;
import java.util.*;
/* 
    Bad Pair will be called if 
    i) i < j
    ii) (j  - i) != (nums[j] - nums[i])
 */
public class LC2364_Count_Number_Of_Bad_Pairs {
    public static long countBadPairs(int[] nums) {
        int n = nums.length;
        long totalPairs = (long) n * (n - 1) / 2;
        long goodPairs = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int curr = (nums[i] - i);

            if (map.containsKey(curr)) {
                goodPairs += map.get(curr);
            }
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        long badPairs = totalPairs - goodPairs;
        return badPairs;
    }
}
