/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        // Find length and tail
        int len = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        // Remove unnecessary rotations
        k = k % len;

        if (k == 0) {
            return head;
        }

        // Make circular
        tail.next = head;

        // Find new tail
        int steps = len - k - 1;

        ListNode newTail = head;

        for (int i = 0; i < steps; i++) {
            newTail = newTail.next;
        }

        // New head is after new tail
        ListNode newHead = newTail.next;

        // Break the circle
        newTail.next = null;

        return newHead;
    }
}