class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int count = -1;
        Queue<int[]> que = new LinkedList<>();
        for(int i =0;i<n;i++){
            for(int j = 0 ; j< grid[i].length;j++){
                if(grid[i][j] == 2){
                    que.offer(new int[]{i,j});
                }
            }
        }
        int[] dr = {-1,0,1,0};
        int[] dc = {0,-1,0,1};
        while(!que.isEmpty()){
            int size = que.size();
         for (int s = 0; s < size; s++) {

             int[] curr = que.poll();

             int row = curr[0];
             int col = curr[1];

           for (int i = 0; i < 4; i++) {

               int nrow = row + dr[i];
               int ncol = col + dc[i];
               if(nrow >= 0 && nrow <n && ncol >= 0 && ncol < grid[nrow].length && grid[nrow][ncol] == 1){
                    grid[nrow][ncol] = 2;
                    que.offer(new int[]{nrow,ncol});
                    
                }
           
            }
          }

         count++;
        }
           for(int i =0;i<n;i++){
            for(int j = 0 ; j< grid[i].length;j++){
                if(grid[i][j] == 1){
                    return -1 ;
                }
            }
        }

        return Math.max(count, 0);
    }
}