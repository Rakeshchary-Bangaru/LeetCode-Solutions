/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> que = new LinkedList<>();


        que.offer(root);

        while(!que.isEmpty()){
            int size = que.size();
            Node prev = null;
            for(int i =0;i<size;i++){
                Node temp = que.poll();
                if(prev != null){
                    prev.next = temp;
                }

                prev = temp;
            
                if(temp.left != null){
                    que.offer(temp.left);
                }
                if(temp.right != null){
                    que.offer(temp.right);
                }
                    
            }

            prev.next = null;

        }

        return root;
    }
}