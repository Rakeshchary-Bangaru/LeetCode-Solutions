class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        for(int i =1;i<n;i++){
            result[i] = result[i-1] * nums[i-1];
        }

        int rightProduct = 1;
        for(int r = n-1;r>=0;r--){
            result[r] = rightProduct * result[r];
            rightProduct = rightProduct * nums[r];
        }

        return result;
       
        
        
    }
}