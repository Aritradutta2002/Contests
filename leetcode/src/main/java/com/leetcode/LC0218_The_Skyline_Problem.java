package com.leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * 218. The Skyline Problem
 *
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Given the locations and heights of all the buildings, return the skyline formed by these buildings collectively.
 * The geometric information of each building is given in the array buildings where buildings[i] = [lefti, righti, heighti]:
 *  - lefti is the x coordinate of the left edge of the ith building.
 *  - righti is the x coordinate of the right edge of the ith building.
 *  - heighti is the height of the ith building.
 * You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 * The skyline should be represented as a list of "key points" sorted by their x-coordinate in the form [[x1,y1],[x2,y2],...]. Each key point is the left endpoint of some horizontal segment in the skyline except the last point in the list, which always has a y-coordinate 0 and is used to mark the skyline's termination where the rightmost building ends. Any ground between the leftmost and rightmost buildings should be part of the skyline's contour.
 * Note: There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...,[2 3],[4 5],[7 5],[11 5],[12 7],...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...,[2 3],[4 5],[12 7],...]
 * Example 1:
 * Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
 * Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
 * Explanation:
 * Figure A shows the buildings of the input.
 * Figure B shows the skyline formed by those buildings. The red points in figure B represent the key points in the output list.
 * Example 2:
 * Input: buildings = [[0,2,3],[2,5,3]]
 * Output: [[0,3],[5,0]]
 * Constraints:
 *  - 1 <= buildings.length <= 104
 *  - 0 <= lefti < righti <= 231 - 1
 *  - 1 <= heighti <= 231 - 1
 *  - buildings is sorted by lefti in non-decreasing order.
 */
public class LC0218_The_Skyline_Problem {
    // Best approach wrapper
    public List<List<Integer>> getSkyline(int[][] buildings) {
        return getSkylineSweepLine(buildings);
    }

    /*
     * Approach 1: Sweep line over building edges with a multiset of open heights.
     *
     * Sweep line from left to right over every building edge, keeping a multiset of the
     * heights that are currently "open". Each edge becomes an event {x, h}, where h is
     * negated for a left edge. Sorting events by x, then by that signed height, gives
     * exactly the tie-breaking the problem needs at a shared x:
     *   - left edges (negative) before right edges (positive), so a building that starts
     *     where another ends never emits a spurious drop to a lower height;
     *   - among left edges, the tallest opens first, so only the taller one emits a point;
     *   - among right edges, the shortest closes first, for the same reason.
     * After applying an event, the tallest open height is the skyline height at x. A point
     * is recorded only when that height changes, which is what suppresses consecutive
     * segments of equal height. The ground (0) is kept in the multiset permanently so the
     * max is always defined and gaps between buildings emit [x, 0].
     *
     * Time: O(n log n), Space: O(n).
     */
    public List<List<Integer>> getSkylineSweepLine(int[][] buildings) {
        int[][] events = new int[buildings.length * 2][];
        int idx = 0;
        for (int[] b : buildings) {
            events[idx++] = new int[]{b[0], -b[2]};
            events[idx++] = new int[]{b[1], b[2]};
        }
        
        Arrays.sort(events, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        TreeMap<Integer, Integer> active = new TreeMap<>();
        active.put(0, 1);
        List<List<Integer>> result = new ArrayList<>();
        int prevHeight = 0;
        for (int[] e : events) {
            int x = e[0], h = e[1];
            if (h < 0) {
                active.merge(-h, 1, Integer::sum);
            } else {
                int count = active.get(h);
                if (count == 1) {
                    active.remove(h);
                } else {
                    active.put(h, count - 1);
                }
            }
            int height = active.lastKey();
            if (height != prevHeight) {
                result.add(List.of(x, height));
                prevHeight = height;
            }
        }
        return result;
    }

    /*
     * Approach 2: Segment tree with range-max updates over compressed x coordinates.
     *
     * Compress the 2n edge coordinates into m distinct values, which carve the x axis into
     * m - 1 elementary intervals [xs[i], xs[i+1]). Every building spans a whole run of
     * those intervals, so building i is one range update "raise this range to at least h"
     * over the elementary intervals in [left, right).
     *
     * Range max-assign needs no push-down while updating: max is commutative and
     * idempotent, so a tag parked on an interior node applies to its whole subtree no
     * matter what order the tags arrived in, and no aggregate is read mid-way. Because
     * every update precedes every query, the tags are pushed down exactly once at the end,
     * in a single traversal that carries the running max from root to each leaf and settles
     * the final height of each elementary interval.
     *
     * The skyline is then a scan of those heights, emitting a point only where the height
     * changes, plus the closing [rightmost x, 0].
     *
     * Time: O(n log n), Space: O(n).
     */
    public List<List<Integer>> getSkylineSegmentTree(int[][] buildings) {
        int[] xs = new int[buildings.length * 2];
        int k = 0;
        for (int[] b : buildings) {
            xs[k++] = b[0];
            xs[k++] = b[1];
        }
        Arrays.sort(xs);
        int m = 0;
        for (int i = 0; i < xs.length; i++) {
            if (i == 0 || xs[i] != xs[i - 1]) {
                xs[m++] = xs[i];
            }
        }

        // m distinct coordinates bound m - 1 elementary intervals; m >= 2 since left < right.
        int segments = m - 1;
        int[] tags = new int[4 * segments];
        for (int[] b : buildings) {
            int lo = Arrays.binarySearch(xs, 0, m, b[0]);
            int hi = Arrays.binarySearch(xs, 0, m, b[1]);
            raise(tags, 1, 0, segments - 1, lo, hi - 1, b[2]);
        }

        int[] heights = new int[segments];
        pushDownToLeaves(tags, 1, 0, segments - 1, 0, heights);

        List<List<Integer>> result = new ArrayList<>();
        int prevHeight = 0;
        for (int i = 0; i < segments; i++) {
            if (heights[i] != prevHeight) {
                result.add(List.of(xs[i], heights[i]));
                prevHeight = heights[i];
            }
        }
        if (prevHeight != 0) {
            result.add(List.of(xs[m - 1], 0));
        }
        return result;
    }

    /* Raises every elementary interval in [queryLo, queryHi] to at least height. */
    private void raise(int[] tags, int node, int lo, int hi, int queryLo, int queryHi, int height) {
        if (queryHi < lo || hi < queryLo) {
            return;
        }
        if (queryLo <= lo && hi <= queryHi) {
            tags[node] = Math.max(tags[node], height);
            return;
        }
        int mid = (lo + hi) >>> 1;
        raise(tags, node * 2, lo, mid, queryLo, queryHi, height);
        raise(tags, node * 2 + 1, mid + 1, hi, queryLo, queryHi, height);
    }

    /* Carries the running max down every root-to-leaf path, settling each interval's height. */
    private void pushDownToLeaves(int[] tags, int node, int lo, int hi, int carried, int[] heights) {
        int height = Math.max(carried, tags[node]);
        if (lo == hi) {
            heights[lo] = height;
            return;
        }
        int mid = (lo + hi) >>> 1;
        pushDownToLeaves(tags, node * 2, lo, mid, height, heights);
        pushDownToLeaves(tags, node * 2 + 1, mid + 1, hi, height, heights);
    }
}
