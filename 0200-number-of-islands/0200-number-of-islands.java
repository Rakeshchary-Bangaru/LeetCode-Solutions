class Solution {
    class Pair{
        int row;
        int col;

        Pair(int row , int col){
            this.row = row;
            this.col = col;
        }
    }
    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int i =0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                if(grid[i][j] == '1'){
                    bfs(grid,i,j,grid.length,grid[i].length);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void bfs(char[][] grid , int row , int col,int xlength,int ylength){
        grid[row][col] = '0';
        Queue<Pair> que = new LinkedList<>();

        Pair np = new Pair(row,col);

        que.offer(np);

        while(!que.isEmpty()){
            Pair p = que.poll();
           int r = p.row;
           int c = p.col;

           int[] dr = {-1,0,1,0};
           int[]  dc = {0,-1,0,1};

            for(int i = 0;i<4;i++){
               int nrow = r + dr[i];
               int ncol = c + dc[i];

                if(nrow >= 0 && nrow < xlength && ncol >= 0 && ncol < ylength && grid[nrow][ncol] == '1'){
                    que.offer( new Pair(nrow,ncol));

                    grid[nrow][ncol] = '0';
                }
            }

        }
        
    }
}