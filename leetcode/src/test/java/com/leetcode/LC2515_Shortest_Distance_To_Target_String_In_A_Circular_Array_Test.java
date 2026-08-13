package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2515_Shortest_Distance_To_Target_String_In_A_Circular_Array_Test {

    @Test
    public void testStandardCase() {
        LC2515_Shortest_Distance_To_Target_String_In_A_Circular_Array solver = new LC2515_Shortest_Distance_To_Target_String_In_A_Circular_Array();
        String[] words = {"hello","i","am","leetcode","hello"};
        assertEquals(1, solver.closetTarget(words, "hello", 1));
    }

    @Test
    public void testTargetNotFound() {
        LC2515_Shortest_Distance_To_Target_String_In_A_Circular_Array solver = new LC2515_Shortest_Distance_To_Target_String_In_A_Circular_Array();
        String[] words = {"i","eat","leetcode"};
        assertEquals(-1, solver.closetTarget(words, "ate", 0));
    }
}
