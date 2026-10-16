class Solution {

    static final long MOD = 1_000_000_007L;

    long[] sum;
    long[] squareSum;
    long[] lazy;

    public int sumCounts(int[] nums) {

        int n = nums.length;

        sum = new long[4 * n];
        squareSum = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100001];
        Arrays.fill(last, -1);

        long answer = 0;

        for (int r = 0; r < n; r++) {

            int left = last[nums[r]] + 1;

            update(
                1,
                0,
                n - 1,
                left,
                r
            );

            answer =
                (answer + squareSum[1]) % MOD;

            last[nums[r]] = r;
        }

        return (int) answer;
    }

    private void update(
        int node,
        int start,
        int end,
        int left,
        int right
    ) {

        if (right < start || end < left) {
            return;
        }

        if (left <= start && end <= right) {

            long len = end - start + 1;

            squareSum[node] =
                (
                    squareSum[node]
                    + 2 * sum[node]
                    + len
                ) % MOD;

            sum[node] =
                (sum[node] + len) % MOD;

            lazy[node]++;

            return;
        }

        push(node, start, end);

        int mid = start + (end - start) / 2;

        update(
            node * 2,
            start,
            mid,
            left,
            right
        );

        update(
            node * 2 + 1,
            mid + 1,
            end,
            left,
            right
        );

        sum[node] =
            (sum[node * 2] + sum[node * 2 + 1])
            % MOD;

        squareSum[node] =
            (
                squareSum[node * 2]
                + squareSum[node * 2 + 1]
            ) % MOD;
    }

    private void push(
        int node,
        int start,
        int end
    ) {

        if (lazy[node] == 0 || start == end) {
            return;
        }

        int mid = start + (end - start) / 2;

        apply(
            node * 2,
            mid - start + 1,
            lazy[node]
        );

        apply(
            node * 2 + 1,
            end - mid,
            lazy[node]
        );

        lazy[node] = 0;
    }

    private void apply(
        int node,
        int len,
        long add
    ) {

        squareSum[node] =
            (
                squareSum[node]
                + 2 * add * sum[node]
                + add * add % MOD * len
            ) % MOD;

        sum[node] =
            (
                sum[node]
                + add * len
            ) % MOD;

        lazy[node] += add;
    }
}