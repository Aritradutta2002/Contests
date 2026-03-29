package LeetCode;
import java.util.*;
/*
 * 3. Longest Substring Without Repeating Characters
 * 
 * Given a string s, find the length of the longest substring without duplicate characters.
 * 
 * Constraints:
 * - 0 <= s.length <= 5 * 10^4
 * - s consists of English letters, digits, symbols and spaces.
 */
public class LC03_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        Set<Character> st = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            while (st.contains(s.charAt(right))) {
                st.remove(s.charAt(left));
                left++;
            }
            st.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        LC03_Longest_Substring_Without_Repeating_Characters solver = new LC03_Longest_Substring_Without_Repeating_Characters();
        Scanner sc = new Scanner(System.in);

        // Test Case 1
        String s1 = "abcabcbb";
        runTest(solver, 1, s1, 3);

        // Test Case 2
        String s2 = "bbbbb";
        runTest(solver, 2, s2, 1);

        // Test Case 3
        String s3 = "pwwkew";
        runTest(solver, 3, s3, 3);

        // Test Case 4
        String s4 = "dvdf";
        runTest(solver, 4, s4, 3);

        sc.close();
    }

    private static void runTest(LC03_Longest_Substring_Without_Repeating_Characters solver, int testId, String s, int expected) {
        try {
            int result = solver.lengthOfLongestSubstring(s);
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
