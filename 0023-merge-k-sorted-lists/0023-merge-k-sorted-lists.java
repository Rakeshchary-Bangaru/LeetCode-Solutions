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
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> Integer.compare(a.val,b.val));

        for(int i =0;i<lists.length;i++){
            
            if(lists[i]!=null){
                    heap.offer(lists[i]);
            }
        

        }
         
         while(!heap.isEmpty()){
            ListNode temp = heap.poll();

            curr.next = temp;
            curr = temp;
            if(temp.next!=null){
                heap.offer(temp.next);
            }
         }



        return dummy.next;
    }
}