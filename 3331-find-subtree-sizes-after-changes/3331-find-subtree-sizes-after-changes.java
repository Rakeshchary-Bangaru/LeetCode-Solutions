class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
         int n = parent.length;

     
        List<Integer>[] children = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }

        
        int[] newParent = parent.clone();

        int[] last = new int[26];
        Arrays.fill(last, -1);

        
        Stack<int[]> stack = new Stack<>();

        stack.push(new int[]{0, 0, -1});

        while (!stack.isEmpty()) {

            int[] current = stack.pop();

            int node = current[0];
            int state = current[1];

            int c = s.charAt(node) - 'a';

            if (state == 0) {

                int previous = last[c];

               
                if (node != 0 && previous != -1) {
                    newParent[node] = previous;
                }

                
                stack.push(new int[]{node, 1, previous});

            
                last[c] = node;

              
                List<Integer> list = children[node];

                for (int i = list.size() - 1; i >= 0; i--) {
                    stack.push(new int[]{list.get(i), 0, -1});
                }

            } else {

                
                last[c] = current[2];
            }
        }

        
        List<Integer>[] finalTree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            finalTree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            finalTree[newParent[i]].add(i);
        }

      
        int[] order = new int[n];
        int index = 0;

        Stack<Integer> traversal = new Stack<>();
        traversal.push(0);

        while (!traversal.isEmpty()) {

            int node = traversal.pop();

            order[index++] = node;

            for (int child : finalTree[node]) {
                traversal.push(child);
            }
        }

   
        int[] answer = new int[n];

        Arrays.fill(answer, 1);

        
        for (int i = n - 1; i > 0; i--) {

            int node = order[i];

            answer[newParent[node]] += answer[node];
        }

        return answer;
    }
}