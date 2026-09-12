class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i<nums.length;i++){
            int rem = target-nums[i];
            if(map.containsKey(rem)){
                result[0] = map.get(rem);
                result[1]  = i;
            }
            if(map.containsKey(nums[i])){
                map.put(nums[i],i);
            }
            else{
                map.put(nums[i],i);
            }
        }

        return result;
    }
}