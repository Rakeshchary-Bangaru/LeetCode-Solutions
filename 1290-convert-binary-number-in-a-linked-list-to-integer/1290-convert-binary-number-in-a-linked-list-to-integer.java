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
    public int getDecimalValue(ListNode head) {
        ListNode curr = head;
        if(head==null) return 0;

        int num =0;
        num = curr.val;
        while(curr.next!=null){
            curr = curr.next;
            num = 2*num + curr.val;
        }

        return num;

    }
}