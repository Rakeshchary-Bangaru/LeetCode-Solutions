class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums,target);
        int last = findLast(nums,target);

        return new int[]{first,last};
    }

    private int findFirst(int[] nums,int target){
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

       

        while(start<= end){
            int mid = start + (end-start)/2 ;
            if(nums[mid] == target){
                ans = mid;

                end = mid-1;
            }

            else if(target < nums[mid]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }

        return ans;
    }

    private int findLast(int[] nums,int target){
        int ans = -1;
        int start = 0;
        int end = nums.length -1;

   

        while(start <= end){
             int mid = start + (end-start)/2 ;
            if(nums[mid] == target){
                ans = mid;

                start = mid+1;
            }

            else if(target < nums[mid]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }

        return ans;
    }
}