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
    }}
