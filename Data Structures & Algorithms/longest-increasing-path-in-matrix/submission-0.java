class Solution {
    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    int nrows;
    int ncols;
    int[][] cache;
    public int longestIncreasingPath(int[][] matrix) {
        nrows = matrix.length;
        ncols = matrix[0].length;
        cache = new int[nrows][ncols];
        for(int[] ch : cache) Arrays.fill(ch, -1);
        int max = 0;
        for(int i = 0; i < nrows; i++) {
            for(int j = 0; j < ncols; j++) {
                max = Math.max(max, dfs(matrix, i, j));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int row, int col) {
        if(cache[row][col] != -1) return cache[row][col];

        int max = 0;
        for(int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];

            if(nr < 0 || nr >= nrows || nc < 0 || nc >= ncols || matrix[nr][nc] <= matrix[row][col]) continue;
            max = Math.max(max, dfs(matrix, nr, nc));
        }
        return cache[row][col] = 1 + max;
    }
}
