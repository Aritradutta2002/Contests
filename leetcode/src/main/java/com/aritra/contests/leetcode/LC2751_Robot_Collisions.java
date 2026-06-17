package com.aritra.contests.leetcode;
import java.util.*;
/*
 * Problem 2751: Robot Collisions
 * 
 * Description:
 * There are n robots, each with a position on a line, a health value, and a direction.
 * You are given three inputs:
 *   - positions[i]: the position of the i-th robot on the line
 *   - healths[i]: the health of the i-th robot
 *   - directions[i]: the direction of the i-th robot ('L' for left, 'R' for right)
 * 
 * All robots move at the same speed simultaneously. When two robots collide at the same position:
 *   - The robot with lower health is removed from the line.
 *   - The robot with higher health survives, but its health decreases by 1.
 *   - If both robots have equal health, both are removed from the line.
 * 
 * Return the healths of all surviving robots in the same order as they appear in the input.
 * 
 * Constraints:
 * - 1 <= positions.length == healths.length == directions.length() == n <= 10^5
 * - 1 <= positions[i], healths[i] <= 10^9
 * - directions[i] is either 'L' or 'R'
 * - All values in positions are distinct
 */
public class LC2751_Robot_Collisions {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (i, j) -> Integer.compare(positions[i], positions[j]));

        Stack<Integer> rightMovingRobots = new Stack<>();

        for (int robot : indices) {
            if (directions.charAt(robot) == 'R') {
                rightMovingRobots.push(robot);
            } else {
                while (!rightMovingRobots.isEmpty() && healths[robot] > 0) {
                    int opponent = rightMovingRobots.pop();

                    if (healths[opponent] > healths[robot]) {
                        healths[opponent]--;
                        healths[robot] = 0;
                        rightMovingRobots.push(opponent);
                    } else if (healths[opponent] < healths[robot]) {
                        healths[robot]--;
                        healths[opponent] = 0;
                    } else {
                        healths[robot] = 0;
                        healths[opponent] = 0;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int health : healths) {
            if (health > 0) {
                result.add(health);
            }
        }
        return result;
    }
    private static void runTest(LC2751_Robot_Collisions solver, int testId, int[] positions, int[] healths, String directions, List<Integer> expected) {
        try {
            List<Integer> result = solver.survivedRobotsHealths(positions, healths, directions);
            if (result.equals(expected)) {
                System.out.println("Test " + testId + ": PASS");
            } else {
                System.out.println("Test " + testId + ": FAIL");
                System.out.println("  Expected: " + expected);
                System.out.println("  Actual:   " + result);
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Test " + testId + ": SKIPPED (Not implemented)");
        } catch (Exception e) {
            System.out.println("Test " + testId + ": ERROR (" + e.getMessage() + ")");
        }
    }
}
