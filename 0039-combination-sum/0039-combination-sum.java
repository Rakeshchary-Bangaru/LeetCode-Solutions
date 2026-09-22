class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinations(candidates,0,target,new ArrayList<>());
        return ans;
    }

    private void combinations(int[] candidates,int index,int target,List<Integer> list){
        if(index == candidates.length){
            if(target == 0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        if(candidates[index] <= target){
            list.add(candidates[index]);
            combinations(candidates,index,target-candidates[index],list);
            list.remove(list.size()-1);
        }

        combinations(candidates,index+1,target,list);
    }
}