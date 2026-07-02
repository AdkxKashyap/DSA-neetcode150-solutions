class Solution {
    int nrow;
    int ncol;
    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        nrow = grid.length;
        ncol = grid[0].length;
        int count = 0;
        for(int i = 0; i < nrow; i++) {
            for(int j = 0; j < ncol; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        grid[row][col] = '0';
        for(int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            if(nr < 0 || nr >= nrow || nc < 0 || nc >= ncol || grid[nr][nc] == '0') continue;
            dfs(grid, nr, nc);
        }
    }

}
