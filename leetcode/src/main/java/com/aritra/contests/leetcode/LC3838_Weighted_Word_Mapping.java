package com.aritra.contests.leetcode;

import java.util.*;
import java.io.*;

/**
 * 3838. Weighted Word Mapping
 *
 * You are given an array of strings words and an integer array weights of length 26,
 * where weights[i] represents the weight of the i-th lowercase English letter.
 *
 * The weight of a word is defined as the sum of the weights of its characters.
 * For each word, calculate its total weight, take the result modulo 26, and map it
 * to a lowercase English letter using reverse alphabetical order (0 -> 'z', 1 -> 'y', ..., 25 -> 'a').
 * Return a string formed by concatenating the mapped characters for all words in the order they appear.
 *
 * Constraints:
 * - 1 <= words.length <= 100
 * - 1 <= words[i].length <= 10
 * - weights.length == 26
 * - 1 <= weights[i] <= 100
 * - words[i] consists of lowercase English letters.
 */
public class LC3838_Weighted_Word_Mapping {

    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder str = new StringBuilder();
        for(String word : words){
        	int s = 0;
        	for(int i = 0; i < word.length(); i++) {
        		s += weights[word.charAt(i) - 'a'];
        	}
        	str.append((char) ('z' - (s % 26)));
        }
        return str.toString();
    }

    public static void main(String[] args) {
        LC3838_Weighted_Word_Mapping solver = new LC3838_Weighted_Word_Mapping();

        // Test case 1: Standard example with multiple words of various lengths
        // Input: words = ["abcd", "def", "xyz"], weights = [5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2]
        // Expected Output: "rij"
        String[] words1 = {"abcd", "def", "xyz"};
        int[] weights1 = {5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2};
        String expected1 = "rij";
        try {
            String result1 = solver.mapWordWeights(words1, weights1);
            System.out.println("Test 1: " + (expected1.equals(result1) ? "Pass" : "Fail") +
                    " (expected=\"" + expected1 + "\", got=\"" + result1 + "\")");
        } catch (UnsupportedOperationException e) {
            System.out.println("Test 1: Not implemented (expected=\"" + expected1 + "\")");
        }

        // Test case 2: Uniform weights mapping to 'y'
        // Input: words = ["a", "b", "c"], weights = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
        // Expected Output: "yyy"
        String[] words2 = {"a", "b", "c"};
        int[] weights2 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        String expected2 = "yyy";
        try {
            String result2 = solver.mapWordWeights(words2, weights2);
            System.out.println("Test 2: " + (expected2.equals(result2) ? "Pass" : "Fail") +
                    " (expected=\"" + expected2 + "\", got=\"" + result2 + "\")");
        } catch (UnsupportedOperationException e) {
            System.out.println("Test 2: Not implemented (expected=\"" + expected2 + "\")");
        }

        // Test case 3: Single word check
        // Input: words = ["abcd"], weights = [7, 5, 3, 4, 3, 5, 4, 9, 4, 2, 2, 7, 10, 2, 5, 10, 6, 1, 2, 2, 4, 1, 3, 4, 4, 5]
        // Expected Output: "g"
        String[] words3 = {"abcd"};
        int[] weights3 = {7, 5, 3, 4, 3, 5, 4, 9, 4, 2, 2, 7, 10, 2, 5, 10, 6, 1, 2, 2, 4, 1, 3, 4, 4, 5};
        String expected3 = "g";
        try {
            String result3 = solver.mapWordWeights(words3, weights3);
            System.out.println("Test 3: " + (expected3.equals(result3) ? "Pass" : "Fail") +
                    " (expected=\"" + expected3 + "\", got=\"" + result3 + "\")");
        } catch (UnsupportedOperationException e) {
            System.out.println("Test 3: Not implemented (expected=\"" + expected3 + "\")");
        }
    }
}
