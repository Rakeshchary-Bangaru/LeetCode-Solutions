class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String str = new String(chars);
            if(map.containsKey(str)){
                map.get(str).add(s);
            }
            else{
                List<String> group = new ArrayList<>();
                group.add(s);
                map.put(str, group);
            }
        }

        for(String s : map.keySet()){
            list.add(map.get(s));
        }

        return list;


    }
}