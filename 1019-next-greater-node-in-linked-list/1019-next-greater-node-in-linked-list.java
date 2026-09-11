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
        Stack<int[]> stack = new Stack<>();
        int length = 0;
        ListNode temp = head;

        while(temp != null){
            length++;
            temp = temp.next;
        }
        temp = head;
        int[] result = new int[length];
        int index = 0;
        while(temp!=null){
            while(!stack.isEmpty() && temp.val > stack.peek()[0]){
                result[stack.pop()[1]] = temp.val;
            }

            stack.push(new int[]{temp.val,index});
            index++;
            temp = temp.next;
        }

        return result;
    }
}