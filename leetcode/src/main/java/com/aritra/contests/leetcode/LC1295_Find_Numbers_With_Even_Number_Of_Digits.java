package com.aritra.contests.leetcode;
import java.util.*;
public class LC1295_Find_Numbers_With_Even_Number_Of_Digits {
    public static int findNumbers(int[] nums) {
        int count = 0;
        for(int i : nums){
            int len = (int) Math.log10(i) + 1;
            if(len % 2 == 0){
                count++;
            }
        }
        return count;
    }
}

