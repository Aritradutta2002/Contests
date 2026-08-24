package com.leetcode;

import java.util.Random;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC1684_Count_The_Number_Of_Consistent_Strings_Test {

    @Test
    public void testExample1() {
        String allowed = "ab";
        String[] words = new String[]{"ad","bd","aaab","baa","badab"};
        int expected = 2;
        int actual = LC1684_Count_The_Number_Of_Consistent_Strings.countConsistentStrings(allowed, words);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample2() {
        String allowed = "abc";
        String[] words = new String[]{"a","b","c","ab","ac","bc","abc"};
        int expected = 7;
        int actual = LC1684_Count_The_Number_Of_Consistent_Strings.countConsistentStrings(allowed, words);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample3() {
        String allowed = "cad";
        String[] words = new String[]{"cc","acd","b","ba","bac","bad","ac","d"};
        int expected = 4;
        int actual = LC1684_Count_The_Number_Of_Consistent_Strings.countConsistentStrings(allowed, words);
        assertEquals(expected, actual);
    }

    @Test
    public void testEdgeCases() {
        assertEquals(0, LC1684_Count_The_Number_Of_Consistent_Strings.countConsistentStrings(
            "a", new String[]{"b","c","bc"}), "no word stays inside allowed");
        assertEquals(1, LC1684_Count_The_Number_Of_Consistent_Strings.countConsistentStrings(
            "a", new String[]{"aaaaaaaaaa"}), "repeated allowed letters are still consistent");
        assertEquals(3, LC1684_Count_The_Number_Of_Consistent_Strings.countConsistentStrings(
            "abcdefghijklmnopqrstuvwxyz", new String[]{"zyx","a","qwerty"}), "every letter allowed");
        assertEquals(1, LC1684_Count_The_Number_Of_Consistent_Strings.countConsistentStrings(
            "z", new String[]{"zzz","zza"}), "one letter outside allowed is enough to reject");
    }

    /* The bit-set check must agree with a per-character scan of allowed on random input. */
    @Test
    public void testMatchesBruteForceOnRandomInput() {
        Random random = new Random(42);
        for (int iteration = 0; iteration < 500; iteration++) {
            StringBuilder allowed = new StringBuilder();
            for (char c = 'a'; c <= 'f'; c++) {
                if (random.nextBoolean()) {
                    allowed.append(c);
                }
            }
            if (allowed.length() == 0) {
                allowed.append('a');
            }

            String[] words = new String[1 + random.nextInt(8)];
            for (int i = 0; i < words.length; i++) {
                StringBuilder word = new StringBuilder();
                int length = 1 + random.nextInt(5);
                for (int j = 0; j < length; j++) {
                    word.append((char) ('a' + random.nextInt(8)));
                }
                words[i] = word.toString();
            }

            String label = "allowed=" + allowed + ", words=" + String.join(",", words);
            assertEquals(bruteForceCount(allowed.toString(), words),
                LC1684_Count_The_Number_Of_Consistent_Strings.countConsistentStrings(allowed.toString(), words),
                label);
        }
    }

    /* Oracle: look every character of every word up in allowed directly. */
    private int bruteForceCount(String allowed, String[] words) {
        int consistent = 0;
        for (String word : words) {
            boolean ok = true;
            for (int i = 0; i < word.length(); i++) {
                if (allowed.indexOf(word.charAt(i)) < 0) {
                    ok = false;
                }
            }
            if (ok) {
                consistent++;
            }
        }
        return consistent;
    }
}
