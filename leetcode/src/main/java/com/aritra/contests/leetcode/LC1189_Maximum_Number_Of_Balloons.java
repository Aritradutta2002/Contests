package com.aritra.contests.leetcode;
import java.util.*;
/*
 * LeetCode Problem 1189 - Maximum Number of Balloons
 *
 * Given a string, determine how many times the word "balloon" can be formed
 * using its characters, with each character used at most once.
 *
 * Key constraints:
 * - 1 <= text.length <= 10^4
 * - text consists of lowercase English letters only
 */
public class LC1189_Maximum_Number_Of_Balloons {
    public static int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        for(char c : text.toCharArray()){
           freq[c - 'a']++;
        }
       return Math.min(freq[0], Math.min(freq[1], Math.min(freq[11] / 2, Math.min(freq[14] / 2, freq[13]))));
    }
}
