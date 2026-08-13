package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC1861_Rotating_the_Box_Test {

    @Test
    public void testStandardCase() {
        LC1861_Rotating_the_Box solver = new LC1861_Rotating_the_Box();
        char[][] box = {{'#','.','#'}};
        char[][] expected = {{'.'},{'#'},{'#'}};
        assertArrayEquals(expected, solver.rotateTheBox(box));
    }

    @Test
    public void testWithObstacles() {
        LC1861_Rotating_the_Box solver = new LC1861_Rotating_the_Box();
        char[][] box = {{'#','*','.'},{'#','#','.'}};
        char[][] result = solver.rotateTheBox(box);
        assertEquals(3, result.length);
        assertEquals(2, result[0].length);
    }
}
