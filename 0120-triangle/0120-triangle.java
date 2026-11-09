class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n =triangle.size();
        int[] prev = new int[n];
        for(int i = 0;i<n;i++){
            prev[i] = triangle.get(n-1).get(i);
        }

        for(int i = n-2;i>=0;i--){
           
            int[] curr = new int[i+1];
            for(int j= 0 ; j<= i ;j++ ){
                int up = triangle.get(i).get(j) + prev[j];

                int diag = triangle.get(i).get(j) + prev[j+1];

                curr[j] = Math.min(up,diag);
            }

            prev = curr;
        }

        return prev[0];
    }
}