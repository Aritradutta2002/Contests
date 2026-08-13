package com.leetcode;
import java.util.*;
/*
 * 874. Walking Robot Simulation
 * 
 * A robot on an infinite XY-plane starts at point (0, 0) facing north. 
 * The robot can receive a sequence of these three possible types of commands:
 * - -2: Turn left 90 degrees.
 * - -1: Turn right 90 degrees.
 * - 1 <= k <= 9: Move forward k units, one unit at a time.
 * 
 * Some of the grid squares are obstacles. The ith obstacle is at grid point 
 * obstacles[i] = (xi, yi). If the robot runs into an obstacle, then it will 
 * instead stay in its current location and move on to the next command.
 * 
 * Return the maximum Euclidean distance that the robot ever gets from the 
 * origin squared (i.e. if the distance is 5, return 25).
 * 
 * Constraints:
 * - 1 <= commands.length <= 10^4
 * - commands[i] is either -2, -1, or an integer in the range [1, 9].
 * - 0 <= obstacles.length <= 10^4
 * - -3 * 10^4 <= xi, yi <= 3 * 10^4
 * - The answer is guaranteed to be less than 2^31.
 */
public class LC874_Walking_Robot_Simulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        // Directions: North, East, South, West
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0; // start facing North
        int x = 0, y = 0;
        int maxDist = 0;

        Set<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(obs[0] + "," + obs[1]);
        }

        for (int cmd : commands) {
            if (cmd == -2) {
                dir = (dir + 3) % 4; // turn left
            } else if (cmd == -1) {
                dir = (dir + 1) % 4; // turn right
            } else {
                for (int step = 0; step < cmd; step++) {
                    int nx = x + dirs[dir][0];
                    int ny = y + dirs[dir][1];
                    if (obstacleSet.contains(nx + "," + ny)) {
                        break;
                    }
                    x = nx;
                    y = ny;
                    maxDist = Math.max(maxDist, x * x + y * y);
                }
            }
        }
        return maxDist;
    }
}
