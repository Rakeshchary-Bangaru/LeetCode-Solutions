class Solution {

    static final long MOD = 1_000_000_007;
    long[][] C;

    public int numOfWays(int[] nums) {

        int n = nums.length;

        
        C = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {

            C[i][0] = 1;
            C[i][i] = 1;

            for (int j = 1; j < i; j++) {
                C[i][j] =
                    (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            list.add(num);
        }

        long totalWays = ways(list);

       
        return (int)((totalWays - 1 + MOD) % MOD);
    }


    private long ways(List<Integer> arr) {

        if (arr.size() <= 2) {
            return 1;
        }

        int root = arr.get(0);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < arr.size(); i++) {

            if (arr.get(i) < root) {
                left.add(arr.get(i));
            } else {
                right.add(arr.get(i));
            }
        }

        long leftWays = ways(left);
        long rightWays = ways(right);

        int L = left.size();
        int R = right.size();

        long combine = C[L + R][L];

        long result = combine;

        result = (result * leftWays) % MOD;
        result = (result * rightWays) % MOD;

        return result;
    }
}