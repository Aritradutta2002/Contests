package com.aritra.contests.leetcode;
import java.util.*;
import java.io.*;

/**
 * 3016. Minimum Number of Pushes to Type Word II
 *
 * You are given a string word containing lowercase English letters.
 * 
 * Telephone keypads have keys mapped with distinct collections of lowercase English letters, which can be used to form words by pushing them. For example, the key 2 is mapped with ["a","b","c"], we need to push the key one time to type "a", two times to type "b", and three times to type "c" .
 * 
 * It is allowed to remap the keys numbered 2 to 9 to distinct collections of letters. The keys can be remapped to any amount of letters, but each letter must be mapped to exactly one key. You need to find the minimum number of times the keys will be pushed to type the string word.
 * 
 * Return the minimum number of pushes needed to type word after remapping the keys.
 * 
 * An example mapping of letters to keys on a telephone keypad is given below. Note that 1, *, #, and 0 do not map to any letters.
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: word = "abcde"
 * Output: 5
 * Explanation: The remapped keypad given in the image provides the minimum cost.
 * "a" -> one push on key 2
 * "b" -> one push on key 3
 * "c" -> one push on key 4
 * ...
 */
public class LC3016_Minimum_Number_of_Pushes_to_Type_Word_II {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        int pushes = 0;
        for (int i = 25; i >= 0 && freq[i] > 0; i--) {
            int position = 25 - i;
            pushes += freq[i] * (position / 8 + 1);
        }
        return pushes;
    }
}