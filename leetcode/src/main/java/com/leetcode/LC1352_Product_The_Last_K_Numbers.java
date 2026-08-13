package com.leetcode;

import java.util.*;

/*
 * 1352. Product of the Last K Numbers
 *
 * Design an algorithm that accepts a stream of integers and retrieves the product of the last k
 * integers in the stream.
 *
 * Constraints:
 * - 0 <= num <= 100
 * - 1 <= k <= 4 * 10^4
 * - At most 4 * 10^4 calls will be made to add and getProduct
 * - The product of any contiguous stream of numbers fits in a 32-bit integer
 */
public class LC1352_Product_The_Last_K_Numbers {
    static class ProductOfNumbers {
        // Stores cumulative product of the stream
        private ArrayList<Integer> prefixProduct = new ArrayList<>();
        private int size = 0;

        public ProductOfNumbers() {
            // Initialize the product list with 1 to handle multiplication logic
            this.prefixProduct.add(1);
            this.size = 0;
        }
    public void add(int num) {
            if (num == 0) {
                // If num is 0, reset the cumulative products since multiplication
                // with 0 invalidates previous products
                this.prefixProduct = new ArrayList<Integer>();
                this.prefixProduct.add(1);
                this.size = 0;
            } else {
                // Append the cumulative product of the current number with the last
                // product
                this.prefixProduct.add(this.prefixProduct.get(size) * num);
                this.size++;
            }
        }
    public int getProduct(int k) {
            // Check if the requested product length exceeds the size of the valid
            // product list
            if (k > this.size)
                return 0;

            // Compute the product of the last k elements using division
            return (this.prefixProduct.get(this.size) /
                    this.prefixProduct.get(this.size - k));
        }
    }

}
