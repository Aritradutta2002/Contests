package com.leetcode;

/**
 * 1872. Stone Game VIII
 *
 * Alice and Bob take turns playing a game, with Alice starting first.
 *
 * There are n stones arranged in a row. On each player's turn, while the number of stones is more than one, they will do the following:
 *
 *
 *  - Choose an integer x > 1, and remove the leftmost x stones from the row.
 *
 *  - Add the sum of the removed stones' values to the player's score.
 *
 *  - Place a new stone, whose value is equal to that sum, on the left side of the row.
 *
 * The game stops when only one stone is left in the row.
 *
 * The score difference between Alice and Bob is (Alice's score - Bob's score). Alice's goal is to maximize the score difference, and Bob's goal is the minimize the score difference.
 *
 * Given an integer array stones of length n where stones[i] represents the value of the ith stone from the left, return the score difference between Alice and Bob if they both play optimally.
 *
 *
 *
 * Example 1:
 * Input: stones = [-1,2,-3,4,-5]
 * Output: 5
 * Explanation:
 * - Alice removes the first 4 stones, adds (-1) + 2 + (-3) + 4 = 2 to her score, and places a stone of value 2 on the left. stones = [2,-5].
 * - Bob removes the first 2 stones, adds 2 + (-5) = -3 to his score, and places a stone of value -3 on the left. stones = [-3].
 * The difference between their scores is 2 - (-3) = 5.
 * Example 2:
 * Input: stones = [7,-6,5,10,5,-2,-6]
 * Output: 13
 * Explanation:
 * - Alice removes all stones, adds 7 + (-6) + 5 + 10 + 5 + (-2) + (-6) = 13 to her score, and places a stone of value 13 on the left. stones = [13].
 * The difference between their scores is 13 - 0 = 13.
 * Example 3:
 * Input: stones = [-10,-12]
 * Output: -22
 * Explanation:
 * - Alice can only make one move, which is to remove both stones. She adds (-10) + (-12) = -22 to her score and places a stone of value -22 on the left. stones = [-22].
 * The difference between their scores is (-22) - 0 = -22.
 * Constraints:
 *  - n == stones.length
 *  - 2 <= n <= 105
 *  - -104 <= stones[i] <= 104
 */
public class LC1872_Stone_Game_VIII {
    // Best approach wrapper
    public int stoneGameVIII(int[] stones) {
        return stoneGameVIIIRunningMax(stones);
    }

    /*
     * Approach 1: prefix sums plus a single right-to-left pass carrying a running max.
     *
     * A move collapses everything it touches into one stone, so no history has to be
     * remembered. If the last stone removed was stones[i], the row is
     * [prefix[i], stones[i+1], ..., stones[n-1]] where prefix[i] = stones[0] + ... + stones[i].
     * The whole position is therefore the single index i: from state i the player to move
     * picks some j > i, scores prefix[j], and hands state j to the opponent.
     *
     * With dp[i] = best achievable score difference for the player to move in state i:
     *
     *     dp[i] = max over j in (i, n-1] of (prefix[j] - dp[j])
     *
     * The candidate set for i is the candidate set for i + 1 plus the single extra term
     * j = i + 1, so that max is a running max scanned right to left:
     *
     *     dp[i] = max(dp[i+1], prefix[i+1] - dp[i+1])
     *
     * The base case is dp[n-2] = prefix[n-1]: with two stones left the mover must take both,
     * after which one stone remains and the opponent scores nothing. State n-1 is terminal.
     * Alice starts at state 0, and x > 1 forces her to remove at least two stones, which is
     * exactly what dp[0] enumerates, so the answer is dp[0].
     *
     * The running max also makes the prefix array unnecessary: prefix[i+1] is recovered from
     * prefix[i+2] by subtracting stones[i+2] as the scan walks left. Sums reach 10^9 and an
     * intermediate prefix[j] - dp[j] can reach about -3 * 10^9, so the scan runs in long even
     * though the answer itself fits in an int.
     *
     * Time: O(n), Space: O(1).
     */
    public int stoneGameVIIIRunningMax(int[] stones) {
        int n = stones.length;
        long prefix = 0;
        for (int stone : stones) {
            prefix += stone;
        }

        long best = prefix;                 // dp[n-2] = prefix[n-1]
        for (int i = n - 3; i >= 0; i--) {
            prefix -= stones[i + 2];        // prefix now holds prefix[i+1]
            best = Math.max(best, prefix - best);
        }
        return (int) best;
    }

    /*
     * Approach 2: the same recurrence evaluated straight from its definition.
     *
     * Fills dp right to left, but re-scans every candidate j > i instead of reusing a running
     * max, and reads the terminal state dp[n-1] = 0 rather than special-casing dp[n-2]. Too
     * slow for the stated constraints; kept as an independent oracle for the tests because it
     * shares none of Approach 1's arithmetic shortcuts.
     *
     * Time: O(n^2), Space: O(n).
     */
    public int stoneGameVIIIQuadratic(int[] stones) {
        int n = stones.length;
        long[] prefix = new long[n];
        long running = 0;
        for (int i = 0; i < n; i++) {
            running += stones[i];
            prefix[i] = running;
        }

        long[] dp = new long[n];
        dp[n - 1] = 0;                      // terminal: one stone left, no move, no score
        for (int i = n - 2; i >= 0; i--) {
            long best = Long.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                best = Math.max(best, prefix[j] - dp[j]);
            }
            dp[i] = best;
        }
        return (int) dp[0];
    }
}
