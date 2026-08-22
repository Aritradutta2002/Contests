package com.leetcode;
/**
 * 1510. Stone Game IV
 *
 * Alice and Bob take turns playing a game, with Alice starting first.
 * 
 * Initially, there are n stones in a pile. On each player's turn, that player makes a move consisting of removing any non-zero square number of stones in the pile.
 * 
 * Also, if a player cannot make a move, he/she loses the game.
 * 
 * Given a positive integer n, return true if and only if Alice wins the game otherwise return false, assuming both players play optimally.
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: n = 1
 * Output: true
 * Explanation: Alice can remove 1 stone winning the game because Bob doesn't have any moves.
 * 
 * Example 2:
 * 
 * Input: n = 2
 * Output: false
 * ...
 */
public class LC1510_Stone_Game_IV {
    public boolean winnerSquareGame(int n) {
        boolean[] winning = new boolean[n + 1];
        for (int stones = 1; stones <= n; stones++) {
            for (int square = 1; square * square <= stones; square++) {
                if (!winning[stones - square * square]) {
                    winning[stones] = true;
                    break;
                }
            }
        }
        return winning[n];
    }
}