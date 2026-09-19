/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        que.offer(root);
        boolean flag = true;
        while(que.size() > 0){
            int size = que.size();
            LinkedList<Integer> list = new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode node = que.poll();
                if(flag){
                    
                    list.addLast(node.val);
                }
                else{
                        list.addFirst(node.val);
                }
                if(node.left!= null){
                    que.offer(node.left);
                }
                if(node.right!= null){
                    que.offer(node.right);
                }
            }
            ans.add(list);
            flag = !flag;
        }

        return ans;

    }
}