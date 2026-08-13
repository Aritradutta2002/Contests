package com.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC25_Reverse_Nodes_in_k_Group_Test {

    private ListNode createList(int[] vals) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : vals) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    private boolean listEquals(ListNode a, int[] expected) {
        ListNode curr = a;
        int i = 0;
        while (curr != null && i < expected.length) {
            if (curr.val != expected[i]) return false;
            curr = curr.next;
            i++;
        }
        return curr == null && i == expected.length;
    }

    @Test
    public void testReverseKGroupK2() {
        LC25_Reverse_Nodes_in_k_Group solver = new LC25_Reverse_Nodes_in_k_Group();
        ListNode head = createList(new int[]{1, 2, 3, 4, 5});
        ListNode result = solver.reverseKGroup(head, 2);
        assertTrue(listEquals(result, new int[]{2, 1, 4, 3, 5}));
    }

    @Test
    public void testReverseKGroupK3() {
        LC25_Reverse_Nodes_in_k_Group solver = new LC25_Reverse_Nodes_in_k_Group();
        ListNode head = createList(new int[]{1, 2, 3, 4, 5});
        ListNode result = solver.reverseKGroup(head, 3);
        assertTrue(listEquals(result, new int[]{3, 2, 1, 4, 5}));
    }
}
