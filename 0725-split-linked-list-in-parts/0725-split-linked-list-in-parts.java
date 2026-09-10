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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode curr = head;
        while(curr!=null){
            curr = curr.next;
            length++;
        }

        int base = length/k;
        int extra = length%k;
        ListNode[] list = new ListNode[k];
     
        curr = head;

        for(int i = 0;i<k;i++){
            list[i] = curr;
            int partSize = base;
            if(i<extra){
                partSize++;
            }

            for(int j = 1;j<partSize;j++){
                curr = curr.next;
            }

            if(curr!=null){
                ListNode nextPart = curr.next;
                curr.next = null;
                curr = nextPart;
            }
        }
     

        return list;

    }
}