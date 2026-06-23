package com.aritra.contests.leetcode;
import java.util.*;
/*
Problem: 3661. Maximum Walls Destroyed by Robots

Description:
There is an endless straight line populated with some robots and walls. You are given integer arrays robots, distance, and walls:
- robots[i] is the position of the ith robot.
- distance[i] is the maximum distance the ith robot's bullet can travel.
- walls[j] is the position of the jth wall.

Every robot has one bullet that can either fire to the left or the right at most distance[i] meters.
A bullet destroys every wall in its path that lies within its range.
Robots are fixed obstacles: if a bullet hits another robot before reaching a wall, it immediately stops at that robot and cannot continue.
Return the maximum number of unique walls that can be destroyed by the robots.

Constraints:
- 1 <= robots.length == distance.length <= 10^5
- 1 <= walls.length <= 10^5
- 1 <= robots[i], walls[j] <= 10^9
- 1 <= distance[i] <= 10^5
- All values in robots are unique
- All values in walls are unique

Notes:
- A wall and a robot may share the same position; the wall can be destroyed by the robot at that position.

Input/Output:
Input: robots (array), distance (array), walls (array)
Output: integer (maximum unique walls destroyed)
*/
public class LC3661_Maximum_Walls_Destroyed_By_Robots {
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        int m = walls.length;

        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = robots[i];
            pairs[i][1] = distance[i];
        }
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));

        int[] sortedRobots = new int[n];
        int[] sortedDistance = new int[n];
        for (int i = 0; i < n; i++) {
            sortedRobots[i] = pairs[i][0];
            sortedDistance[i] = pairs[i][1];
        }

        int[] sortedWalls = walls.clone();
        Arrays.sort(sortedWalls);

        int wallsOnRobotPositions = countWallsOnRobotPositions(sortedRobots, sortedWalls);

        int dpLeft = countInRange(
                sortedWalls,
                sortedRobots[0] - sortedDistance[0],
                sortedRobots[0] - 1);
        int dpRight = 0;

        for (int i = 0; i < n - 1; i++) {
            int rightOnly = countRightGapWalls(sortedRobots, sortedDistance, sortedWalls, i);
            int leftOnly = countLeftGapWalls(sortedRobots, sortedDistance, sortedWalls, i);
            int both = countBothGapWalls(sortedRobots, sortedDistance, sortedWalls, i);

            int nextLeft = Math.max(dpLeft + leftOnly, dpRight + both);
            int nextRight = Math.max(dpLeft, dpRight + rightOnly);

            dpLeft = nextLeft;
            dpRight = nextRight;
        }

        int rightTail = countInRange(
                sortedWalls,
                sortedRobots[n - 1] + 1,
                sortedRobots[n - 1] + sortedDistance[n - 1]);

        return wallsOnRobotPositions + Math.max(dpLeft, dpRight + rightTail);
    }
    private int countWallsOnRobotPositions(int[] robots, int[] walls) {
        int i = 0;
        int j = 0;
        int count = 0;

        while (i < robots.length && j < walls.length) {
            if (robots[i] == walls[j]) {
                count++;
                i++;
                j++;
            } else if (robots[i] < walls[j]) {
                i++;
            } else {
                j++;
            }
        }

        return count;
    }
    private int countRightGapWalls(int[] robots, int[] distance, int[] walls, int i) {
        int left = robots[i] + 1;
        int right = Math.min(robots[i] + distance[i], robots[i + 1] - 1);
        return countInRange(walls, left, right);
    }
    private int countLeftGapWalls(int[] robots, int[] distance, int[] walls, int i) {
        int left = Math.max(robots[i] + 1, robots[i + 1] - distance[i + 1]);
        int right = robots[i + 1] - 1;
        return countInRange(walls, left, right);
    }
    private int countBothGapWalls(int[] robots, int[] distance, int[] walls, int i) {
        int left1 = robots[i] + 1;
        int right1 = Math.min(robots[i] + distance[i], robots[i + 1] - 1);

        int left2 = Math.max(robots[i] + 1, robots[i + 1] - distance[i + 1]);
        int right2 = robots[i + 1] - 1;

        int count1 = countInRange(walls, left1, right1);
        int count2 = countInRange(walls, left2, right2);
        int overlap = countInRange(walls, Math.max(left1, left2), Math.min(right1, right2));

        return count1 + count2 - overlap;
    }
    private int countInRange(int[] walls, int left, int right) {
        if (left > right) {
            return 0;
        }

        int from = lowerBound(walls, left);
        int to = upperBound(walls, right);
        return to - from;
    }
    private int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
    private int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }}
