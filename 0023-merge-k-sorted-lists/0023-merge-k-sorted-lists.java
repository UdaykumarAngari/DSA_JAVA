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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while (!pq.isEmpty()) {

            ListNode smallest = pq.poll();

            curr.next = smallest;
            curr = curr.next;

            if (smallest.next != null) {
                pq.offer(smallest.next);
            }
        }

        return dummy.next;

    }
 
}