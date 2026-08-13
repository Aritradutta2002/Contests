package com.leetcode;
import java.util.*;
@SuppressWarnings("unused")

/*
 * 1079. Letter Tile Possibilities
 *
 * You have n tiles, where each tile has one letter tiles[i] printed on it.
 * Return the number of possible non-empty sequences of letters you can make using the letters
 * printed on those tiles.
 *
 * Constraints:
 * - 1 <= tiles.length <= 7
 * - tiles consists of uppercase English letters
 */
public class LC1079_Letter_Tile_Possibilities{
    static public int numTilePossibilities(String tiles) {
        int[] freq = new int[26];
        for (char c : tiles.toCharArray()) {
            freq[c - 'A']++;
        }
        return backtrack(freq);
    }
    private static int backtrack(int[] freq) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;
            count++;
            freq[i]--;
            count += backtrack(freq);
            freq[i]++;
        }
        return count;
    }
}
