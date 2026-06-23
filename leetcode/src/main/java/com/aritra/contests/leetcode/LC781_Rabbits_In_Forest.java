package com.aritra.contests.leetcode;

/*
 * 781. Rabbits in Forest
 *
 * In a forest, each rabbit reports how many other rabbits share its color. Given the answers array,
 * return the minimum possible number of rabbits in the forest.
 *
 * Constraints:
 * - 1 <= answers.length <= 1000
 * - 0 <= answers[i] < 1000
 */
public class LC781_Rabbits_In_Forest {
    public static int numRabbits(int[] answers) {
        int ans = 0;
        int[] count = new int[1001];
        for (int i = 0; i < answers.length; i++) {
            count[answers[i]]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                ans += (i + 1) * ((count[i] + i) / (i + 1));
            }
        }
        return ans;
    }
}

