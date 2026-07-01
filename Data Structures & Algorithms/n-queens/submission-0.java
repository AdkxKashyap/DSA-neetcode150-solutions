class Solution {
    
    public final int[][] dir = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
    public boolean isQueenSafe(int row, int col, boolean[][]board) {
        for(int rad = 1; rad < board.length; rad++) {
            for(int d = 0; d < dir.length; d++) {
                int r_ = row + rad * dir[d][0];
                int c_ = col + rad * dir[d][1];
                if(r_ >= 0 && r_ < board.length && c_ >= 0 && c_ < board.length && board[r_][c_] == true) {
                    return false;
                }
            }
        }
        return true;
    }
    public void helper(int qpsf, int tq, int lc, boolean[][] board, List<List<String>> ans) {
       
            if(qpsf == tq) {
                List<String> res = new ArrayList<>();
                for(int i = 0; i < tq; i++) {
                    StringBuilder sb = new StringBuilder();
                    for(int j = 0; j < tq; j++) {
                        if(board[i][j] == true) {
                            sb.append("Q");
                        } else {
                            sb.append(".");
                        }
                    }
                    res.add(sb.toString());
                }
                ans.add(res);
                return;
            }
            
        
        for(int c = lc+1; c < tq * tq; c++) {
            int row = c/tq;
            int col = c%tq;
            if(isQueenSafe(row, col, board)) {
                board[row][col] = true;
                helper(qpsf + 1, tq, c, board, ans);
                board[row][col] = false;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> res = new ArrayList<>();
            helper(0, n, -1, board, res);
        return res;
        
    }
}