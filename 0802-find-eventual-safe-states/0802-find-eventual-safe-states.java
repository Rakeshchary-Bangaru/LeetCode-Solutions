class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> reverseGraph = new ArrayList<>();

        for(int i =0;i<n;i++){
            reverseGraph.add(new ArrayList<>());
        }

        int[] outdegree = new int[n];

        for(int node = 0;node < n;node++){
            for(int neighbour : graph[node]){
                    reverseGraph.get(neighbour).add(node);
                    outdegree[node]++;
            }
        }

        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for(int i =0;i<n;i++){
            if(outdegree[i] == 0){
                que.offer(i);
                visited[i] = true;
            }
        }

        while(!que.isEmpty()){
            int node = que.poll();
            for(int child : reverseGraph.get(node)){
                outdegree[child]--;
                if(outdegree[child] == 0){
                    que.offer(child);
                    visited[child] = true;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i =0;i<n;i++){
            if(visited[i]){
                result.add(i);
            }
        }

        return result;

    }
}