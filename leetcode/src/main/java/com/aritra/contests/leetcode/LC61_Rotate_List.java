package com.aritra.contests.leetcode;

import java.util.*;

/**
 * 61. Rotate List
 *
 * Description:
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 * Constraints:
 * - The number of nodes in the list is in the range [0, 500]
 * - -100 <= Node.val <= 100
 * - 0 <= k <= 2 * 10^9
 */
public class LC61_Rotate_List {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        tail.next = head;

        int steps = len - (k % len);
        if (steps == len) {
            tail.next = null;
            return head;
        }

        ListNode newTail = head;
        for (int i = 0; i < steps - 1; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        LC61_Rotate_List solution = new LC61_Rotate_List();

        // Test Case 1
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode expected1 = new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(2, new ListNode(3)))));
        ListNode result1 = solution.rotateRight(head1, 2);
        System.out.println("Test 1: " + (listEquals(result1, expected1) ? "Pass" : "Fail"));

        // Test Case 2
        ListNode head2 = new ListNode(0, new ListNode(1, new ListNode(2)));
        ListNode expected2 = new ListNode(2, new ListNode(0, new ListNode(1)));
        ListNode result2 = solution.rotateRight(head2, 4);
        System.out.println("Test 2: " + (listEquals(result2, expected2) ? "Pass" : "Fail"));

        // Test Case 3
        ListNode head3 = new ListNode(1);
        ListNode expected3 = new ListNode(1);
        ListNode result3 = solution.rotateRight(head3, 0);
        System.out.println("Test 3: " + (listEquals(result3, expected3) ? "Pass" : "Fail"));
    }

    private static boolean listEquals(ListNode a, ListNode b) {
        while (a != null && b != null) {
            if (a.val != b.val) return false;
            a = a.next;
            b = b.next;
        }
        return a == null && b == null;
    }
}
