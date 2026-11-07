class Solution {
        static class Server {
        int weight;
        int index;
        long freeTime;

        Server(int weight, int index, long freeTime) {
            this.weight = weight;
            this.index = index;
            this.freeTime = freeTime;
        }
    }
    public int[] assignTasks(int[] servers, int[] tasks) {
       
        int n = servers.length;
        int m = tasks.length;

        int[] ans = new int[m];

        PriorityQueue<Server> free = new PriorityQueue<>((a,b) -> {
            if(a.weight != b.weight){
                return Integer.compare(a.weight , b.weight);
            }

            return Integer.compare(a.index , b.index);
        });

          PriorityQueue<Server> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a.freeTime != b.freeTime) {
                    return Long.compare(a.freeTime, b.freeTime);
                }

                if (a.weight != b.weight) {
                    return Integer.compare(a.weight, b.weight);
                }

                return Integer.compare(a.index, b.index);
            }
        );

        for(int i =0;i<n;i++){
            free.offer(new Server(servers[i],i,0));
        }

        long currentTime = 0;

        for(int j = 0;j<m;j++){
            currentTime = Math.max(currentTime,j);

            while(!busy.isEmpty() && busy.peek().freeTime <= currentTime){
                free.offer(busy.poll());
            }

            if(free.isEmpty()){
                 currentTime = busy.peek().freeTime;

                while (!busy.isEmpty()
                        && busy.peek().freeTime <= currentTime) {

                    free.offer(busy.poll());
                }
            }
                       Server server = free.poll();
                         ans[j] = server.index;
                          server.freeTime =
                    currentTime + tasks[j];

            busy.offer(server);
        }

        return ans;
    }
}