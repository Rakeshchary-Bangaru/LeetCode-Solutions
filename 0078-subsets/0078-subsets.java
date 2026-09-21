class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        subset(nums, new ArrayList<>(), 0);
        return ans;
    }

    private void subset(int[] nums, List<Integer> sub,int index){
      
        if(index == nums.length){
            ans.add(new ArrayList<>(sub));
            return;
        }
        sub.add(nums[index]);
        subset(nums, sub ,index+1);

        sub.remove(sub.size()-1);

        subset(nums,sub,index+1);
    }
}