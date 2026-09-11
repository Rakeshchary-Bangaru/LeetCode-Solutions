class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int[] result = new int[Math.max(nums1.length,nums2.length)];
      
        for(int i: nums1){
            
           map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int index = 0;
        for(int i : nums2){
            if(map.containsKey(i) && map.get(i)>0){
                result[index] = i;
                index++;
                 map.put(i, map.get(i) - 1);
            }
        }

        return Arrays.copyOf(result,index);
    }
}