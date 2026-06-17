package com.aritra.contests.codechef;

import java.util.*;

/*
 * Problem: Journey of the Knight
 * Platform: CodeChef | Problem ID: KNIGHT2
 * Link: https://www.codechef.com/practice/course/1-star-difficulty-problems/DIFF1200/problems/KNIGHT2
 *
 * Description:
 *   Chef has an 8x8 chessboard. A knight is placed at (X1, Y1).
 *   Determine if the knight can reach (X2, Y2) in EXACTLY 100 moves.
 *
 *   Note: A knight at (X, Y) can move to (X', Y') such that
 *         {|X - X'|, |Y - Y'|} = {1, 2}  (the standard L-shaped move).
 *   A knight has 8 possible moves:
 *   (-2,-1), (-2,+1), (-1,-2), (-1,+2), (+1,-2), (+1,+2), (+2,-1), (+2,+1)
 *
 * Input Format:
 *   - First line: T (number of test cases)
 *   - Each test case: one line with four integers X1 Y1 X2 Y2
 *
 * Output Format:
 *   - For each test case: print "YES" or "NO"
 *
 * Constraints:
 *   - 1 <= T <= 1000
 *   - 1 <= X1, Y1, X2, Y2 <= 8
 *
 * Sample Input:
 *   3
 *   1 1 1 1
 *   8 8 7 6
 *   8 8 8 6
 *
 * Sample Output:
 *   YES
 *   NO
 *   YES
 *
 * Explanation:
 *   Test 1: Knight goes (1,1) -> (2,3) -> (1,1), repeat 50 times = 100 moves. YES
 *   Test 2: Impossible to reach (7,6) from (8,8) in exactly 100 moves. NO
 *   Test 3: Knight alternates (8,8) -> (6,7) -> (8,6) then oscillates. YES
 *
 * Key Insight:
 *   A knight ALWAYS flips the square color on every move (like a chessboard).
 *   After 100 moves (even), start and end MUST share the same color.
 *   Color of (x, y) = (x + y) % 2.
 *   On an 8x8 board, any two same-color squares are reachable within 6 moves
 *   (always < 100), and we can always pad remaining even moves by bouncing
 *   to a neighbor and back. So parity is the ONLY check needed.
 */
public class Journey_Of_The_Knight_KNIGHT2 {

    // -------------------------------------------------------------------------
    // Solution method
    // -------------------------------------------------------------------------
    public static String solve(int x1, int y1, int x2, int y2) {
        // Same color = same parity of (x+y) → YES, different → NO
        return ((x1 + y1) % 2 == (x2 + y2) % 2) ? "YES" : "NO";
    }

    // -------------------------------------------------------------------------
    // Main
    // -------------------------------------------------------------------------}
