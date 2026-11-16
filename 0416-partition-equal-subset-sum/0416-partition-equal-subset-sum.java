class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int i =0;i<n;i++){
            totalSum += nums[i];
        }

        if(totalSum % 2 != 0){
            return false;

        }

        int sum = totalSum /2 ;

        return partition(nums,sum,n);
    }

    private boolean partition(int[] arr , int target , int n){
       
        boolean[] prev = new boolean[target +1];

        prev[0] = true;
        

        if(arr[0] <= target){
            prev[arr[0]] = true;
        }

        for(int ind =1;ind<n;ind++){
            boolean[] curr = new boolean[target + 1];

            curr[0] = true;
            for(int k = 1;k<=target;k++){
                boolean notTake = prev[k];
                boolean take = false;

                if(arr[ind]<=k){
                    take = prev[k-arr[ind]];
                }

                curr[k] = take || notTake;
            }

            prev = curr;
        }

        return prev[target];
    }
}