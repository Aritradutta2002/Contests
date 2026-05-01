package LeetCode;

import java.util.*;

/*
 * LeetCode Problem 57 - Insert Interval
 * 
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [start_i, end_i] 
 * represent the start and end of the ith interval, and intervals are sorted in ascending order by start_i. 
 * You are also given an interval newInterval = [start, end] that needs to be inserted into intervals.
 * 
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by start_i 
 * and intervals still does not have any overlapping intervals. Intervals that are inserted should 
 * merge if necessary.
 * 
 * Return intervals after the insertion.
 * 
 * Constraints:
 * - 0 <= intervals.length <= 10^4
 * - intervals[i].length == 2
 * - 0 <= start_i <= end_i <= 10^5
 * - intervals is sorted in ascending order by start_i
 * - newInterval.length == 2
 * - 0 <= start <= end <= 10^5
 */

public class LC057_Insert_Interval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public static void main(String[] args) {
        LC057_Insert_Interval solution = new LC057_Insert_Interval();
        
        // Test Case 1: Insert into empty intervals
        int[][] intervals1 = {};
        int[] newInterval1 = {5, 7};
        int[][] result1 = solution.insert(intervals1, newInterval1);
        System.out.println("Test Case 1: " + Arrays.deepToString(result1));
        
        // Test Case 2: Insert before first interval
        int[][] intervals2 = {{1, 3}, {6, 9}};
        int[] newInterval2 = {2, 5};
        int[][] result2 = solution.insert(intervals2, newInterval2);
        System.out.println("Test Case 2: " + Arrays.deepToString(result2));
        
        // Test Case 3: Insert after last interval
        int[][] intervals3 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval3 = {4, 8};
        int[][] result3 = solution.insert(intervals3, newInterval3);
        System.out.println("Test Case 3: " + Arrays.deepToString(result3));
    }
}