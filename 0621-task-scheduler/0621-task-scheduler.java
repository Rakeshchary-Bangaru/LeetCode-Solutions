class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>( (a,b) -> Integer.compare(b,a));
        Queue<int[]> que = new ArrayDeque<>();
        int[] freq = new int[26];
        for(char c : tasks ){
            freq[c-'A']++;
        }

        for(int i : freq){
            if(i>0){
                maxHeap.offer(i);
            }
        }

        int time = 0;

        while(!maxHeap.isEmpty() || !que.isEmpty()){
            time++;
           
            if(!que.isEmpty() && que.peek()[1] <= time){
                    maxHeap.offer(que.poll()[0]);
            }
           
            if(!maxHeap.isEmpty()){
                int remaining = maxHeap.poll()-1;
                if(remaining > 0){
                        int readytime = time + n + 1;
                         que.offer(
                        new int[]{remaining, readytime}
                    );
                }
                
            }


        }

        return time;
    }
}