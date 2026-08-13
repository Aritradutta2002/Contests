package com.leetcode;
import java.util.*;
/**
 * 2540. Minimum Common Value
 *
 * Given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * return the minimum integer common to both arrays. If there is no common
 * integer, return -1.
 *
 * Note: An integer is considered common if it appears in both arrays.
 *
 * Constraints:
 * - 1 <= nums1.length, nums2.length <= 10^5
 * - 1 <= nums1[i], nums2[j] <= 10^9
 * - Both nums1 and nums2 are sorted in non-decreasing order.
 *
 * Example 1:
 * Input:  nums1 = [1,2,3], nums2 = [2,4]
 * Output: 2
 * Explanation: The smallest common element is 2.
 *
 * Example 2:
 * Input:  nums1 = [1,2,3,6], nums2 = [2,3,4,5]
 * Output: 2
 * Explanation: There are two common elements: 2 and 3. The minimum is 2.
 */
class LC2540_Minimum_Common_Value {

    public int getCommon(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums1){
            set.add(i);
        }
        for(int i : nums2){
            if(set.contains(i)){
                return i;
            }
        }
        return -1;
    }

}
