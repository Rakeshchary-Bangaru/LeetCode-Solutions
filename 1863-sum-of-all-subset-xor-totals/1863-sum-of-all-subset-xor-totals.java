class Solution {
    public int subsetXORSum(int[] nums) {
        return sub(nums,0,0);
    }

    private int sub(int[] nums , int xor,int index){
        if(index == nums.length){
            return xor;
        }

        int take = sub(nums,xor ^ nums[index],index+1);

        int notTake = sub(nums,xor,index+1);

        return take + notTake;

     
    }
}