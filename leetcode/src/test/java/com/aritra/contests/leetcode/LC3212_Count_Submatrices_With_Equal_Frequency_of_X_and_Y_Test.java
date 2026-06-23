package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC3212_Count_Submatrices_With_Equal_Frequency_of_X_and_Y_Test {

    @Test
    public void testExample1() {
        char[][] grid = {{'X', 'Y', '.'}, {'Y', '.', '.'}};
        assertEquals(3, LC3212_Count_Submatrices_With_Equal_Frequency_of_X_and_Y.numberOfSubmatrices(grid));
    }

    @Test
    public void testExample2() {
        char[][] grid = {{'X', 'X'}, {'X', 'Y'}};
        assertEquals(0, LC3212_Count_Submatrices_With_Equal_Frequency_of_X_and_Y.numberOfSubmatrices(grid));
    }

    @Test
    public void testExample3() {
        char[][] grid = {{'.', '.'}, {'.', '.'}};
        assertEquals(0, LC3212_Count_Submatrices_With_Equal_Frequency_of_X_and_Y.numberOfSubmatrices(grid));
    }
}
