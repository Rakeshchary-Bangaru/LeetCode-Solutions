class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for(int[] edges : prerequisites){
            int course = edges[0];
            int prerequisite = edges[1];
            graph.get(prerequisite).add(course);
            indegree[course]++;
        }

        Queue<Integer> que = new LinkedList<>();

        for(int i = 0;i<numCourses;i++){
            if(indegree[i]==0){
                que.offer(i);
            }
        }

        int count= 0;
        while(!que.isEmpty()){
            int course = que.poll();
            count++;

            for(int child : graph.get(course)){
                indegree[child]--;
                if(indegree[child] == 0){
                    que.offer(child);
                }
            }
        }

        return count == numCourses;
    }
}