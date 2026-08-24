package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1927. Sum Game
 *
 * Alice and Bob take turns playing a game, with Alice starting first.
 *
 * You are given a string num of even length consisting of digits and '?' characters. On each turn, a player will do the following if there is still at least one '?' in num:
 *
 *
 *  - Choose an index i where num[i] == '?'.
 *
 *  - Replace num[i] with any digit between '0' and '9'.
 *
 * The game ends when there are no more '?' characters in num.
 *
 * For Bob to win, the sum of the digits in the first half of num must be equal to the sum of the digits in the second half. For Alice to win, the sums must not be equal.
 *
 *
 *  - For example, if the game ended with num = "243801", then Bob wins because 2+4+3 = 8+0+1. If the game ended with num = "243803", then Alice wins because 2+4+3 != 8+0+3.
 *
 * Assuming Alice and Bob play optimally, return true if Alice will win and false if Bob will win.
 *
 *
 *
 * Example 1:
 * Input: num = "5023"
 * Output: false
 * Explanation: There are no moves to be made. The sum of the first half is equal to the sum of the second half: 5 + 0 = 2 + 3.
 * Example 2:
 * Input: num = "25??"
 * Output: true
 * Explanation: Alice can replace one of the '?'s with '9' and it will be impossible for Bob to make the sums equal.
 * Example 3:
 * Input: num = "?3295???"
 * Output: false
 * Explanation: It can be proven that Bob will always win. One possible outcome is:
 * - Alice replaces the first '?' with '9'. num = "93295???".
 * - Bob replaces one of the '?' in the right half with '0'. num = "932950??".
 * - Alice replaces one of the '?' in the right half with '2'. num = "9329502?".
 * - Bob replaces the last '?' in the right half with '7'. num = "93295027".
 * Bob wins because 9 + 3 + 2 + 9 = 5 + 0 + 2 + 7.
 * Constraints:
 *  - 2 <= num.length <= 105
 *  - num.length is even.
 *  - num consists of only digits and '?'.
 */
public class LC1927_Sum_Game {
    // Best approach wrapper
    public boolean sumGame(String num) {
        return sumGameCounting(num);
    }

    /*
     * Approach 1: one counting pass, then a closed-form rule.
     *
     * Positions never matter, only which half a blank sits in, so the position reduces to two
     * numbers: digits = (known digit sum on the left) - (known digit sum on the right), and
     * blanks = (number of '?' on the left) - (number of '?' on the right). Bob needs the final
     * difference to be 0; Alice needs it non-zero.
     *
     * If the total number of blanks is odd, Alice wins. She moves first, so an odd count leaves
     * the last move to her: whatever difference D the position has when one blank remains, that
     * blank contributes +d or -d for a digit d she chooses, and at most one of the ten digits
     * hits 0, so she always has nine losing-for-Bob replies. Note that the total count
     * (left + right) and the signed value (left - right) always share a parity, so the signed
     * counter answers this question too.
     *
     * With an even number of blanks, Bob moves last and both players have exact mirroring
     * strategies, which pins the outcome to a single equality. Pair up blanks: a pair with one
     * blank in each half can be neutralized by copying Alice's digit into the other half, so it
     * contributes 0 to the difference; a pair of blanks inside the same half can be pinned to
     * exactly 9 by answering d with 9 - d, so it contributes +9 (left) or -9 (right). After
     * matching min(left, right) cross-half pairs, the |left - right| leftovers all sit in one
     * half and form (left - right) / 2 same-half pairs, so Bob can force the final difference to
     *
     *     digits + 9 * (blanks / 2)
     *
     * and Bob wins exactly when that is 0. When it is non-zero Alice moves first in every
     * remaining pair and can always push the imbalance the way it already leans - dropping 9 (or
     * 0) into the half that the equality says is short (or heavy) moves the total by more than
     * the 9 per pair Bob can recover - so the sums cannot come back to equal.
     *
     * Time: O(n), Space: O(1).
     */
    public boolean sumGameCounting(String num) {
        int half = num.length() / 2;
        int digits = 0;                 // known digit sum, left half minus right half
        int blanks = 0;                 // '?' count, left half minus right half
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            int sign = i < half ? 1 : -1;
            if (c == '?') {
                blanks += sign;
            } else {
                digits += sign * (c - '0');
            }
        }

        if ((blanks & 1) != 0) {
            return true;                // odd number of blanks overall: Alice fills the last one
        }
        return digits + 9 * blanks / 2 != 0;
    }

    /*
     * Approach 2: exhaustive minimax over the reduced position, memoized.
     *
     * Same reduction as above - a position is (blanks left of centre, blanks right of centre,
     * current difference, whose turn) - but here nothing is assumed about optimal play: every
     * digit in every remaining half is tried, Alice keeps any line that ends unequal and Bob
     * keeps any line that ends equal. Exponential in the blank count without the memo and still
     * far too slow for the stated constraints with it; kept as an independent oracle that the
     * tests check the closed-form rule against.
     *
     * Time: O(left * right * range * 10) states-and-transitions, Space: same in the memo.
     */
    public boolean sumGameBruteForce(String num) {
        int half = num.length() / 2;
        int left = 0;
        int right = 0;
        int difference = 0;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            int sign = i < half ? 1 : -1;
            if (c == '?') {
                if (i < half) {
                    left++;
                } else {
                    right++;
                }
            } else {
                difference += sign * (c - '0');
            }
        }
        return search(left, right, difference, true, new HashMap<>());
    }

    /* Returns whether Alice wins the reduced position; aliceToMove says who fills the next blank. */
    private boolean search(int left, int right, int difference, boolean aliceToMove, Map<Long, Boolean> memo) {
        if (left == 0 && right == 0) {
            return difference != 0;
        }
        // Blank counts stay under 2^20 (n <= 10^5) and |difference| under 2^20 (9 * 5 * 10^4).
        long key = ((long) left << 42) | ((long) right << 22)
                | ((long) (difference + (1 << 20)) << 1) | (aliceToMove ? 1 : 0);
        Boolean cached = memo.get(key);
        if (cached != null) {
            return cached;
        }

        boolean aliceWins = !aliceToMove;   // the mover fails to force their outcome unless a move says otherwise
        for (int digit = 0; digit <= 9 && aliceWins != aliceToMove; digit++) {
            if (left > 0 && search(left - 1, right, difference + digit, !aliceToMove, memo) == aliceToMove) {
                aliceWins = aliceToMove;
            } else if (right > 0 && search(left, right - 1, difference - digit, !aliceToMove, memo) == aliceToMove) {
                aliceWins = aliceToMove;
            }
        }
        memo.put(key, aliceWins);
        return aliceWins;
    }
}
