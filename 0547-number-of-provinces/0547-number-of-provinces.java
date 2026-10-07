class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int[] visited = new int[isConnected.length];

        for(int i = 0;i<visited.length;i++){
            if(visited[i] == 0){
                dfs(i,visited,isConnected);
                count++;
            }
        }

        return count;
        
    }

    private void dfs(int i,int[] visited,int[][] isConnected){
        visited[i] = 1;
        for(int j = 0;j<isConnected.length;j++){
            if(isConnected[i][j] == 1 && visited[j] != 1){
                dfs(j,visited,isConnected);
            }
        }
    }
}