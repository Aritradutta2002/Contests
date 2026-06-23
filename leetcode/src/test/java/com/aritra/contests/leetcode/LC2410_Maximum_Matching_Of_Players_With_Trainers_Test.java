package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2410_Maximum_Matching_Of_Players_With_Trainers_Test {

    @Test
    public void testStandardCase() {
        int[] players = {4,7,9};
        int[] trainers = {8,2,5,8};
        assertEquals(2, LC2410_Maximum_Matching_Of_Players_With_Trainers.matchPlayersAndTrainers(players, trainers));
    }

    @Test
    public void testNoMatch() {
        int[] players = {10,15};
        int[] trainers = {1,2,3};
        assertEquals(0, LC2410_Maximum_Matching_Of_Players_With_Trainers.matchPlayersAndTrainers(players, trainers));
    }
}
