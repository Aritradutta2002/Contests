package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC781_Rabbits_In_Forest_Test {

    @Test
    public void testNumRabbitsExample1() {
        assertEquals(5, LC781_Rabbits_In_Forest.numRabbits(new int[]{1, 1, 2}));
    }

    @Test
    public void testNumRabbitsExample2() {
        assertEquals(11, LC781_Rabbits_In_Forest.numRabbits(new int[]{10, 10, 10}));
    }

    @Test
    public void testNumRabbitsSingle() {
        assertEquals(2, LC781_Rabbits_In_Forest.numRabbits(new int[]{1}));
    }

    @Test
    public void testNumRabbitsAllZero() {
        assertEquals(3, LC781_Rabbits_In_Forest.numRabbits(new int[]{0, 0, 0}));
    }
}
