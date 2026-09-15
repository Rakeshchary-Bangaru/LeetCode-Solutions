class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i : nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }
            else{
                map.put(i,1);
            }
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> b[1] - a[1]);

        for(int i : map.keySet()){
            heap.offer(new int[]{i,map.get(i)});
        }

        int[] result = new int[k];

        for(int i =0;i<k;i++){
            result[i] = heap.poll()[0];
        }

        return result;
    }
}