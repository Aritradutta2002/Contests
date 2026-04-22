package LeetCode;
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

    public static void main(String[] args) {
        LC2452_Words_Within_Two_Edits_Of_Dictionary solution = new LC2452_Words_Within_Two_Edits_Of_Dictionary();

        // Test Case 1
        String[] queries1 = { "word", "note", "ants", "wood" };
        String[] dictionary1 = { "wood", "joke", "moat" };
        List<String> expected1 = Arrays.asList("word", "note", "wood");
        testCase(solution, queries1, dictionary1, expected1, "Test Case 1");

        // Test Case 2
        String[] queries2 = { "yes" };
        String[] dictionary2 = { "not" };
        List<String> expected2 = Collections.emptyList();
        testCase(solution, queries2, dictionary2, expected2, "Test Case 2");

        // LeetCode failing case
        String[] queries3 = { "tsl", "sri", "yyy", "rbc", "dda", "qus", "hyb", "ilu", "ahd" };
        String[] dictionary3 = { "uyj", "bug", "dba", "xbe", "blu", "wuo", "tsf", "tga" };
        List<String> expected3 = Arrays.asList("tsl", "yyy", "rbc", "dda", "qus", "hyb", "ilu");
        testCase(solution, queries3, dictionary3, expected3, "Test Case 3");
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
