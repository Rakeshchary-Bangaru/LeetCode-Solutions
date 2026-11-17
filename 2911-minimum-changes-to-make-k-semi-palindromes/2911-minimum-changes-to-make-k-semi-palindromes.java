class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();

        int[][] cost = new int[n][n];

        
        for (int left = 0; left < n; left++) {

            for (int right = left + 1; right < n; right++) {

                int len = right - left + 1;

                cost[left][right] =
                        semiPalindromeCost(s, left, right, len);
            }
        }

      

        int INF = 1_000_000;

        int[][] dp = new int[k + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[0][0] = 0;

        for (int parts = 1; parts <= k; parts++) {

      
            for (int end = parts * 2; end <= n; end++) {

            

                for (int start = (parts - 1) * 2;
                     start <= end - 2;
                     start++) {

                    if (dp[parts - 1][start] == INF) {
                        continue;
                    }

                    dp[parts][end] =
                            Math.min(
                                dp[parts][end],
                                dp[parts - 1][start]
                                    + cost[start][end - 1]
                            );
                }
            }
        }

        return dp[k][n];
    }

     private int semiPalindromeCost(
            String s,
            int left,
            int right,
            int len) {

        int minChanges = Integer.MAX_VALUE;

    
        for (int d = 1; d < len; d++) {

            if (len % d != 0) {
                continue;
            }

            int changes = 0;

            for (int offset = 0; offset < d; offset++) {

                int l = left + offset;

             
                int groupSize = len / d;

                int r =
                        left
                        + offset
                        + (groupSize - 1) * d;

                while (l < r) {

                    if (s.charAt(l) != s.charAt(r)) {
                        changes++;
                    }

                    l += d;
                    r -= d;
                }
            }

            minChanges = Math.min(minChanges, changes);
        }

        return minChanges;
    }
}