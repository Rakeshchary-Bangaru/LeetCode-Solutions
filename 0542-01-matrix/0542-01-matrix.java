class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;

        int[][] dist = new int[n][mat[0].length];
         Queue<int[]> que = new LinkedList<>();
        for(int i =0;i<n;i++){
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j] == 0){
                    dist[i][j] = 0;
                    que.offer(new int[]{i,j});
                }
                else{
                    dist[i][j] = -1;
                }
            }
        }

       

       

        while(!que.isEmpty()){
            int[] curr = que.poll();
            int row = curr[0];
            int col = curr[1];

            int[] dr = {-1,0,1,0};
            int[] dc = {0,-1,0,1};

            for(int i = 0;i<4;i++){
                int nrow = row + dr[i];
                int ncol = col + dc[i];

                if(nrow >=0 && nrow < n && ncol >= 0 && ncol < mat[nrow].length && dist[nrow][ncol] == -1 ){
                    que.offer(new int[]{nrow,ncol});
                    dist[nrow][ncol] = 1 + dist[row][col];
                }
            }
        }

        return dist;


    }
}