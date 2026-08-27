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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast  = head;
        ListNode slow = head;

        if(n<=0) return null;
        for(int i=0;i<n;i++){
            if(fast==null){
                break;
            }
            fast = fast.next;
        }
        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        if(slow.next==null){
            ListNode temp = head;
            while(temp.next!=slow && temp.next!=null){
                temp = temp.next;
            }
            temp.next = null;
        }
        if(slow==head){
            return slow.next;
        }
      
        if(slow!=null&&slow.next!=null){
             slow.val = slow.next.val;
             slow.next = slow.next.next;
        }
        
       

        return head;

    }
}