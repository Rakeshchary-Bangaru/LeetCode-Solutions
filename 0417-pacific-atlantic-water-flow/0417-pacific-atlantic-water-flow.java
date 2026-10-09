class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
              int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {

            if (!pacific[i][0]) {
                bfs(heights, pacific, i, 0);
            }

            if (!atlantic[i][cols - 1]) {
                bfs(heights, atlantic, i, cols - 1);
            }
        }

       
        for (int j = 0; j < cols; j++) {

            if (!pacific[0][j]) {
                bfs(heights, pacific, 0, j);
            }

            if (!atlantic[rows - 1][j]) {
                bfs(heights, atlantic, rows - 1, j);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        

        return ans;
    }

    private void bfs(int[][] heights , boolean[][] ocean , int i ,int j){
        ocean[i][j] = true;
        Queue<Pair> que = new LinkedList<>();
        Pair p = new Pair(i,j);
        que.offer(p);
        while(!que.isEmpty()){
            Pair np = que.poll();
            int[] dr = {-1,0,1,0};
            int[] dc = {0,-1,0,1};
            for(int k =0;k<4;k++){
                int nrow = np.row + dr[k];
                int ncol = np.col + dc[k];

                if(nrow >= 0 && nrow < heights.length && ncol >= 0 && ncol < heights[nrow].length && heights[nrow][ncol] >= heights[np.row][np.col] && !ocean[nrow][ncol]){
                    ocean[nrow][ncol] = true;
                    que.offer(new Pair(nrow,ncol));
                }
            }
        }
    }
}