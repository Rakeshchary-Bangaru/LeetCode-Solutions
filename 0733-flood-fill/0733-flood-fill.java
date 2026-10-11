class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int originalColor = image[sr][sc];

        if (originalColor == color) {
            return image;
        }
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{sr,sc});
          int[] dr = {-1,0,1,0};
            int[] dc = {0,-1,0,1};
            image[sr][sc] = color;
        while(!que.isEmpty()){
            int[] curr = que.poll();
            int row  = curr[0];
            int col = curr[1];

            for(int i = 0;i<4;i++){
                int nrow = row + dr[i];
                int ncol = col + dc[i];

                if(nrow >=0 && nrow < n && ncol >= 0 && ncol < image[nrow].length &&  image[nrow][ncol] == originalColor){
                    que.offer(new int[]{nrow , ncol});
                    image[nrow][ncol] = color;
                }
            }

        }

        return image;
    }
}