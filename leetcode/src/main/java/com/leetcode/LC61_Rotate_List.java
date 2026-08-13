package com.leetcode;

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
}
