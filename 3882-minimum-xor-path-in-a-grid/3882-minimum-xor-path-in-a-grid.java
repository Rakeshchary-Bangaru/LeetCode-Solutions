class Solution {
    public int minCost(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][][] dp = new boolean[m][n][1024];

        dp[0][0][grid[0][0]] = true;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                for (int xor = 0; xor < 1024; xor++) {

                    
                    if (i > 0 && dp[i - 1][j][xor]) {

                        int newXor = xor ^ grid[i][j];

                        dp[i][j][newXor] = true;
                    }

                    
                    if (j > 0 && dp[i][j - 1][xor]) {

                        int newXor = xor ^ grid[i][j];

                        dp[i][j][newXor] = true;
                    }
                }
            }
        }

        for (int xor = 0; xor < 1024; xor++) {

            if (dp[m - 1][n - 1][xor]) {
                return xor;
            }
        }

        return -1;
    }
}