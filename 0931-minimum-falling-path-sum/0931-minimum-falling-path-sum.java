class Solution {
    public int minFallingPathSum(int[][] matrix) {
       
       int n = matrix.length;
        int[] prev = new int[n];

        for(int i = 0;i<n;i++){
            prev[i] = matrix[0][i];
        }

        for(int i = 1;i<n;i++){
            int[] curr = new int[n];
            for(int j = 0;j<n;j++){
                int leftd = Integer.MAX_VALUE;
                int down = Integer.MAX_VALUE;
                int rightd = Integer.MAX_VALUE;
                if(j-1 >= 0){
                    leftd = matrix[i][j] + prev[j-1];
                }
                if(j+1 < n ){
                    rightd = matrix[i][j] + prev[j+1];
                }

                down = matrix[i][j] + prev[j];

                curr[j] = Math.min(leftd , Math.min(rightd,down));
            }

            prev = curr;
        }

        int minValue = prev[0];

        for(int i =1;i<n;i++){
            minValue = Math.min(minValue, prev[i]);
        }

        return minValue;
    }
}