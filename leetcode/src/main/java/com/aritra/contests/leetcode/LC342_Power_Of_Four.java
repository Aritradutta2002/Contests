package com.aritra.contests.leetcode;

import java.util.*;

/**
 * 342. Power of Four
 * 
 * Problem Statement:
 * Given an integer n, return true if it is a power of four. Otherwise, return false.
 * An integer n is a power of four, if there exists an integer x such that n == 4^x.
 * 
 * Constraints:
 * - -2^31 <= n <= 2^31 - 1
 * 
 * Follow up: Could you solve it without loops/recursion?
 */
public class LC342_Power_Of_Four {
    public boolean isPowerOfFour(int n) {
        if(n == 1) return true;
        if(n <= 0) return false;
        if(n > 0){
            while(n % 4 == 0){
                n = n/4;
            }
        }
        return n == 1;
    }
}
