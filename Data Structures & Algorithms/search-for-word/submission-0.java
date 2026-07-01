class Solution {
    private int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j]==word.charAt(0) && helper(board, word, 0, i, j)) return true;
            }   
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int idx, int row, int col) {
        if(idx == word.length()) return true;
        if(!isCellValid(board, row, col) || board[row][col] != word.charAt(idx)) return false;
        char tmp = board[row][col];
        board[row][col] = '#';
        for(int[] dir : dirs) {
            boolean exists = helper(board, word, idx+1, row + dir[0], col + dir[1]);
            if(exists == true) return true;
        }
        board[row][col] = tmp;
        return false;
    }

    private boolean isCellValid(char[][] board, int row, int col) {
        return row >= 0 &&
            row < board.length &&
            col >= 0 &&
            col < board[0].length &&
            board[row][col] != '#';
    }
}