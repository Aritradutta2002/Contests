package com.aritra.contests.leetcode;
import java.util.*;
/*
 * 1967. Number of Strings That Appear as Substrings in Word
 *
 * Given an array of strings patterns and a string word, return the number of
 * strings in patterns that exist as a substring in word. A substring is a
 * contiguous sequence of characters within a string.
 *
 * Constraints:
 * - 1 <= patterns.length <= 100
 * - 1 <= patterns[i].length <= 100
 * - patterns[i] consists of lowercase English letters
 * - 1 <= word.length <= 100
 * - word consists of lowercase English letters
 */
public class LC1967_Number_of_Strings_That_Appear_as_Substrings_in_Word {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for(String s : patterns) {
            if(word.contains(s)) {
                count++;
            }
        }
        return count;
    }
}
