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
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for(int i=0;i<postorder.length;i++){
            map.put(postorder[i],i);
        }

        return construct(preorder,postorder,0,preorder.length-1,0,postorder.length-1);
    }

    private TreeNode construct(int[] preorder , int[] postorder,int prestart,int preend,int poststart,int postend){
        if(prestart > preend){
            return null;
        }

        TreeNode root = new TreeNode(preorder[prestart]);
         if (prestart == preend) {
            return root;
        }
        int leftroot = preorder[prestart +1];
        int index = map.get(leftroot);
        int size = index - poststart + 1;

        root.left = construct(preorder,postorder,prestart+1,prestart+size,poststart,index);
        root.right = construct(preorder,postorder,prestart+size+1,preend,index+1,postend-1);

        return root;
    }
}