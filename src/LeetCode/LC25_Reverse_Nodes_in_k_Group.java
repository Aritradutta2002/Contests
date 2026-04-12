package LeetCode;
import java.util.*;

/*
 * 25. Reverse Nodes in k-Group
 * 
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. 
 * If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * 
 * Constraints:
 * - The number of nodes in the list is n.
 * - 1 <= k <= n <= 5000
 * - 0 <= Node.val <= 1000
 */
public class LC25_Reverse_Nodes_in_k_Group {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode temp = head;
        int count = 0;
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        if (count == k) {
            ListNode reversedHead = reverse(head, k);
            head.next = reverseKGroup(temp, k);
            return reversedHead;
        }

        return head; 
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        while (k > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        return prev;
    }

    public static void main(String[] args) {
        LC25_Reverse_Nodes_in_k_Group solver = new LC25_Reverse_Nodes_in_k_Group();

        // Test Case 1: [1,2,3,4,5], k = 2 -> [2,1,4,3,5]
        ListNode head1 = createList(new int[]{1, 2, 3, 4, 5});
        runTest(solver, 1, head1, 2, new int[]{2, 1, 4, 3, 5});

        // Test Case 2: [1,2,3,4,5], k = 3 -> [3,2,1,4,5]
        ListNode head2 = createList(new int[]{1, 2, 3, 4, 5});
        runTest(solver, 2, head2, 3, new int[]{3, 2, 1, 4, 5});
    }

    private static ListNode createList(int[] vals) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : vals) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    private static void runTest(LC25_Reverse_Nodes_in_k_Group solver, int testId, ListNode head, int k, int[] expected) {
        ListNode result = solver.reverseKGroup(head, k);
        boolean pass = true;
        List<Integer> actualVals = new ArrayList<>();
        ListNode temp = result;
        int i = 0;
        while (temp != null) {
            actualVals.add(temp.val);
            if (i >= expected.length || temp.val != expected[i]) {
                pass = false;
            }
            temp = temp.next;
            i++;
        }
        if (i != expected.length) pass = false;

        if (pass) {
            System.out.println("Test " + testId + ": PASS");
        } else {
            System.out.println("Test " + testId + ": FAIL");
            System.out.println("  Expected: " + Arrays.toString(expected));
            System.out.println("  Actual:   " + actualVals);
        }
    }
}
