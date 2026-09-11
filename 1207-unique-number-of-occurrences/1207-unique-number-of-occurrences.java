class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i : arr){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }
            else{
                map.put(i,1);
            }
        }
         HashSet<Integer> set = new HashSet<>();

        for (int frequency : map.values()) {

            if (set.contains(frequency)) {
                return false;
            }

            set.add(frequency);
        }

        return true;
    }
}