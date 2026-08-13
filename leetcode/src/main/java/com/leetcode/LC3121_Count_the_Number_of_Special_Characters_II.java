package com.leetcode;
import java.util.*;
/*
 * 3121. Count the Number of Special Characters II
 *
 * You are given a string word. A letter c is called special if it appears both in lowercase and uppercase in word,
 * and every lowercase occurrence of c appears before the first uppercase occurrence of c.
 * Return the number of special letters in word.
 *
 * Constraints:
 * - 1 <= word.length <= 2 * 10^5
 * - word consists of only lowercase and uppercase English letters.
 */
public class LC3121_Count_the_Number_of_Special_Characters_II {
    public int numberOfSpecialChars(String word) {
        int[] firstUpper = new int[26];
        int[] lastLower = new int[26];
        Arrays.fill(firstUpper, Integer.MAX_VALUE);
        Arrays.fill(lastLower, -1);
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'a' && c <= 'z') {
                lastLower[c - 'a'] = i;
            } else {
                if (firstUpper[c - 'A'] == Integer.MAX_VALUE) {
                    firstUpper[c - 'A'] = i;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (lastLower[i] != -1 && firstUpper[i] != Integer.MAX_VALUE && lastLower[i] < firstUpper[i]) {
                count++;
            }
        }
        return count;
    }
}
