package com.leetcode;
/*
 * LeetCode 1081: Smallest Subsequence of Distinct Characters
 * Difficulty: Medium
 *
 * Problem Description:
 * Given a string s, return the lexicographically smallest subsequence of s
 * that contains all the distinct characters of s exactly once.
 *
 * Constraints:
 * - 1 <= s.length <= 1000
 * - s consists of lowercase English letters.
 *
 * Note: This question is the same as 316: Remove Duplicate Letters
 * (https://leetcode.com/problems/remove-duplicate-letters/)
 *
 * Author : Aritra
 * Created On: Sunday, 19.07.2026
 */
public class LC1081_Smallest_Subsequence_of_Distinct_Characters {
    public String smallestSubsequence(String s) {
        StringBuilder result = new StringBuilder();
        int[] lastIndex = new int[26];
        for(int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(result.indexOf(String.valueOf(c)) != -1) continue;

            while(result.length() > 0 && result.charAt(result.length() - 1) > c && lastIndex[result.charAt(result.length() - 1) - 'a'] > i) {
                result.deleteCharAt(result.length() - 1);
            }
            result.append(c);
        }
        return result.toString();
    }
}

/*
 * =====================================================================================
 * HOW THE ALGORITHM WORKS — Step-by-Step Explanation
 * =====================================================================================
 *
 * GOAL:
 *   Given a string s, produce the lexicographically smallest subsequence that
 *   contains every distinct character of s exactly once.
 *   (Lexicographically smallest = "smallest" in dictionary order, e.g. "abc" < "acb".)
 *
 * CORE IDEA — Monotonic Stack with "last occurrence" safety check:
 *   We scan s left-to-right and build the answer character-by-character. We want the
 *   result to be as small as possible, so we try to keep it in increasing order.
 *   Whenever we see a character that is SMALLER than the last one we added, we'd love
 *   to pop that last character off (to make room for the smaller one earlier) — BUT we
 *   may only do so if that popped character will appear AGAIN later in the string.
 *   Otherwise we'd lose it forever and the result would be missing a distinct char.
 *
 * STEP 1 — Record the last index of every character:
 *   lastIndex[c - 'a'] = the rightmost position where character c occurs.
 *   This tells us, at any point, whether a character will reappear later (so it is
 *   safe to remove it now and pick it up again).
 *
 * STEP 2 — Scan the string and build the result greedily:
 *   For each character c at index i:
 *
 *   (a) Skip if already in the result.
 *       A subsequence must contain each distinct character EXACTLY ONCE, so adding
 *       a duplicate would violate the "exactly once" rule.
 *
 *   (b) While the result is non-empty AND the last character of the result is
 *       LEXICOGRAPHICALLY GREATER than c AND that last character will occur again
 *       later (lastIndex[...] > i):
 *           -> Pop (remove) the last character.
 *       Why? Removing a larger character that comes back later lets us place the
 *       smaller character c earlier, producing a lexicographically smaller string.
 *       The "lastIndex > i" guard guarantees we can re-add the popped character
 *       when we encounter it again, so no distinct character is lost.
 *
 *   (c) Append c to the result.
 *
 * STEP 3 — Return the built string.
 *
 * WHY THIS REACHES THE ULTIMATE GOAL:
 *   - "Exactly once":  enforced by the duplicate skip in step (a).
 *   - "All distinct characters present": enforced by the lastIndex guard in step (b)
 *     — we only pop a character if it will reappear, so every distinct character is
 *     eventually added.
 *   - "Lexicographically smallest": enforced by the greedy popping in step (b) — we
 *     always push smaller characters as far left as possible by evicting larger ones
 *     that can be re-added later. This greedy choice is optimal because making the
 *     earliest possible position as small as possible is what defines lexicographic
 *     order (the leftmost differing character decides the comparison).
 *
 * WALKTHROUGH — s = "cbacdcbc":
 *   lastIndex: a->2, b->6, c->7, d->4
 *   i=0 c: result=""        -> append c        => "c"
 *   i=1 b: 'c'>'b' & c reappears (7>1) -> pop c; append b => "b"
 *   i=2 a: 'b'>'a' & b reappears (6>2) -> pop b; append a => "a"
 *   i=3 c: 'a'<'c' (no pop); append c            => "ac"
 *   i=4 d: 'c'<'d' (no pop); append d            => "acd"
 *   i=5 c: c already in result -> skip           => "acd"
 *   i=6 b: 'd'>'b' but d does NOT reappear (4>6 false) -> no pop; append b => "acdb"
 *   i=7 b: b already in result -> skip            => "acdb"
 *   Final answer: "acdb"  ✓ (matches expected output)
 *
 * COMPLEXITY:
 *   Time : O(n) amortized — each character is pushed and popped at most once.
 *          (Note: result.indexOf(...) is O(n) per call, so worst case O(n^2);
 *           a HashSet can make it strictly O(n).)
 *   Space: O(1) extra besides the output (alphabet is fixed at 26 letters).
 * =====================================================================================
 */