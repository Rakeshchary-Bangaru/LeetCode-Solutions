class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] != 0 || grid[n-1][n-1] !=0){
            return -1;
        }

        int[][] dist = new int[n][grid[0].length];

        for(int[] row : dist){
            Arrays.fill(row,0);
        }

        Queue<int[]> que = new LinkedList<>();

        que.offer(new int[]{0,0});
        dist[0][0] = 1;

        int[][] directions = {
            {1,0},{-1,0},{0,1},{0,-1},
            {-1,-1},{-1,1},{1,1},{1,-1}
        };

        while(!que.isEmpty()){
            int[] curr = que.poll();
            int row = curr[0];
            int col = curr[1];
            if(row == n-1 && col == n-1){
                return dist[row][col];
            }
            for(int[] dir : directions){
                int nrow = row + dir[0];
                int ncol = col + dir[1];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < grid[0].length && dist[nrow][ncol] == 0 && grid[nrow][ncol] == 0 ){
                    dist[nrow][ncol] = dist[row][col] + 1;
                    que.offer(new int[]{nrow,ncol});
                }
            }

        }

        return -1;

    }
}