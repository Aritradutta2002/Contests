package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC762_Prime_Number_Of_Set_Bits_In_Binary_Representation_Test {

    @Test
    public void testCountPrimeSetBitsExample1() {
        assertEquals(4, LC762_Prime_Number_Of_Set_Bits_In_Binary_Representation.countPrimeSetBits(6, 10));
    }

    @Test
    public void testCountPrimeSetBitsExample2() {
        assertEquals(5, LC762_Prime_Number_Of_Set_Bits_In_Binary_Representation.countPrimeSetBits(10, 15));
    }

    @Test
    public void testCountPrimeSetBitsSingle() {
        assertEquals(0, LC762_Prime_Number_Of_Set_Bits_In_Binary_Representation.countPrimeSetBits(1, 1));
    }
}
