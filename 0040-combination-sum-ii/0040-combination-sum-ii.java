class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         Arrays.sort(candidates);
        combinations(candidates,target,0,new ArrayList<>());
        return ans;
    }

    private void combinations(int[] candidates,int target,int index,List<Integer> list){
        
            if(target == 0){
                ans.add(new ArrayList<>(list));
                return;
            }
        if(index == candidates.length){
            return;
        }

        if(candidates[index] <= target){
            list.add(candidates[index]);
            combinations(candidates,target-candidates[index],index+1,list);
            list.remove(list.size() - 1);
        }

        int next = index+1;
         while (next < candidates.length &&
               candidates[next] == candidates[index]) {
            next++;
        }
        combinations(candidates,target,next,list);
    }
}