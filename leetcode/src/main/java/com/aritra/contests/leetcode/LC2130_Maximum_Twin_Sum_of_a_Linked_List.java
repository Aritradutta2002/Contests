package com.aritra.contests.leetcode;

import java.util.*;
import java.io.*;

/**
 * 2130. Maximum Twin Sum of a Linked List
 *
 * Description:
 * In a linked list of size n, where n is even, the i-th node (0-indexed) is the twin of the (n-1-i)-th node if 0 <= i <= (n / 2) - 1.
 * For example, if n = 4, node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins.
 * The twin sum is defined as the sum of a node and its twin.
 * Given the head of a linked list with even length, return the maximum twin sum of the linked list.
 *
 * Constraints:
 * - The number of nodes in the list is an even integer in the range [2, 10^5].
 * - 1 <= Node.val <= 10^5
 */
public class LC2130_Maximum_Twin_Sum_of_a_Linked_List {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int pairSum(ListNode head) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public static void main(String[] args) {
        LC2130_Maximum_Twin_Sum_of_a_Linked_List solution = new LC2130_Maximum_Twin_Sum_of_a_Linked_List();

        // Test Case 1: head = [5,4,2,1]
        // Twin sums: (5+1)=6, (4+2)=6. Max = 6.
        ListNode head1 = createLinkedList(new int[]{5, 4, 2, 1});
        int expected1 = 6;
        try {
            int result1 = solution.pairSum(head1);
            System.out.println("Test Case 1: " + (result1 == expected1 ? "Pass" : "Fail (Expected " + expected1 + ", got " + result1 + ")"));
        } catch (UnsupportedOperationException e) {
            System.out.println("Test Case 1: Fail (Not implemented)");
        }

        // Test Case 2: head = [4,2,2,3]
        // Twin sums: (4+3)=7, (2+2)=4. Max = 7.
        ListNode head2 = createLinkedList(new int[]{4, 2, 2, 3});
        int expected2 = 7;
        try {
            int result2 = solution.pairSum(head2);
            System.out.println("Test Case 2: " + (result2 == expected2 ? "Pass" : "Fail (Expected " + expected2 + ", got " + result2 + ")"));
        } catch (UnsupportedOperationException e) {
            System.out.println("Test Case 2: Fail (Not implemented)");
        }

        // Test Case 3: head = [1, 100000]
        // Only one pair: (1+100000)=100001. Max = 100001.
        ListNode head3 = createLinkedList(new int[]{1, 100000});
        int expected3 = 100001;
        try {
            int result3 = solution.pairSum(head3);
            System.out.println("Test Case 3: " + (result3 == expected3 ? "Pass" : "Fail (Expected " + expected3 + ", got " + result3 + ")"));
        } catch (UnsupportedOperationException e) {
            System.out.println("Test Case 3: Fail (Not implemented)");
        }
    }

    private static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }
}
