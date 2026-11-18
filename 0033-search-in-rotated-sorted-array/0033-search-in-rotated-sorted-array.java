class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        return rbs(nums,target,0,n-1);
    }

    private int rbs(int[] nums , int target , int s, int e){
        if(s > e){
            return -1;
        }

        int mid = s + (e-s)/2 ;

        if(nums[mid] == target){
            return mid;
        }

        if(nums[s] <= nums[mid]){
            if(target <= nums[mid] && target >= nums[s]){
                return rbs(nums,target,s,mid-1);
            }
            else{
                return rbs(nums,target,mid+1,e);
            }
        }

        if(target >= nums[mid] && target <= nums[e]){
            return rbs(nums,target,mid+1,e);
        }

        return rbs(nums,target,s,mid-1);
    }
}