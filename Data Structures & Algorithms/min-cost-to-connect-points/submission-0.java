class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] vis = new boolean[n];
        int cost = 0;
        int ncount = 0;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));


        pq.offer(new int[]{0, 0});
        while(ncount < n) {
            int[] curr = pq.poll();
            int node = curr[0];
            int currCost = curr[1];
            if(vis[node]) continue;
            vis[node] = true;
            ncount++;
            cost += currCost;
            for(int i = 0; i < n; i++) {
                if(!vis[i]) {
                    int dist = Math.abs(points[node][0] - points[i][0]) + Math.abs(points[node][1] - points[i][1]);
                    pq.offer(new int[]{i, dist});
                }
            }
        }
        return cost;
    }
}
