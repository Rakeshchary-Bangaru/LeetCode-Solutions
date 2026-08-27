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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while(curr!=null){
            ListNode runner = curr;
            while(runner.next!=null){
                if(curr.val == runner.next.val){
                    runner.next = runner.next.next;
                }
                else{
                    runner = runner.next;
                }
            }
            curr = curr.next;
        }

        return head;
    }
}