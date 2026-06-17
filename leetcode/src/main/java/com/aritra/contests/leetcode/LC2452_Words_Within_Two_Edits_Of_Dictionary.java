package com.aritra.contests.leetcode;
import java.util.*;
/**
 * Problem: 2452. Words Within Two Edits of Dictionary
 * 
 * Description:
 * You are given two string arrays queries and dictionary. All words in each
 * array are of the same length. Return all words from queries that are within
 * two edits of any word in dictionary. A word is within two edits of another if
 * you can change at most two characters to make the words equal.
 * 
 * Constraints:
 * - 1 <= queries.length, dictionary.length <= 100
 * - 1 <= queries[i].length, dictionary[i].length <= 100
 * - All queries[i] and dictionary[i] are of the same length.
 * - queries[i] and dictionary[i] consist only of lowercase English letters.
 * 
 * Input Format:
 * - queries: array of query strings
 * - dictionary: array of dictionary strings
 * 
 * Output Format:
 * - A list containing each query word that matches at least one dictionary word
 *   within two edits
 */

public class LC2452_Words_Within_Two_Edits_Of_Dictionary {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for (String query : queries) {
            for (String word : dictionary) {
                if (isWithinTwoEdits(query, word)) {
                    ans.add(query);
                    break;
                }
            }
        }
        return ans;
    }
    private boolean isWithinTwoEdits(String a, String b) {
        int diffs = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diffs++;
                if (diffs > 2)
                    return false;
            }
        }
        return true;
    }
    private static void testCase(LC2452_Words_Within_Two_Edits_Of_Dictionary solution,
            String[] queries, String[] dictionary, List<String> expected, String testName) {
        List<String> result = solution.twoEditWords(queries, dictionary);
        if (result.equals(expected)) {
            System.out.println(testName + ": PASS");
        } else {
            System.out.println(testName + ": FAIL");
            System.out.println("  Expected: " + expected);
            System.out.println("  Got:      " + result);
        }
    }
}
