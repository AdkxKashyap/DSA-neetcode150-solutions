class Solution {
    class Cell {
        int row;
        int col;
        int level = 0;
        Cell(int row, int col, int level) {
            this.row = row;
            this.col = col;
            this.level = level;
        }
    }
    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void islandsAndTreasure(int[][] grid) {
        int nrow = grid.length;
        int ncol = grid[0].length;
        Deque<Cell> que = new ArrayDeque<>();
        for(int i = 0; i < nrow; i++) {
            for(int j = 0; j < ncol; j++) {
                if(grid[i][j] == 0){
                    que.offer(new Cell(i, j, 0));
                }
            }
        }

        while(!que.isEmpty()) {
            int sz = que.size();
            while(sz-- > 0) {
                Cell cell = que.poll();
                int row = cell.row;
                int col = cell.col;
                int lvl = cell.level;
                for(int[] dir : dirs) {
                    int nr = dir[0] + row;
                    int nc = dir[1] + col;
                    if(nr < 0 || nr >= nrow || nc < 0 || nc >= ncol || grid[nr][nc] != Integer.MAX_VALUE) continue;
                    grid[nr][nc] = lvl + 1;
                    que.offer(new Cell(nr, nc, lvl + 1));
                }
            }
        }
    }
}
