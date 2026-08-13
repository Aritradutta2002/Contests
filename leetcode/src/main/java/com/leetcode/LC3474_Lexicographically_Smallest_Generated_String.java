package com.leetcode;
import java.util.*;

/*
 * 3474. Lexicographically Smallest Generated String
 *
 * Given two strings s1 and s2, generate the lexicographically smallest string of length n avoiding
 * certain patterns defined by s1 and s2.
 *
 * Constraints:
 * - 1 <= s1.length, s2.length <= 100
 * - s1 and s2 consist of 'T' and 'F'
 */
public class LC3474_Lexicographically_Smallest_Generated_String {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int wordLen = n + m - 1;
        char[] res = new char[wordLen];
        boolean[] isFixed = new boolean[wordLen];

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    int pos = i + j;
                    char c = str2.charAt(j);
                    if (isFixed[pos]) {
                        if (res[pos] != c) return "";
                    } else {
                        res[pos] = c;
                        isFixed[pos] = true;
                    }
                }
            }
        }

        for (int pos = 0; pos < wordLen; pos++) {
            if (!isFixed[pos]) res[pos] = 'a';
        }

        boolean changed;
        do {
            changed = false;
            List<Integer> violators = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (str1.charAt(i) == 'F') {
                    boolean equal = true;
                    for (int j = 0; j < m; j++) {
                        int pos = i + j;
                        if (res[pos] != str2.charAt(j)) {
                            equal = false;
                            break;
                        }
                    }
                    if (equal) violators.add(i);
                }
            }
            if (violators.isEmpty()) break;

            int[] count = new int[wordLen];
            for (int i : violators) {
                for (int j = 0; j < m; j++) {
                    int pos = i + j;
                    if (!isFixed[pos]) count[pos]++;
                }
            }

            int bestPos = -1;
            int maxCount = -1;
            for (int pos = 0; pos < wordLen; pos++) {
                if (count[pos] > maxCount) {
                    maxCount = count[pos];
                    bestPos = pos;
                }
            }
            if (bestPos == -1) return "";

            res[bestPos] = (char) (res[bestPos] + 1);
            if (res[bestPos] > 'z') return "";
            changed = true;
        } while (changed);

        return new String(res);
    }}