package LeetCode;
import java.util.*;
/*
 * 2751. Robot Collisions
 * 
 * There are n 1-indexed robots, each having a specific position, health, and direction
 * (L for left, R for right). All robots start moving at the same speed.
 * When two robots collide:
 * - The robot with lower health is removed.
 * - The other robot's health decreases by 1.
 * - If both have equal health, both are removed.
 * Return the health of the remaining robots in their original order.
 * 
 * Constraints:
 * - 1 <= positions.length == healths.length == directions.length() == n <= 10^5
 * - 1 <= positions[i], healths[i] <= 10^9
 * - directions[i] is 'L' or 'R'
 * - All positions are distinct.
 */
public class LC2751_Robot_Collisions {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Robot[] robots = new Robot[n];
        for (int i = 0; i < n; i++) {
            robots[i] = new Robot(positions[i], healths[i], directions.charAt(i), i);
        }
        Arrays.sort(robots, Comparator.comparingInt(r -> r.pos));

        Stack<Robot> stack = new Stack<>();
        for (Robot r : robots) {
            if (stack.isEmpty() || r.dir == 'L') {
                stack.push(r);
            } else {
                while (!stack.isEmpty() && stack.peek().dir == 'L') {
                    Robot left = stack.pop();
                    if (left.health < r.health) {
                        r.health -= 1;
                        if (left.health > 0) {
                            left.health = 0;
                            stack.push(left);
                        }
                    } else if (left.health > r.health) {
                        left.health -= 1;
                    } else {
                        if (left.health > 0) left.health = 0;
                    }
                }
                if (r.health > 0) stack.push(r);
            }
        }

        while (!stack.isEmpty() && stack.peek().dir == 'L') stack.pop();

        List<Integer> result = new ArrayList<>();
        Robot[] remaining = stack.toArray(new Robot[0]);
        Arrays.sort(remaining, Comparator.comparingInt(r -> r.idx));
        for (Robot r : remaining) {
            if (r.health > 0) result.add(r.health);
        }
        return result;
    }

    static class Robot {
        int pos, health, idx;
        char dir;
        Robot(int pos, int health, char dir, int idx) {
            this.pos = pos; this.health = health; this.dir = dir; this.idx = idx;
        }
    }

    public static void main(String[] args) {
        LC2751_Robot_Collisions solver = new LC2751_Robot_Collisions();

        // Test Case 1
        int[] pos1 = {5, 4, 3, 2, 1};
        int[] health1 = {2, 17, 9, 15, 10};
        String dir1 = "RRRRR";
        List<Integer> expected1 = Arrays.asList(2, 17, 9, 15, 10);
        runTest(solver, 1, pos1, health1, dir1, expected1);

        // Test Case 2
        int[] pos2 = {3, 5, 2, 6};
        int[] health2 = {10, 10, 15, 12};
        String dir2 = "RLRL";
        List<Integer> expected2 = Arrays.asList(14);
        runTest(solver, 2, pos2, health2, dir2, expected2);

        // Test Case 3
        int[] pos3 = {1, 2, 5, 6};
        int[] health3 = {10, 10, 11, 11};
        String dir3 = "RLRL";
        List<Integer> expected3 = Collections.emptyList();
        runTest(solver, 3, pos3, health3, dir3, expected3);
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
