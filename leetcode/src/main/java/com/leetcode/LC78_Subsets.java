package com.leetcode;
/*
 * Author  : Aritra Dutta
 * Target  : Codeforces Expert / CSES
 * Created : 22.02.2026 01:48
 */
import java.util.*;

public class LC78_Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        backtrack(nums, 0, new ArrayList<>(), ans);

        return ans;
    }
    public static void backtrack(int[] nums, int start, List<Integer> curr, List<List<Integer>> ans){

        ans.add(new ArrayList<>(curr));
        for(int i= start; i < nums.length; i++){
            if(i > start) continue;

            curr.add(nums[i]);
            backtrack(nums, i+1, curr, ans);
            curr.remove(curr.size() - 1);
            
        }
    }
}
