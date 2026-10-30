class Solution {

    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class State {
        int node;
        int streak;
        int cost;

        State(int node, int streak, int cost) {
            this.node = node;
            this.streak = streak;
            this.cost = cost;
        }
    }
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        if (n == 1) {
            return 0;
        }

        List<Edge>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(
                new Edge(edge[1], edge[2])
            );
        }

        long[][] dist = new long[n][k + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        PriorityQueue<State> pq =
            new PriorityQueue<>(
                (a, b) -> Long.compare(a.cost, b.cost)
            );

       
        dist[0][1] = 0;

        pq.offer(new State(0, 1, 0));

        while (!pq.isEmpty()) {

            State curr = pq.poll();

            int node = curr.node;
            int streak = curr.streak;
            int cost = curr.cost;

            if (cost != dist[node][streak]) {
                continue;
            }

            
            if (node == n - 1) {
                return cost;
            }

            for (Edge edge : graph[node]) {

                int next = edge.to;

                int newStreak;

                if (labels.charAt(node)
                        == labels.charAt(next)) {

                    newStreak = streak + 1;

                } else {

                    newStreak = 1;
                }

                if (newStreak > k) {
                    continue;
                }

                int newCost =
                    cost + edge.weight;

                if (newCost
                        < dist[next][newStreak]) {

                    dist[next][newStreak] =
                        newCost;

                    pq.offer(
                        new State(
                            next,
                            newStreak,
                            newCost
                        )
                    );
                }
            }
        }

        return -1;
    }
}