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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int length = 0;
        while(curr!=null){
            curr = curr.next;
            length++;
        }

        int num = length/k;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int i = 0;
        ListNode prev = dummy;
         curr = head;
        while(i<num){
            for(int j=0;j<k-1;j++){
            ListNode move = curr.next;
            curr.next = move.next;
            move.next = prev.next;
            prev.next = move;
            }
                    prev = curr;
                 curr = curr.next;
                i++;
        }

        head = dummy.next;
        return head;
        

    }
}