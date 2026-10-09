class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];

        for(int i =0;i<n;i++){
             if(visited[i] == 0){
        if(!dfs(i, graph, visited, 1)){
            return false;
        }
    }
        }

        return true;
    }

    private boolean dfs(int node , int[][] graph , int[] visited , int col ){
        visited[node] = col;

        for(int i : graph[node]){
            if(visited[i] == 0){
                if(!dfs(i,graph,visited, -col)){
                    return false;
                }

            }
            else{
                if(visited[i] == col){
                    return false;
                }
            }
        }

        return true;
    }
}