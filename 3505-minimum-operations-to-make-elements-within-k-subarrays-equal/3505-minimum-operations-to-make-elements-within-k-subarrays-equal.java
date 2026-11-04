class Solution {
   
     static class SlidingMedian {

        TreeMap<Integer, Integer> lower = new TreeMap<>();
        TreeMap<Integer, Integer> upper = new TreeMap<>();

        long lowerSum = 0;
        long upperSum = 0;

        int lowerSize = 0;
        int upperSize = 0;

        private void addToMap(TreeMap<Integer, Integer> map, int value) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        private void removeFromMap(TreeMap<Integer, Integer> map, int value) {
            int count = map.get(value);

            if (count == 1) {
                map.remove(value);
            } else {
                map.put(value, count - 1);
            }
        }

        public void add(int value) {

            if (lower.isEmpty() || value <= lower.lastKey()) {

                addToMap(lower, value);

                lowerSum += value;
                lowerSize++;

            } else {

                addToMap(upper, value);

                upperSum += value;
                upperSize++;
            }

            rebalance();
        }

        public void remove(int value) {

            if (lower.containsKey(value)) {

                removeFromMap(lower, value);

                lowerSum -= value;
                lowerSize--;

            } else {

                removeFromMap(upper, value);

                upperSum -= value;
                upperSize--;
            }

            rebalance();
        }

        private void rebalance() {

           
            while (lowerSize > upperSize + 1) {

                int value = lower.lastKey();

                removeFromMap(lower, value);
                lowerSum -= value;
                lowerSize--;

                addToMap(upper, value);
                upperSum += value;
                upperSize++;
            }

            while (lowerSize < upperSize) {

                int value = upper.firstKey();

                removeFromMap(upper, value);
                upperSum -= value;
                upperSize--;

                addToMap(lower, value);
                lowerSum += value;
                lowerSize++;
            }
        }

        public long getCost() {

            long median = lower.lastKey();

            long leftCost =
                    median * lowerSize - lowerSum;

            long rightCost =
                    upperSum - median * upperSize;

            return leftCost + rightCost;
        }
    }

    
    public long minOperations(int[] nums, int x, int k) {
         int n = nums.length;

        int numberOfWindows = n - x + 1;

        long[] cost = new long[numberOfWindows];

        SlidingMedian window = new SlidingMedian();

     
        for (int i = 0; i < x; i++) {
            window.add(nums[i]);
        }

        cost[0] = window.getCost();

       
        for (int start = 1; start < numberOfWindows; start++) {

            window.remove(nums[start - 1]);

            window.add(nums[start + x - 1]);

            cost[start] = window.getCost();
        }


       

        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[k + 1][n + 1];

        for (int j = 1; j <= k; j++) {
            Arrays.fill(dp[j], INF);
        }

        
        Arrays.fill(dp[0], 0);


        for (int j = 1; j <= k; j++) {

            for (int i = 1; i <= n; i++) {

               
                dp[j][i] = dp[j][i - 1];

               
                if (i >= x &&
                    dp[j - 1][i - x] != INF) {

                    dp[j][i] =
                            Math.min(
                                    dp[j][i],
                                    dp[j - 1][i - x]
                                            + cost[i - x]
                            );
                }
            }
        }

        return dp[k][n];
    }
}