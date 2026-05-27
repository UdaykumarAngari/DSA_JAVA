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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // int len = 0;

        // ListNode curr = head;

        // // find length
        // while(curr != null){

        //     len++;

        //     curr = curr.next;
        // }

        // // remove head
        // if(n == len){

        //     return head.next;
        // }

        // int target = len - n;

        // curr = head;

        // // move to node before deletion
        // for(int i = 1; i < target; i++){

        //     curr = curr.next;
        // }

        // // delete node
        // curr.next = curr.next.next;

        // return head;


        ListNode dummy = new ListNode(0);

        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // move fast n+1 steps
        for(int i = 0; i <= n; i++){

            fast = fast.next;
        }

        // move both
        while(fast != null){

            fast = fast.next;

            slow = slow.next;
        }

        // remove node
        slow.next = slow.next.next;

        return dummy.next;
    }
}