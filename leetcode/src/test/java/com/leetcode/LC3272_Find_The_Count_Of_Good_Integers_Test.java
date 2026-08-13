package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3272_Find_The_Count_Of_Good_Integers_Test {

    @Test
    public void testExample1() {
        assertEquals(9, LC3272_Find_The_Count_Of_Good_Integers.countGoodIntegers(1, 1));
    }

    @Test
    public void testExample2() {
        assertEquals(4, LC3272_Find_The_Count_Of_Good_Integers.countGoodIntegers(1, 2));
    }

    @Test
    public void testExample3() {
        assertEquals(3, LC3272_Find_The_Count_Of_Good_Integers.countGoodIntegers(1, 3));
    }

    @Test
    public void testN2K1() {
        assertEquals(9, LC3272_Find_The_Count_Of_Good_Integers.countGoodIntegers(2, 1));
    }
}
