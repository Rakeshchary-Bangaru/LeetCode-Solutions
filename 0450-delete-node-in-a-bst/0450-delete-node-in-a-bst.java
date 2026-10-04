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
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (key < root.val) {

            root.left = deleteNode(root.left, key);

        } else if (key > root.val) {

            root.right = deleteNode(root.right, key);

        } else {

            // Case 1: no children
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: only right child
            else if (root.left == null) {
                return root.right;
            }

            // Case 3: only left child
            else if (root.right == null) {
                return root.left;
            }

            // Case 4: two children
            else {
                int subTreeMin = minValue(root.right);

                root.val = subTreeMin;

                root.right =
                    deleteNode(root.right, subTreeMin);
            }
        }

        return root;
    }

    private int minValue(TreeNode root) {

        while (root.left != null) {
            root = root.left;
        }

        return root.val;
    }
}