package com.leetcode;

import java.util.*;

/**
 * 3120. Count the Number of Special Characters I
 *
 * You are given a string word. A letter is called special if it appears
 * in both lowercase and uppercase in word.
 * Return the number of special letters.
 *
 * Constraints:
 * - 1 <= word.length <= 50
 * - word consists of only lowercase and uppercase English letters.
 */
public class LC3120_Count_The_Number_Of_Special_Characters_I {
    public static int numberOfSpecialChars(String word) {
                Set<Character> set = new HashSet<>();
                for (int i = 0; i < word.length(); i++) {
                        set.add(word.charAt(i));
                }

                int count = 0;
                for (char c : set) {
                        if (Character.isLowerCase(c)) {
                                char upper = Character.toUpperCase(c);
                                if (set.contains(upper)) {
                                        count++;
                                }
                        }
                }
                return count;
        }}
