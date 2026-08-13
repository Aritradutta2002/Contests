package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC874_Walking_Robot_Simulation_Test {

    @Test
    public void testRobotSimExample1() {
        int[] commands = {4, -1, 3};
        int[][] obstacles = {};
        LC874_Walking_Robot_Simulation solver = new LC874_Walking_Robot_Simulation();
        assertEquals(25, solver.robotSim(commands, obstacles));
    }

    @Test
    public void testRobotSimExample2() {
        int[] commands = {4, -1, 4, -2, 4};
        int[][] obstacles = {{2, 4}};
        LC874_Walking_Robot_Simulation solver = new LC874_Walking_Robot_Simulation();
        assertEquals(65, solver.robotSim(commands, obstacles));
    }

    @Test
    public void testRobotSimNoMovement() {
        int[] commands = {-1, -1};
        int[][] obstacles = {};
        LC874_Walking_Robot_Simulation solver = new LC874_Walking_Robot_Simulation();
        assertEquals(0, solver.robotSim(commands, obstacles));
    }
}
