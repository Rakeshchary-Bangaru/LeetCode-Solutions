class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[1],a[1]));
        int[] freq = new int[26];
        
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }

        for(int i =0;i<freq.length;i++){
            if(freq[i] > 0){
                maxHeap.offer(new int[]{i, freq[i]});
            }
        }
        int[] prev = null;
        StringBuilder result = new StringBuilder();
        while(!maxHeap.isEmpty()){
            int[] current = maxHeap.poll();
            char c = (char)(current[0] + 97);
            result.append(c);
            current[1]--;

            if(prev != null && prev[1] > 0){
                maxHeap.offer(prev);
            }

            prev = current;

        }

        if( prev != null && prev[1]>0){
            return "";
        }

     return result.toString();
        
    }
}