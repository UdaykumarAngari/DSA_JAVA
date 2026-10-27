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
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        ArrayList<Integer> list = new ArrayList<>();

        ListNode curr = head;

        while(curr != null){
            list.add(curr.val);
            curr = curr.next;
        }

        int n = list.size();

        int[] result = new int[n];
        result[n-1] = 0;

        for(int i = n - 1 ; i >= 0 ; i--){
            
            int val = list.get(i);

            while(!stack.isEmpty() && stack.peek() <= val){
                stack.pop();
            }
            

            if(!stack.isEmpty() && stack.peek() > val){
                result[i] = stack.peek();
                stack.push(val);
            }

            if(stack.isEmpty()){
                stack.push(val);
            }

        }

        return result;


    }
}