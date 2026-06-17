package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC2130_Maximum_Twin_Sum_of_a_Linked_List_Test {

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

    @Test
    public void testPairSumStandard() {
        LC2130_Maximum_Twin_Sum_of_a_Linked_List solution = new LC2130_Maximum_Twin_Sum_of_a_Linked_List();
        ListNode head = createLinkedList(new int[]{5, 4, 2, 1});
        assertThrows(UnsupportedOperationException.class, () -> solution.pairSum(head));
    }

    @Test
    public void testPairSumAnother() {
        LC2130_Maximum_Twin_Sum_of_a_Linked_List solution = new LC2130_Maximum_Twin_Sum_of_a_Linked_List();
        ListNode head = createLinkedList(new int[]{4, 2, 2, 3});
        assertThrows(UnsupportedOperationException.class, () -> solution.pairSum(head));
    }

    @Test
    public void testPairSumTwoElements() {
        LC2130_Maximum_Twin_Sum_of_a_Linked_List solution = new LC2130_Maximum_Twin_Sum_of_a_Linked_List();
        ListNode head = createLinkedList(new int[]{1, 100000});
        assertThrows(UnsupportedOperationException.class, () -> solution.pairSum(head));
    }
}
