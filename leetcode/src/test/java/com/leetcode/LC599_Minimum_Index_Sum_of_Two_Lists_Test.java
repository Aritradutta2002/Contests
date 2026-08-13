package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC599_Minimum_Index_Sum_of_Two_Lists_Test {

    @Test
    public void testStandardCase() {
        LC599_Minimum_Index_Sum_of_Two_Lists solver = new LC599_Minimum_Index_Sum_of_Two_Lists();
        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
        assertArrayEquals(new String[]{"Shogun"}, solver.findRestaurant(list1, list2));
    }

    @Test
    public void testMultipleCommon() {
        LC599_Minimum_Index_Sum_of_Two_Lists solver = new LC599_Minimum_Index_Sum_of_Two_Lists();
        String[] list1 = {"happy","sad","good"};
        String[] list2 = {"sad","happy","good"};
        String[] result = solver.findRestaurant(list1, list2);
        assertEquals(2, result.length);
    }
}
