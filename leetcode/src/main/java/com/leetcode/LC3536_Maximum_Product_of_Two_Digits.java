package com.leetcode;
/**
 * 3536. Maximum Product of Two Digits
 * Given a positive integer n, return the maximum product of any two digits in n.
 * You may use the same digit twice if it appears more than once in n.
 * Constraints:
 * - 10 <= n <= 10^9
 */
class LC3536_Maximum_Product_of_Two_Digits {
    public int maxProduct(int n) {
        int largest = -1;
        int secondLargest = -1;

        while (n > 0) {
            int digit = n % 10;
            n /= 10;

            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest) {
                secondLargest = digit;
            }
        }

        return largest * secondLargest;
    }
}
