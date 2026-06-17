package com.aritra.contests.leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LC61_Rotate_List_Test {

    @Test
    public void testRotateRightStandard() {
        LC61_Rotate_List solution = new LC61_Rotate_List();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode expected = new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(2, new ListNode(3)))));
        ListNode result = solution.rotateRight(head, 2);
        assertTrue(listEquals(result, expected));
    }

    @Test
    public void testRotateRightWithWrap() {
        LC61_Rotate_List solution = new LC61_Rotate_List();
        ListNode head = new ListNode(0, new ListNode(1, new ListNode(2)));
        ListNode expected = new ListNode(2, new ListNode(0, new ListNode(1)));
        ListNode result = solution.rotateRight(head, 4);
        assertTrue(listEquals(result, expected));
    }

    @Test
    public void testRotateRightSingleElement() {
        LC61_Rotate_List solution = new LC61_Rotate_List();
        ListNode head = new ListNode(1);
        ListNode expected = new ListNode(1);
        ListNode result = solution.rotateRight(head, 0);
        assertTrue(listEquals(result, expected));
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
