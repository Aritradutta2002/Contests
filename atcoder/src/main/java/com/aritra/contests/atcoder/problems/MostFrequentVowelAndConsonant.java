package com.aritra.contests.atcoder.problems;

import java.util.*;

public class MostFrequentVowelAndConsonant {
    public int mostFrequentVowelAndConsonant(String s) {
        int[] vowelFrequencies = new int[26];
        int[] consonantFrequencies = new int[26];

        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowelFrequencies[c - 'a']++;
            } else {
                consonantFrequencies[c - 'a']++;
            }
        }

        int maxVowelFrequency = 0;
        for (int freq : vowelFrequencies) {
            if (freq > maxVowelFrequency) {
                maxVowelFrequency = freq;
            }
        }

        int maxConsonantFrequency = 0;
        for (int freq : consonantFrequencies) {
            if (freq > maxConsonantFrequency) {
                maxConsonantFrequency = freq;
            }
        }

        return maxVowelFrequency + maxConsonantFrequency;
    }
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}

