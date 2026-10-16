class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeros = 0;
        int maxCount = 0;
        int left = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                zeros++;
            }
           if(zeros > k){
                if(nums[left] == 0){
                    zeros--;
                }
                left++;
           }
        }
        return nums.length - left;
    }
}