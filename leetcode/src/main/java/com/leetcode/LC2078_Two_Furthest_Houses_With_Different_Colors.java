package com.leetcode;
import java.util.*;

/**
 * 2078. Two Furthest Houses With Different Colors
 * 
 * There are n houses evenly lined up on the street, and each house is beautifully painted.
 * You are given a 0-indexed integer array colors of length n, where colors[i] represents the color of the ith house.
 * 
 * Return the maximum distance between two houses with different colors.
 * 
 * The distance between the ith and jth houses is abs(i - j), where abs(x) is the absolute value of x.
 * 
 * Constraints:
 * - n == colors.length
 * - 2 <= n <= 100
 * - 0 <= colors[i] <= 100
 * - Test data are generated such that at least two houses have different colors.
 * 
 * Example 1:
 * Input: colors = [1,1,1,6,1,1,1]
 * Output: 3
 * 
 * Example 2:
 * Input: colors = [1,8,3,8,3]
 * Output: 4
 * 
 * Example 3:
 * Input: colors = [0,1]
 * Output: 1
 */

public class LC2078_Two_Furthest_Houses_With_Different_Colors {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int maxDist = 0;
        
        // Find farthest house from the first house
        for(int i = 0; i < n; i++){
            if(colors[i] != colors[0]){
                maxDist = Math.max(maxDist, i);
            }
        }

        // Find farthest house from the last house
        for(int i = 0; i < n; i++){
            if(colors[i] != colors[n - 1]){
                maxDist = Math.max(maxDist, n - 1 - i);
            }
        }
        
        return maxDist;
    }
}
