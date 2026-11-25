class Solution {
    private long[] prefix;
    private long[] power;

    private final long BASE = 100003;
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        prefix = new long[n + 1];
        power = new long[n + 1];

        power[0] = 1;

        
        for (int i = 0; i < n; i++) {

            prefix[i + 1] = prefix[i] * BASE + nums[i];

            power[i + 1] = power[i] * BASE;
        }

        int low = 1;
        int high = n;

       
        while (low < high) {

            int mid = low + (high - low) / 2;

            if (hasUniqueSubarray(mid, n)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean hasUniqueSubarray(int length, int n) {

        Map<Long, Integer> map = new HashMap<>();

        for (int i = 0; i + length <= n; i++) {

            int end = i + length;

            long hash = prefix[end]
                      - prefix[i] * power[length];

            map.put(hash, map.getOrDefault(hash, 0) + 1);
        }

        
        for (int count : map.values()) {

            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}