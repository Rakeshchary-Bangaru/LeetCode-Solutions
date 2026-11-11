class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long minNeed = Math.min(need1, need2);
        long maxNeed = Math.max(need1, need2);

        long ans = Long.MAX_VALUE;

        ans = Math.min(ans,
                calculate(0, cost1, cost2, costBoth, need1, need2));

        ans = Math.min(ans,
                calculate(minNeed, cost1, cost2, costBoth, need1, need2));

        ans = Math.min(ans,
                calculate(maxNeed, cost1, cost2, costBoth, need1, need2));

        return ans;
    }

       private long calculate(
            long both,
            int cost1,
            int cost2,
            int costBoth,
            int need1,
            int need2) {

        long remaining1 = Math.max(0L, need1 - both);
        long remaining2 = Math.max(0L, need2 - both);

        return both * costBoth
                + remaining1 * cost1
                + remaining2 * cost2;
    }
}