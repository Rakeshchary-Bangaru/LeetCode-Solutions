class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n+1];
        Queue<Integer> que = new LinkedList<>();
        int moves = 0;
        que.offer(1);
        visited[1] = true;
        while(!que.isEmpty()){
            int size = que.size();
            for(int i = 0;i<size;i++){
                int node = que.poll();
                if(node == n*n){
                    return moves;
                }

                for(int curr = 1;curr<= 6;curr++){
                    int next = node + curr;
                    if(next > n*n){
                        break;
                    }
                    int[] pos = getposition(next,n);

                    int r = pos[0];
                    int c =pos[1];

                    if(board[r][c] != -1){
                        next = board[r][c];
                    }

                    if(!visited[next]){
                        que.offer(next);
                        visited[next] = true;
                    }
                }
            }
            moves++;
        }

        return -1;
    }

    private int[] getposition(int num , int n){
        int row = n-1 - (num - 1)/n ;
        int col = (num -1) % n ;

        if((n-row)%2 == 0){
            col = n-1-col;
        }

        return new int[]{row,col};
    }
}