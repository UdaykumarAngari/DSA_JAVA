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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

       while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode first = head;
        ListNode second = reverse(slow.next);

        while(second != null){
            if(first.val != second.val){
                return false;
            }
            second = second.next;
            first = first.next;
        }
        return true;
    }

    public ListNode reverse(ListNode node){
        ListNode curr = node;
        ListNode prev = null;

        while(curr!=null){
            ListNode front = curr.next;

            curr.next = prev;

            prev = curr;

            curr = front;
        }

        return prev;
    }
}