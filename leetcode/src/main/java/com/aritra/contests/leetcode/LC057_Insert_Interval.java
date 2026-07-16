package com.aritra.contests.leetcode;

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
        List<int[]> result = new ArrayList<>();
        int i = 0, n = intervals.length;
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        while (i < n) {
            result.add(intervals[i++]);
        }
        return result.toArray(new int[result.size()][]);
    }
}