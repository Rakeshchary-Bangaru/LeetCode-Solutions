class Solution {
    public int numOfSubarrays(int[] arr) {
       int MOD = 1_000_000_007;

        long evenCount = 1; 
        long oddCount = 0;

        long prefixSum = 0;
        long count = 0;

        for (int num : arr) {

            prefixSum += num;

            if (prefixSum % 2 == 0) {

                
                count += oddCount;

                evenCount++;

            } else {

              
                count += evenCount;

                oddCount++;
            }

            count %= MOD;
        }

        return (int) count;
    }
}