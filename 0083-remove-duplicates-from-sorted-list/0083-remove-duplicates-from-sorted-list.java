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
 import java.util.Set;
 import java.util.HashSet;
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> seen = new HashSet<>();
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            if(seen.contains(curr.val)){
                prev.next = curr.next;
                
            }
            else{
                seen.add(curr.val);
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}