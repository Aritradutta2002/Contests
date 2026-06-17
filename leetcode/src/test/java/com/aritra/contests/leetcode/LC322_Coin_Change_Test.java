package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC322_Coin_Change_Test {

    @Test
    public void testStandardCase() {
        int[] coins = {1, 2, 5};
        assertEquals(3, LC322_Coin_Change.coinChange(coins, 11));
    }

    @Test
    public void testImpossible() {
        int[] coins = {2};
        assertEquals(-1, LC322_Coin_Change.coinChange(coins, 3));
    }

    @Test
    public void testZeroAmount() {
        int[] coins = {1};
        assertEquals(0, LC322_Coin_Change.coinChange(coins, 0));
    }
}
