class Solution {
    private class Node{
        int maxCost = 0;
        int row = 0;
        int col = 0;
        Node(int maxCost, int row, int col) {
            this.maxCost = maxCost;
            this.row = row;
            this.col = col;
        }
    }
    private int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int swimInWater(int[][] grid) {
        if(grid == null || grid.length <= 0) return -1;
        int nrows = grid.length;
        int ncols = grid[0].length;
        Queue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.maxCost, b.maxCost));

        pq.offer(new Node(grid[0][0], 0, 0));
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int row = node.row;
            int col = node.col;
            int currMax = node.maxCost;
            if(row == nrows - 1 && col == ncols-1) return currMax;
            grid[row][col] = -1;

            for(int[] dir : dirs) {
                int nr = row + dir[0];
                int nc = col + dir[1];
                if(nr < 0 || nr >= nrows || nc < 0 || nc >= ncols || grid[nr][nc] == -1) continue;
                int max = Math.max(currMax, grid[nr][nc]);
                pq.offer(new Node(max, nr, nc));
            }
        }

        return -1;  
    }
}
