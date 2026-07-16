package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2095_Delete_the_Middle_Node_of_a_Linked_List_Test {

    private ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    private boolean compareLinkedListWithArray(ListNode head, int[] arr) {
        ListNode curr = head;
        int i = 0;
        while (curr != null && i < arr.length) {
            if (curr.val != arr[i]) return false;
            curr = curr.next;
            i++;
        }
        return curr == null && i == arr.length;
    }

    @Test
    public void testDeleteMiddleOddLength() {
        LC2095_Delete_the_Middle_Node_of_a_Linked_List solution = new LC2095_Delete_the_Middle_Node_of_a_Linked_List();
        ListNode head = createLinkedList(new int[]{1, 3, 4, 7, 1, 2, 6});
        ListNode result = solution.deleteMiddle(head);
        assertTrue(compareLinkedListWithArray(result, new int[]{1, 3, 4, 1, 2, 6}));
    }

    @Test
    public void testDeleteMiddleEvenLength() {
        LC2095_Delete_the_Middle_Node_of_a_Linked_List solution = new LC2095_Delete_the_Middle_Node_of_a_Linked_List();
        ListNode head = createLinkedList(new int[]{1, 2, 3, 4});
        ListNode result = solution.deleteMiddle(head);
        assertTrue(compareLinkedListWithArray(result, new int[]{1, 2, 4}));
    }

    @Test
    public void testDeleteMiddleTwoElements() {
        LC2095_Delete_the_Middle_Node_of_a_Linked_List solution = new LC2095_Delete_the_Middle_Node_of_a_Linked_List();
        ListNode head = createLinkedList(new int[]{2, 1});
        ListNode result = solution.deleteMiddle(head);
        assertTrue(compareLinkedListWithArray(result, new int[]{2}));
    }
}
