package com.aritra.contests.leetcode;
import java.util.*;
import java.io.*;

/**
 * 2095. Delete the Middle Node of a Linked List
 *
 * Description:
 * You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
 * The middle node of a linked list of size n is the floor(n / 2)-th node from the start using 0-based indexing.
 *
 * Constraints:
 * - The number of nodes in the list is in the range [1, 10^5].
 * - 1 <= Node.val <= 10^5
 */
public class LC2095_Delete_the_Middle_Node_of_a_Linked_List {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteMiddle(ListNode head) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public static void main(String[] args) {
        LC2095_Delete_the_Middle_Node_of_a_Linked_List solution = new LC2095_Delete_the_Middle_Node_of_a_Linked_List();

        // Test Case 1: head = [1,3,4,7,1,2,6]
        // n = 7, middle index = floor(7/2) = 3. Node at index 3 is 7.
        // Expected Output: [1,3,4,1,2,6]
        ListNode head1 = createLinkedList(new int[]{1, 3, 4, 7, 1, 2, 6});
        int[] expected1 = {1, 3, 4, 1, 2, 6};
        System.out.print("Test Case 1: ");
        verify(solution, head1, expected1);

        // Test Case 2: head = [1,2,3,4]
        // n = 4, middle index = floor(4/2) = 2. Node at index 2 is 3.
        // Expected Output: [1,2,4]
        ListNode head2 = createLinkedList(new int[]{1, 2, 3, 4});
        int[] expected2 = {1, 2, 4};
        System.out.print("Test Case 2: ");
        verify(solution, head2, expected2);

        // Test Case 3: head = [2,1]
        // n = 2, middle index = floor(2/2) = 1. Node at index 1 is 1.
        // Expected Output: [2]
        ListNode head3 = createLinkedList(new int[]{2, 1});
        int[] expected3 = {2};
        System.out.print("Test Case 3: ");
        verify(solution, head3, expected3);
    }

    private static void verify(LC2095_Delete_the_Middle_Node_of_a_Linked_List solution, ListNode head, int[] expected) {
        try {
            ListNode result = solution.deleteMiddle(head);
            if (compareLinkedListWithArray(result, expected)) {
                System.out.println("Pass");
            } else {
                System.out.println("Fail");
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Fail (Not implemented)");
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

    private static boolean compareLinkedListWithArray(ListNode head, int[] arr) {
        ListNode curr = head;
        int i = 0;
        while (curr != null && i < arr.length) {
            if (curr.val != arr[i]) return false;
            curr = curr.next;
            i++;
        }
        return curr == null && i == arr.length;
    }
}
