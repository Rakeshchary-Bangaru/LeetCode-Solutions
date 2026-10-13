class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int[] edge : prerequisites){
            int course = edge[0];
            int prerequisite = edge[1];
            graph.get(prerequisite).add(course);
            indegree[course]++;
        }
        int[] result = new int[numCourses];
        int index = 0;
        Queue<Integer> que = new LinkedList<>();
        for(int i =0;i<numCourses;i++){
            if(indegree[i] == 0){
                que.offer(i);
                result[index++] = i;
            }
        }

        
        int count = 0;
        while(!que.isEmpty()){
            int course = que.poll();
            count++;
            for(int child : graph.get(course)){
                indegree[child]--;
                if(indegree[child] == 0){
                    que.offer(child);
                    result[index++] = child;
                }
            }

        }
        if(count != numCourses){
            return new int[0];
        }

        return result;
    }
}