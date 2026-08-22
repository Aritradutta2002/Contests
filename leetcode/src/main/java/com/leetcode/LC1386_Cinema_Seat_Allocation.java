package com.leetcode;
import java.util.HashMap;
import java.util.Map;
/**
 * 1386. Cinema Seat Allocation
 *
 * A cinema has n rows of seats, numbered from 1 to n. Each row has 10 seats, numbered from 1 to 10.
 * You are given a 2D integer array reservedSeats, where reservedSeats[i] = [rowi, seati] means that seat seati in row rowi is already reserved.
 * A four-person group must be assigned to four seats in the same row. The group can be seated in one of the following seat blocks:
 *  - seats 2, 3, 4, 5
 *  - seats 4, 5, 6, 7
 *  - seats 6, 7, 8, 9
 * A block can be used only if none of its seats are reserved. Each seat can be assigned to at most one group.
 * Return an integer denoting the maximum number of four-person groups that can be assigned.
 * Example 1:
 * Input: n = 3, reservedSeats = [[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]
 * Output: 4
 * Explanation: The figure above shows an optimal allocation of four groups. Seats marked in blue are already reserved, and each set of four contiguous seats marked in orange is assigned to one group.
 * Example 2:
 * Input: n = 2, reservedSeats = [[2,1],[1,8],[2,6]]
 * Output: 2
 * Example 3:
 * Input: n = 4, reservedSeats = [[4,3],[1,4],[4,6],[1,7]]
 * Output: 4
 * Constraints:
 *  - 1 <= n <= 109
 *  - 1 <= reservedSeats.length <= min(10 * n, 104)
 *  - reservedSeats[i] == [rowi, seati]
 *  - 1 <= rowi <= n
 *  - 1 <= seati <= 10
 *  - All reservedSeats[i] are distinct.
 */
public class LC1386_Cinema_Seat_Allocation {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> masks = new HashMap<>();
        for (int[] seat : reservedSeats) {
            if (seat[1] >= 2 && seat[1] <= 9) {
                masks.merge(seat[0], 1 << seat[1], (left, right) -> left | right);
            }
        }
        long result = 2L * n;
        for (int mask : masks.values()) {
            boolean left = (mask & 0b0000111100) == 0;
            boolean middle = (mask & 0b0011110000) == 0;
            boolean right = (mask & 0b1111000000) == 0;
            result -= 2;
            if (left || right) result += 1;
            if (left && right) result += 1;
            else if (!left && !right && middle) result += 1;
        }
        return (int) result;
    }
}