package com.aritra.contests.leetcode;
import java.util.*;
/*
 * 1461. Check If a String Contains All Binary Codes of Size K
 *
 * Given a binary string s and an integer k, return true if every binary code of length k occurs
 * as a substring of s. Otherwise, return false.
 *
 * Constraints:
 * - 1 <= s.length <= 5 * 10^5
 * - s consists of '0' and '1' only
 * - 1 <= k <= 20
 */
public class LC1461_Check_If_A_String_Contains_All_Binary_Codes_Of_Size_K {
    public static boolean hasAllCodes(String s, int k) {
        if (k > s.length()) {
            return false;
        }
        int totalCodes = 1 << k;   // same as Math.pow(2, k) but better 
        boolean[] seen = new boolean[totalCodes];
        int mask = totalCodes - 1;
        int rolling = 0;
        int seenCount = 0;

        for (int i = 0; i < s.length(); i++) {
            rolling = ((rolling << 1) & mask) | (s.charAt(i) - '0');
            if (i >= k - 1 && !seen[rolling]) {
                seen[rolling] = true;
                seenCount++;
                if (seenCount == totalCodes) {
                    return true;
                }
            }
        }
        return false;
    }
}
