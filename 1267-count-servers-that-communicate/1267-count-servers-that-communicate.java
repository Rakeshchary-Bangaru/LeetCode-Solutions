class Solution {
    public int countServers(int[][] grid) {
        int count = 0;
        for(int i =0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    traverse(grid,i,j);
                }
            }
        }

        for(int i = 0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    count++;
                }
            }
        }

        return count;
        
    }

    private void traverse(int[][] grid,int i ,int j){
        for(int k = 0;k<grid.length;k++){
            if(grid[k][j] != 0 && k != i){
                grid[k][j] = 2;
                grid[i][j] = 2;
            }
        }

        for(int k = 0;k<grid[0].length;k++){
            if(grid[i][k] != 0 && k!=j){
                grid[i][k] = 2;
                grid[i][j] = 2;
            }
        }
    }
}