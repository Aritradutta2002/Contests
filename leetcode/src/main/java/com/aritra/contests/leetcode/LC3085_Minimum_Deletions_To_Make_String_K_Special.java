package com.aritra.contests.leetcode;

/*
 *   Author : Aritra
 *   Created On: Saturday,21.06.2025 11:05 pm
 */
public class LC3085_Minimum_Deletions_To_Make_String_K_Special {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        int[] values = java.util.Arrays.stream(freq)
                .filter(count -> count > 0)
                .sorted()
                .toArray();

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < values.length; i++) {
            int base = values[i];
            int deletions = 0;

            for (int j = 0; j < values.length; j++) {
                if (j < i) {
                    deletions += values[j];
                } else if (values[j] > base + k) {
                    deletions += values[j] - (base + k);
                }
            }

            answer = Math.min(answer, deletions);
        }

        return answer;
    }
}
