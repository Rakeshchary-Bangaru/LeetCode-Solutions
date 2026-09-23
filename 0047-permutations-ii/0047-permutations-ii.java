class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] flag = new boolean[nums.length];
        permutations(nums,new ArrayList<>(),flag);

        return ans;
    }

    private void permutations(int[] nums,List<Integer> list,boolean[] flag){
        
        List<Integer> temp = new ArrayList<>();
        if(list.size() == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

       for(int i = 0;i<nums.length;i++){
            if(temp.contains(nums[i])){
                continue;
            }
              if(!flag[i]){
                flag[i] = true;
                temp.add(nums[i]);
                list.add(nums[i]);
                permutations(nums,list,flag);
                list.remove(list.size()-1);
                flag[i] = false;
            }
       }
           

        
            
           
        
    }
}