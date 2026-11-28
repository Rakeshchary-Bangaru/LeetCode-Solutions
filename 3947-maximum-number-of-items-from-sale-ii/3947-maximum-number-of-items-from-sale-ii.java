class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int[] freq = new int[n + 1];

        int minPrice = Integer.MAX_VALUE;

        
        for (int[] item : items) {

            freq[item[0]]++;

            minPrice = Math.min(minPrice, item[1]);
        }

        
        int[] free = new int[n + 1];

        for (int factor = 1; factor <= n; factor++) {

            if (freq[factor] == 0) {
                continue;
            }

            for (int multiple = factor;
                 multiple <= n;
                 multiple += factor) {

                free[factor] += freq[multiple];
            }

            
            free[factor]--;
        }

        
        Arrays.sort(items, (a, b) ->
            Integer.compare(a[1], b[1])
        );

        long remaining = budget;
        long answer = 0;

      
        for (int[] item : items) {

            int factor = item[0];
            int price = item[1];

            
            if (price > 2L * minPrice) {
                break;
            }

            long copies = Math.min(
                (long) free[factor],
                remaining / price
            );

           
            answer += 2 * copies;

            remaining -= copies * price;
        }

        
        answer += remaining / minPrice;

        return (int) answer;
    }
}