class Solution {
    class Pair{
        int row;
        int col;

        public Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public int closedIsland(int[][] grid) {
        int islands = 0;
        for(int i =0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                if(grid[i][j] == 0){
                   if(bfs(grid,i,j)){
                        islands++;
                   } 
                    
                }
            }
        }

        return islands;
    }

    private boolean bfs(int[][] grid , int row , int col){
        grid[row][col] = 1;
        Queue<Pair> que = new LinkedList<>();
        Pair p = new Pair(row,col);
        que.offer(p);
        boolean closed = true;
        while(!que.isEmpty()){
            Pair np = que.poll();
            int r = np.row;
            int c = np.col;

            if(r == 0 || c == 0 || r == grid.length-1 || c == grid[0].length-1){
                closed = false;
            }

            int[] dr = {-1,0,1,0};
            int[] dc = {0,-1,0,1};

            for(int i = 0;i<4;i++){
                int nrow = r+ dr[i];
                int ncol = c + dc[i];
                if(nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && grid[nrow][ncol] == 0){
                    que.offer( new Pair(nrow,ncol));

                    grid[nrow][ncol] = 1;
                }
            }
        }

        return closed;
    }
}