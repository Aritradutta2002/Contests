package com.aritra.contests.leetcode;
import java.util.*;
/*
 * 657. Robot Return to Origin
 *
 * There is a robot starting at the position (0, 0), the origin, on a 2D plane.
 * Given a sequence of moves, judge if this robot ends up at (0, 0) after it completes its moves.
 * The move sequence is represented by a string moves where:
 * - 'U' means up
 * - 'D' means down
 * - 'L' means left
 * - 'R' means right
 * Return true if the robot returns to the origin, otherwise return false.
 *
 * Constraints:
 * - 1 <= moves.length <= 2 * 10^4
 * - moves only contains the characters 'U', 'D', 'L' and 'R'.
 */
public class LC657_Robot_Return_To_Origin {
    public boolean judgeCircle(String moves) {
        int countUD = 0;
        int countLR = 0;
        for(char ch : moves.toCharArray()){
            if(ch == 'R') countLR++;
            if(ch == 'L') countLR--;
            if(ch == 'U') countUD++;
            if(ch == 'D') countUD--;
        }
        return ((countLR == 0) && (countUD == 0));
    }
}
