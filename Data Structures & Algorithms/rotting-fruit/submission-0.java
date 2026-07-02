class Solution {
    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        int nrows = grid.length;
        int ncols = grid[0].length;
        Deque<int[]> que = new ArrayDeque<>();
        int count = 0;
        int steps = 0;

        for(int i = 0; i < nrows; i++) {
            for(int j = 0; j < ncols; j++) {
                if(grid[i][j] == 2) {
                    que.offer(new int[]{i, j});
                    grid[i][j] = 0;
                    count++;
                }
                else if(grid[i][j] == 1) count++;
            }
        }
        
        while(!que.isEmpty()) {
            int sz = que.size();
            while(sz-- > 0) {
                int[] coord = que.poll();
                count--;
                for(int[] dir : dirs) {
                    int nr = coord[0] + dir[0];
                    int nc = coord[1] + dir[1];
                    if(nr < 0 || nr >= nrows || nc < 0 || nc >= ncols || grid[nr][nc] != 1) continue;
                    que.offer(new int[]{nr, nc});
                    grid[nr][nc] = 0;
                }
            }
            if(!que.isEmpty()) steps++;
        }

        return count == 0 ? steps : -1;
    }
}
