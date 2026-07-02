
/*  The area of an island is the number of cells with a value 1 in the island.
    Similar to number of islands problem. */
class Solution {
    int nrows = 0;
    int ncols = 0;
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    private int area = 0;
    public int maxAreaOfIsland(int[][] grid) {
        nrows = grid.length;
        ncols = grid[0].length;
        int maxArea = 0;
        for(int i = 0; i < nrows; i++) {
            for(int j = 0; j < ncols; j++) {
                if(grid[i][j] == 1) {
                    dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                    area = 0;
                }
            }
        }
        return maxArea;
    }

    private void dfs(int[][] grid, int row, int col) {
        if(row < 0 || row >= nrows || col < 0 || col >= ncols || grid[row][col] == 0) return;
        grid[row][col] = 0;
        area++;
        for(int[] dir : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];
            dfs(grid, r, c);
        }
    }
}