class Solution {
     int count = 0;
     List<List<Integer>> ans = new ArrayList<>();
    public String getPermutation(int n, int k) {
        boolean[] flag = new boolean[n];
       permutation(n,k,new ArrayList<>(),flag);
        List<Integer> list = ans.get(k-1);

        StringBuffer s = new StringBuffer();
          for (int num : list) {
            s.append(num);
        }

        return s.toString();
    }

    private void permutation(int n,int k,List<Integer> list, boolean[] flag){
       
      
        if(list.size() == n){
            count++;
            ans.add(new ArrayList<>(list));
            return ;
        }

        for(int i = 1;i<=n;i++){
            if(!flag[i-1]){
                flag[i-1] = true;
                list.add(i);
                permutation(n,k,list,flag);
                list.remove(list.size()-1);
                flag[i-1] = false;
            }
        }


    }
}