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
    public ListNode deleteMiddle(ListNode head) {
        
        //in case of single node
        if(head == null || head.next == null){

            return null;
        }

        //using 3 pointers
        // ListNode slow = head;
        // ListNode fast = head;
        // ListNode prev = null;

        // while(fast!=null && fast.next!=null){
        //     prev = slow;
        //     slow = slow.next;
        //     fast = fast.next.next;
        // }

        // prev.next = slow.next;

        //only using 2 pointers
        ListNode fast=head;
        ListNode slow=new ListNode(-1);
        slow.next=head;
        while(fast!=null && fast.next!=null ){
            fast=fast.next.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        

        return head;
    }
}