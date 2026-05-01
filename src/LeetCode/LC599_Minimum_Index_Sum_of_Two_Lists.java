package LeetCode;
import java.util.*;

/*
 * Problem 599: Minimum Index Sum of Two Lists
 * 
 * Description:
 * Given two arrays of strings list1 and list2, find the common strings with the least index sum.
 * A common string is a string that appeared in both list1 and list2.
 * A common string with the least index sum is a common string such that if it appeared at
 * list1[i] and list2[j] then i + j should be the minimum value among all the other common strings.
 * Return all the common strings with the least index sum in any order.
 * 
 * Constraints:
 * - 1 <= list1.length, list2.length <= 1000
 * - 1 <= list1[i].length, list2[i].length <= 30
 * - list1[i] and list2[i] consist of spaces ' ' and English letters.
 * - All the strings of list1 are unique.
 * - All the strings of list2 are unique.
 */
public class LC599_Minimum_Index_Sum_of_Two_Lists {

    public String[] findRestaurant(String[] list1, String[] list2) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public static void main(String[] args) {
        LC599_Minimum_Index_Sum_of_Two_Lists solution = new LC599_Minimum_Index_Sum_of_Two_Lists();

        // Test case 1
        String[] list1_1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2_1 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        // Expected: ["Shogun"]
        System.out.println("Test 1: " + Arrays.toString(solution.findRestaurant(list1_1, list2_1)));

        // Test case 2
        String[] list1_2 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2_2 = {"KFC", "Shogun", "Burger King"};
        // Expected: ["Shogun"]
        System.out.println("Test 2: " + Arrays.toString(solution.findRestaurant(list1_2, list2_2)));

        // Test case 3
        String[] list1_3 = {"happy", "sad", "good"};
        String[] list2_3 = {"sad", "happy", "good"};
        // Expected: ["sad", "happy"] or ["happy", "sad"]
        System.out.println("Test 3: " + Arrays.toString(solution.findRestaurant(list1_3, list2_3)));
    }
}
