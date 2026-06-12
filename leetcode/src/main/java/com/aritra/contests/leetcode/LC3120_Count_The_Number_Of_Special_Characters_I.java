package com.aritra.contests.leetcode;

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
        }

        public static void main(String[] args) {
                // Test case 1: a/A, b/B, c/C all present -> 3
                String word1 = "aaAbcBC";
                int expected1 = 3;
                try {
                        int result1 = numberOfSpecialChars(word1);
                        System.out.println(
                                        "Test 1: " +
                                                        (result1 == expected1 ? "Pass" : "Fail") +
                                                        " (expected=" +
                                                        expected1 +
                                                        ", got=" +
                                                        result1 +
                                                        ")");
                } catch (UnsupportedOperationException e) {
                        System.out.println(
                                        "Test 1: Not implemented (expected=" + expected1 + ")");
                }

                // Test case 2: no uppercase letters -> 0
                String word2 = "abc";
                int expected2 = 0;
                try {
                        int result2 = numberOfSpecialChars(word2);
                        System.out.println(
                                        "Test 2: " +
                                                        (result2 == expected2 ? "Pass" : "Fail") +
                                                        " (expected=" +
                                                        expected2 +
                                                        ", got=" +
                                                        result2 +
                                                        ")");
                } catch (UnsupportedOperationException e) {
                        System.out.println(
                                        "Test 2: Not implemented (expected=" + expected2 + ")");
                }

                // Test case 3: only c/C and b/B are special -> 2
                String word3 = "cCacBb";
                int expected3 = 2;
                try {
                        int result3 = numberOfSpecialChars(word3);
                        System.out.println(
                                        "Test 3: " +
                                                        (result3 == expected3 ? "Pass" : "Fail") +
                                                        " (expected=" +
                                                        expected3 +
                                                        ", got=" +
                                                        result3 +
                                                        ")");
                } catch (UnsupportedOperationException e) {
                        System.out.println(
                                        "Test 3: Not implemented (expected=" + expected3 + ")");
                }
        }
}
