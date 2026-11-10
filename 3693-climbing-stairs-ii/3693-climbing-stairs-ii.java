class Solution {
    public int climbStairs(int n, int[] costs) {
        
        long prev1 = 0;
        long prev2 = Integer.MAX_VALUE;
        long prev3 = Integer.MAX_VALUE;

        for(int i = 1;i<=n;i++){
            long one = prev1 + 1;

            long two = prev2 == Integer.MAX_VALUE
                    ? Integer.MAX_VALUE
                    : prev2 + 4;

            long three = prev3 == Integer.MAX_VALUE ? Integer.MAX_VALUE : prev3 + 9;

            long curr = costs[i-1] + Math.min(one , Math.min(two,three));

            prev3 = prev2;
            prev2 = prev1;
            prev1 = curr;        
        }

        return (int)prev1;
    }

    
}