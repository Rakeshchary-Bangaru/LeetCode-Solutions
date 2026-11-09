class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        
        TreeSet<Integer> available = new TreeSet<>();

        for (int i = 0; i < k; i++) {
            available.add(i);
        }

       
        PriorityQueue<long[]> busy =
            new PriorityQueue<>(
                (a, b) -> Long.compare(a[0], b[0])
            );

        int[] handled = new int[k];

        for (int i = 0; i < arrival.length; i++) {

            long currentTime = arrival[i];

           
            while (!busy.isEmpty()
                    && busy.peek()[0] <= currentTime) {

                long[] server = busy.poll();

                int serverId = (int) server[1];

                available.add(serverId);
            }

            
            if (available.isEmpty()) {
                continue;
            }

            int preferred = i % k;

           
            Integer serverId =
                available.ceiling(preferred);

            
            if (serverId == null) {
                serverId = available.first();
            }

        
            available.remove(serverId);

            handled[serverId]++;

            long finishTime =
                (long) arrival[i] + load[i];

            busy.offer(
                new long[] {finishTime, serverId}
            );
        }

        
        int max = 0;

        for (int count : handled) {
            max = Math.max(max, count);
        }

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < k; i++) {

            if (handled[i] == max) {
                answer.add(i);
            }
        }

        return answer;
    }
}