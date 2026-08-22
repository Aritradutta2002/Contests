package com.leetcode;
import java.util.*;
import java.io.*;
/**
 * 3622. Check Divisibility by Digit Sum and Product
 *
 * You are given a positive integer n. Determine whether n is divisible by the sum of the following two values:
 * 
 * 	
 *  - 
 * 	
 * The digit sum of n (the sum of its digits).
 * 	
 * 	
 *  - 
 * 	
 * The digit product of n (the product of its digits).
 * 	
 * 
 * Return true if n is divisible by this sum; otherwise, return false.
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: n = 99
 * ...
 */
public class LC3622_Check_Divisibility_by_Digit_Sum_and_Product {
    public boolean checkDivisibility(int n) { 
        int copy = n;
        int sum = 0;
        int multiplication = 1;
        while(copy > 0){
            sum += copy % 10;
            multiplication *= copy % 10;
            copy /= 10;
        }
        return (n % (sum + multiplication) == 0);
    }
}