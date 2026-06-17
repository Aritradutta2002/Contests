package com.aritra.contests.leetcode;
import java.util.*;

public class LC1545_Find_Kth_Bit_In_Nth_Binary_String {
    public char findKthBit(int n, int k) {
        if (n == 1) return '0';
        int len = (1 << n) - 1;
        int mid = 1 << (n - 1);
        
        if (k == mid) return '1';
        
        if (k < mid) {
            return findKthBit(n - 1, k);
        } 
        else {
            int newK = len - k + 1;
            char bit = findKthBit(n - 1, newK);
            return bit == '0' ? '1' : '0';
        }
    }
}
