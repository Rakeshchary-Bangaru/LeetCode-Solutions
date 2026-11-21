class Solution {
    public int[] sortArray(int[] nums) {
        quick(nums,0,nums.length-1);

        return nums;
    }

    private void quick(int[] nums , int left , int right){
        if(left < right){
              int randomIndex =
            left + (int)(Math.random() * (right - left + 1));

        swap(nums, left, randomIndex);

       
            int pivotIndex = pivot(nums,left,right);
            quick(nums,left,pivotIndex-1);
            quick(nums,pivotIndex+1,right);
        }

        return;
    }

    private int pivot(int[] nums , int pivotIndex,int endIndex){
        int swapIndex = pivotIndex;

        for(int i = pivotIndex+1;i<=endIndex;i++){
            if(nums[i] < nums[pivotIndex]){
                swapIndex++;
                swap(nums,swapIndex,i);
            }
        }

        swap(nums,pivotIndex,swapIndex);

        return swapIndex;
    }

    private void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}