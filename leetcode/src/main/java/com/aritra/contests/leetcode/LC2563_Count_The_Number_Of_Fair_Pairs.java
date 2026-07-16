package com.aritra.contests.leetcode;
import java.util.*;
@SuppressWarnings("unused")
/*
 * 2563. Count the Number of Fair Pairs
 *
 * Given a 0-indexed integer array nums and integers lower and upper, return the number of pairs (i, j)
 * where 0 <= i < j < n and lower <= nums[i] + nums[j] <= upper.
 *
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - -10^9 <= nums[i] <= 10^9
 * - -10^9 <= lower <= upper <= 10^9
 */
public class LC2563_Count_The_Number_Of_Fair_Pairs {
    public static long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        
        for (int i = 0; i < n - 1; i++){
            int upperBound = upper_bound(nums, i + 1, n, upper - nums[i]);
            int lowerBound = lower_bound(nums, i + 1, n, lower - nums[i]);
            ans += (upperBound - lowerBound);
        }

        return (long) ans;
    }
    static int lower_bound(int arr[], int start, int N, int X){
        int mid, low = start, high = N;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (X <= arr[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        if (low < N && arr[low] < X) {
            low++;
        }
        return low;
    }
    static int upper_bound(int arr[], int start, int N, int X){
        int mid;
        int low = start, high = N;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (X >= arr[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (low < N && arr[low] <= X) {
            low++;
        }
        return low;
    }
}

