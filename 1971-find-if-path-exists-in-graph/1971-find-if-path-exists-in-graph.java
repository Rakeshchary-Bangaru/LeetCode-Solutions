class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
       
       if(source == destination) return true;

       ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
    list.add(new ArrayList<>());
}
       for(int[] edge : edges){
          int u = edge[0];
          int v = edge[1];
          list.get(u).add(v);
          list.get(v).add(u);
       }
       
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(source);
       
             boolean[] visited = new boolean[n];
             visited[source] = true;
        while(!que.isEmpty()){
            int node = que.poll();
            for(int vertex : list.get(node)){
                if(visited[vertex] != true){
                    visited[vertex] = true;
                    if(vertex == destination){
                        return true;
                    }
                    que.offer(vertex);
                }
            }
        }

        return false;
    }
}