class Solution {
   class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
   }
    public void solve(char[][] board) {
        int rows = board.length;
    int cols = board[0].length;

    for (int i = 0; i < rows; i++) {
        if (board[i][0] == 'O') {
            bfs(board, i, 0);
        }

        if (board[i][cols - 1] == 'O') {
            bfs(board, i, cols - 1);
        }
    }

    for (int j = 0; j < cols; j++) {
        if (board[0][j] == 'O') {
            bfs(board, 0, j);
        }

        if (board[rows - 1][j] == 'O') {
            bfs(board, rows - 1, j);
        }
    }

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {

            if (board[i][j] == 'O') {
                board[i][j] = 'X';
            }

            else if (board[i][j] == '1') {
                board[i][j] = 'O';
            }
        }
    }
    }

    private void bfs(char[][] board, int row, int col) {

    Queue<Pair> que = new LinkedList<>();

    board[row][col] = '1';
    que.offer(new Pair(row, col));

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, -1, 0, 1};

    while (!que.isEmpty()) {

        Pair p = que.poll();

        for (int i = 0; i < 4; i++) {

            int nr = p.row + dr[i];
            int nc = p.col + dc[i];

            if (
                nr >= 0 &&
                nr < board.length &&
                nc >= 0 &&
                nc < board[0].length &&
                board[nr][nc] == 'O'
            ) {
                board[nr][nc] = '1';
                que.offer(new Pair(nr, nc));
            }
        }
    }
}
}