class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int currentSum = 0;
        map.put(currentSum,1);
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            currentSum += nums[i];
            int rem = currentSum-k;
            if(map.containsKey(rem)){
                count += map.get(rem);
            }
             map.put(
                currentSum,
                map.getOrDefault(currentSum, 0) + 1
            );
        }

        return count;
    }
}