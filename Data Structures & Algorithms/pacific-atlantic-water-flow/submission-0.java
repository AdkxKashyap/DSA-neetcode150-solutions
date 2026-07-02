class Solution {
    int nrows = 0;
    int ncols = 0;
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        nrows = heights.length;
        ncols = heights[0].length;
        boolean[][] pac = new boolean[nrows][ncols];
        boolean[][] atl = new boolean[nrows][ncols];

        //Pacific: Top and Left boundary
        for(int col = 0; col < ncols; col++) {
            dfs(heights, 0, col, pac);
        }
        for(int row = 0; row < nrows; row++) {
            dfs(heights, row, 0, pac);
        }
        //Atlantic: Bottom and Right boundary
        for(int col = 0; col < ncols; col++) {
            dfs(heights, nrows - 1, col, atl);
        }
        for(int row = 0; row < nrows; row++) {
            dfs(heights, row, ncols - 1, atl);
        }
        //Collecting cells which can reach both pacific and atlantic ocean
        for(int i = 0; i < nrows; i++) {
            for(int j = 0; j < ncols; j++) {
                if(pac[i][j] && atl[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, int row, int col, boolean[][] vis) {
        vis[row][col] = true;
        for(int[] dir : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];
            if(r < 0 || r >= nrows || c < 0 || c >= ncols || vis[r][c] || heights[row][col] > heights[r][c]) continue;
            dfs(heights, r, c, vis);
        }
    }
}