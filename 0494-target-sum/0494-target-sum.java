class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        if (Math.abs(target) > totalSum) {
            return 0;
        }

        if ((totalSum + target) % 2 != 0) {
            return 0;
        }

        int subsetTarget = (totalSum + target) / 2;

        int[] prev = new int[subsetTarget + 1];

        if (nums[0] == 0) {
            prev[0] = 2;
        } else {
            prev[0] = 1;

            if (nums[0] <= subsetTarget) {
                prev[nums[0]] = 1;
            }
        }

        for(int i =1;i<n;i++){
            int[] curr = new int[subsetTarget+1];

            for(int j = 0;j<=subsetTarget;j++){
                int notTake = prev[j];

                int take = 0;
                if(nums[i] <= j ){
                    take = prev[j-nums[i]];
                }

                curr[j] = take + notTake;
            }

            prev = curr;
        }

        return prev[subsetTarget];
    }
}