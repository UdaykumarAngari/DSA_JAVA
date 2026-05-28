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

    //Converting to list and sort return the head
    // public ListNode sortedLinkedList(List list){
    //     ListNode temp = new ListNode(0);
    //     ListNode curr = temp;
        
    //     int n = list.size();
    //     int i = 0;
    //     while(i<n){
    //         ListNode newNode = new ListNode((int)list.get(i++));
    //         curr.next = newNode;
    //         newNode.next = null;
    //         curr = curr.next;
    //     }
    //     return temp.next;
    // }
    // public ListNode toArrayList(ListNode head){
    //     List<Integer> list = new ArrayList<>();
        
    //     ListNode temp = head;
        
    //     while(temp!=null){
    //         list.add(temp.val);
    //         temp = temp.next;
    //     }

    //     Collections.sort(list);

    //     return sortedLinkedList(list);
    // }

    public ListNode sortList(ListNode head) {
        
        if(head==null || head.next==null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast != null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;

        //sorting left half
        ListNode left = sortList(head);
        
        
        //sorting right half
        ListNode right = sortList(slow);

        //merge sorted halves
        return merge(left, right);
        
        //return toArrayList(head);
    }

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(l1!=null && l2!=null){
            if(l1.val <= l2.val){
                tail.next = l1;
                l1 = l1.next;
            }
            else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if(l1 != null){
            tail.next = l1;
        }

        if(l2 != null){
            tail.next = l2;
        }

        return dummy.next;
    }
}