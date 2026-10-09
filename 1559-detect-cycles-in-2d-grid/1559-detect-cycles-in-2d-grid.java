class Solution {

    class Pair {
        int row;
        int col;
        int parentRow;
        int parentCol;

        Pair(int row, int col, int parentRow, int parentCol) {
            this.row = row;
            this.col = col;
            this.parentRow = parentRow;
            this.parentCol = parentCol;
        }
    }

    public boolean containsCycle(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){

                if(!visited[i][j]){

                    if(bfs(i, j, grid, visited)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean bfs(
        int row,
        int col,
        char[][] grid,
        boolean[][] visited
    ){

        Queue<Pair> que = new LinkedList<>();

        visited[row][col] = true;

        que.offer(
            new Pair(row, col, -1, -1)
        );

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};

        while(!que.isEmpty()){

            Pair current = que.poll();

            for(int k = 0; k < 4; k++){

                int nrow = current.row + dr[k];
                int ncol = current.col + dc[k];

                if(
                    nrow >= 0 &&
                    nrow < grid.length &&
                    ncol >= 0 &&
                    ncol < grid[0].length &&
                    grid[nrow][ncol] == grid[current.row][current.col]
                ){

                    if(!visited[nrow][ncol]){

                        visited[nrow][ncol] = true;

                        que.offer(
                            new Pair(
                                nrow,
                                ncol,
                                current.row,
                                current.col
                            )
                        );

                    }
                    else if(
                        nrow != current.parentRow ||
                        ncol != current.parentCol
                    ){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}