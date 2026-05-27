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
    public ListNode oddEvenList(ListNode head) {
    
        if(head == null){
            return null;
        }

        ListNode curr = head;
        
        ListNode oddNode = new ListNode(0);
        ListNode evenNode = new ListNode(0);

        ListNode odd = oddNode;
        ListNode even = evenNode;
        int count = 1;
        while(curr!=null){
            if(count %2 != 0){
                odd.next = curr;
                odd = odd.next;
            }
            else{
                even.next = curr;
                even = even.next;
            }
            count++;
            curr = curr.next;
        }

        odd.next = evenNode.next;
        even.next = null;

        return oddNode.next;


    }
}