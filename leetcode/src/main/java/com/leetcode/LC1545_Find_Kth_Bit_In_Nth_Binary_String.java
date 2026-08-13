package com.leetcode;
import java.util.*;

/*
 * 1545. Find Kth Bit in Nth Binary String
 *
 * Given two positive integers n and k, the binary string Sn is formed as: S1 = "0", then
 * Si = Si-1 + "1" + reverse(invert(Si-1)). Return the kth bit (1-indexed) in Sn.
 *
 * Constraints:
 * - 1 <= n <= 20
 * - 1 <= k <= 2^n - 1
 */
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
