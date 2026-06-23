package com.aritra.contests.leetcode;
import java.util.*;
/*
 * 3121. Count the Number of Special Characters II
 *
 * You are given a string word. A letter c is called special if it appears both in lowercase and uppercase in word,
 * and every lowercase occurrence of c appears before the first uppercase occurrence of c.
 * Return the number of special letters in word.
 *
 * Constraints:
 * - 1 <= word.length <= 2 * 10^5
 * - word consists of only lowercase and uppercase English letters.
 */
public class LC3121_Count_the_Number_of_Special_Characters_II {
    public int numberOfSpecialChars(String word) {
        return 0;
    }
    private static void runTest(LC3121_Count_the_Number_of_Special_Characters_II solver, int testId, String word, int expected) {
        try {
            int result = solver.numberOfSpecialChars(word);
            if (result == expected) {
                System.out.println("Test " + testId + ": PASS");
            } else {
                System.out.println("Test " + testId + ": FAIL");
                System.out.println("  Expected: " + expected);
                System.out.println("  Actual:   " + result);
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Test " + testId + ": SKIPPED (Not implemented)");
        } catch (Exception e) {
            System.out.println("Test " + testId + ": ERROR (" + e.getMessage() + ")");
        }
    }
}
