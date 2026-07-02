class Solution {
    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    int nrows;
    int ncols;
    public void solve(char[][] board) {
        nrows = board.length;
        ncols = board[0].length;

        // Mark top & bottom 
        for(int i = 0; i < ncols; i++) {
            if(board[0][i] == 'O') dfs(board, 0, i);
            if(board[nrows - 1][i] == 'O')dfs(board, nrows-1, i);
        }

        for(int i = 0; i < nrows; i++) {
            if(board[i][0] == 'O') dfs(board, i, 0);
            if(board[i][ncols - 1] == 'O') dfs(board, i, ncols - 1);
        }

        for(int i = 0; i < nrows; i++) {
            for(int j = 0; j < ncols; j++) {
                if(board[i][j] != 'X') {
                    if(board[i][j] == 'O') board[i][j] = 'X';
                    else board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        board[row][col] = '#';
        for(int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            if(nr < 0 || nr >= nrows || nc < 0 || nc >= ncols || board[nr][nc] != 'O') continue;
            dfs(board, nr, nc);
        }
    }
}
