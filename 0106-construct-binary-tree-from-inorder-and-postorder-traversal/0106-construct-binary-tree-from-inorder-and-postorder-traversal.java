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
      int postorderIndex ;
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
     postorderIndex = postorder.length-1;
        for(int i =0;i<inorder.length;i++){
            map.put(inorder[i],i);

        }

        return build(postorder,0,inorder.length-1);
    }

    private TreeNode build(int[] postorder,int start,int end){
        if(start > end){
            return null;
        }

        TreeNode root = new TreeNode(postorder[postorderIndex--]);
        int inorderIndex = map.get(root.val);
        root.right = build(postorder,inorderIndex+1,end);
        root.left = build(postorder,start,inorderIndex-1);
        

        return root;
    }
}