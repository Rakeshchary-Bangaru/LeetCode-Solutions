class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int[] prev = new int[budget + 1];

        for (int i = 0; i < n; i++) {

            int factor = items[i][0];
            int price = items[i][1];

           
            int free = 0;

            for (int j = 0; j < n; j++) {

                if (i != j && items[j][0] % factor == 0) {
                    free++;
                }
            }

            int[] curr = new int[budget + 1];

            for (int j = 0; j <= budget; j++) {

                int notTake = prev[j];

                int firstTake = 0;
                int repeatTake = 0;

                if (price <= j) {

                    
                    firstTake = 1 + free + prev[j - price];

                    
                    repeatTake = 1 + curr[j - price];
                }

                curr[j] = Math.max(
                    notTake,
                    Math.max(firstTake, repeatTake)
                );
            }

            prev = curr;
        }

        return prev[budget];
    }
}