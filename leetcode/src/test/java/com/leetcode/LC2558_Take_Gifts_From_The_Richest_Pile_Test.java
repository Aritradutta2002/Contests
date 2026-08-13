package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2558_Take_Gifts_From_The_Richest_Pile_Test {

    @Test
    public void testPickGifts() {
        int[] gifts = {25, 64, 9, 4, 100};
        int[] result = LC2558_Take_Gifts_From_The_Richest_Pile.pickGifts(gifts, 4);
        assertEquals(5, result.length);
    }
}
