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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        class Element{
            TreeNode node;
            int row;
            int col;

            public Element(TreeNode node, int row, int col){
                this.node = node;
                this.row = row;
                this.col = col;
            }

        }
             List<List<Integer>> ans = new ArrayList<>();
        Queue<Element> que = new LinkedList<>();
            int minCol = 0;
            int maxCol = 0;
            Element startNode = new Element(root,0,0);
            que.offer(startNode);
            HashMap<Integer,List<Element>> map = new HashMap<>();
            while(!que.isEmpty()){
               
                Element temp = que.poll();
                    
                   map.computeIfAbsent(temp.col, k -> new ArrayList<>()).add(temp);

                 minCol = Math.min(minCol, temp.col);
                 maxCol = Math.max(maxCol, temp.col);
                
                if(temp.node.left != null){
                    Element e = new Element(temp.node.left,temp.row+1,temp.col-1);
                    que.offer(e);
                }
                if(temp.node.right != null){
                    Element e = new Element(temp.node.right,temp.row+1,temp.col+1);
                    que.offer(e);
                }
            }

        for (int col = minCol; col <= maxCol; col++) {

            List<Element> elements = map.get(col);

            elements.sort((a, b) -> {

                if (a.row != b.row) {
                    return Integer.compare(a.row, b.row);
                }

                return Integer.compare(
                    a.node.val,
                    b.node.val
                );
            });

            List<Integer> list = new ArrayList<>();

            for (Element e : elements) {
                list.add(e.node.val);
            }

            ans.add(list);
        }

        return ans;
    }
}