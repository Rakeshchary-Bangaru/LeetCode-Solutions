class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row =row;
            this.col = col;
        }
    }
    public int countIslands(int[][] grid, int k) {
        int count = 0;
        for(int i =0;i< grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                if(grid[i][j] > 0){
                    long sum = bfs(grid,i,j);
                    if(sum % k == 0){
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private long bfs(int[][] grid,int i,int j){
        long sum = grid[i][j]; 
        grid[i][j] = 0;
        Queue<Pair> que = new LinkedList<>();
        Pair p = new Pair(i,j);
        que.offer(p);
        
      
        while(!que.isEmpty()){
            Pair np = que.poll();
            int r = np.row;
            int c = np.col;
            sum += grid[r][c];
            int[] dr = {-1,0,1,0};
            int[] dc = {0,-1,0,1};

            for(int k =0;k<4;k++){
                int nrow = r + dr[k];
                int ncol = c + dc[k];

                if(nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && grid[nrow][ncol] > 0){
                    sum += grid[nrow][ncol];
                    Pair newp = new Pair(nrow,ncol);
                    grid[nrow][ncol] = 0;
                    que.offer(newp);
                }
            }

        }

        return sum;

    }
}