class Solution {
    public int minOperations(int[] nums) {

        int n = nums.length;

        if (n <= 1) {
            return 0;
        }

        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 0; i < n; i++) {

            int next = (i + 1) % n;

          
            if (nums[next] != (nums[i] + 1) % n) {
                increasing = false;
            }

          
            int expected =
                    (nums[i] - 1 + n) % n;

            if (nums[next] != expected) {
                decreasing = false;
            }
        }

        int answer = Integer.MAX_VALUE;

        if (increasing) {

            int zeroIndex = 0;

            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    zeroIndex = i;
                    break;
                }
            }

            answer = Math.min(
                    zeroIndex,
                    n - zeroIndex + 2
            );
        }

        if (decreasing) {

            int maxIndex = 0;

            for (int i = 0; i < n; i++) {
                if (nums[i] == n - 1) {
                    maxIndex = i;
                    break;
                }
            }

            
            int option1 = maxIndex ;

            
            int option2 = n - maxIndex;

            answer = Math.min(
                    answer,
                   1 + Math.min(option1, option2)
            );
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}