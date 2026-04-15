package LeetCode;
import java.util.*;
/*
 * 127. Word Ladder
 *
 * Description:
 * Given two words, beginWord and endWord, and a dictionary wordList, return the
 * number of words in the shortest transformation sequence from beginWord to endWord,
 * or 0 if no such sequence exists.
 * A valid transformation changes exactly one letter at a time and each transformed
 * word must exist in wordList.
 *
 * Constraints:
 * - 1 <= beginWord.length <= 10
 * - endWord.length == beginWord.length
 * - 1 <= wordList.length <= 5000
 * - wordList[i].length == beginWord.length
 * - beginWord, endWord, and wordList[i] consist of lowercase English letters
 * - beginWord != endWord
 *
 * Example 1:
 * beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"] -> 5
 * Example 2:
 * beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"] -> 0
 * Example 3:
 * beginWord = "a", endWord = "c", wordList = ["a","b","c"] -> 2
 */
public class LC127_Word_Ladder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public static void main(String[] args) {
        LC127_Word_Ladder solver = new LC127_Word_Ladder();

        TestCase[] tests = new TestCase[]{
                new TestCase("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"), 5),
                new TestCase("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log"), 0),
                new TestCase("a", "c", Arrays.asList("a", "b", "c"), 2)
        };

        runAllTests(solver, tests);
    }

    private static void runAllTests(LC127_Word_Ladder solver, TestCase[] tests) {
        int passed = 0;
        for (int i = 0; i < tests.length; i++) {
            TestCase tc = tests[i];
            try {
                int actual = solver.ladderLength(tc.beginWord, tc.endWord, tc.wordList);
                boolean ok = actual == tc.expected;
                if (ok) {
                    passed++;
                }
                System.out.printf(
                        "Test %d | begin=%s, end=%s, wordList=%s | expected=%d, actual=%d | %s%n",
                        i + 1, tc.beginWord, tc.endWord, tc.wordList, tc.expected, actual, ok ? "PASS" : "FAIL");
            } catch (UnsupportedOperationException ex) {
                System.out.printf(
                        "Test %d | begin=%s, end=%s, wordList=%s | expected=%d | SKIPPED (%s)%n",
                        i + 1, tc.beginWord, tc.endWord, tc.wordList, tc.expected, ex.getMessage());
            }
        }
        System.out.printf("Summary: %d/%d tests passed.%n", passed, tests.length);
    }

    private static class TestCase {
        final String beginWord;
        final String endWord;
        final List<String> wordList;
        final int expected;

        TestCase(String beginWord, String endWord, List<String> wordList, int expected) {
            this.beginWord = beginWord;
            this.endWord = endWord;
            this.wordList = wordList;
            this.expected = expected;
        }
    }
}
