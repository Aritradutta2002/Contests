package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3418_Maximum_Amount_Of_Money_Robot_Can_Earn_Test {

    @Test
    public void testExample1() {
        LC3418_Maximum_Amount_Of_Money_Robot_Can_Earn solver = new LC3418_Maximum_Amount_Of_Money_Robot_Can_Earn();
        int[][] coins = {{0, 1, -1}, {1, -2, 3}, {2, -3, 4}};
        assertEquals(8, solver.maximumAmount(coins));
    }

    @Test
    public void testExample2() {
        LC3418_Maximum_Amount_Of_Money_Robot_Can_Earn solver = new LC3418_Maximum_Amount_Of_Money_Robot_Can_Earn();
        int[][] coins = {{10, 10, 10}, {10, 10, 10}};
        assertEquals(40, solver.maximumAmount(coins));
    }
}
