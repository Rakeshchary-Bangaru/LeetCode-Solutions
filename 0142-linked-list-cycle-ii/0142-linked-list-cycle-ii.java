/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode temp = head;
        int marker = Integer.MAX_VALUE;
        while(temp!=null){
           if(temp.val == marker){
            return temp;
           }
           temp.val = marker;
           temp = temp.next;
           
        }
        return null;
        
    }
}