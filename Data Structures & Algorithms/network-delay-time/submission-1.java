class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        if(times == null || times.length <= 0 || n <= 0 || k < 1 || k > n) return -1;
        List<List<int[]>> adj = buildAdj(n, times);
        int[] time = new int[n + 1];
        int max = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        Arrays.fill(time, Integer.MAX_VALUE);
        pq.offer(new int[]{0, k});
        time[k] = 0;
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[1];
            int ctime = curr[0];
            if(time[node] < ctime) continue;
            max = Math.max(max, ctime);

            for(int[] nbr : adj.get(node)) {
                int nn = nbr[0];
                int t = ctime + nbr[1];
                if(t < time[nn]) {
                    time[nn] = t;
                    pq.offer(new int[]{t, nn});
                }
            }
        }
        for(int i = 1; i <= n; i++) {
            if(time[i] == Integer.MAX_VALUE) return -1;
        }
        return max;
    }

    private List<List<int[]>> buildAdj(int n, int[][] times) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] time : times) {
            adj.get(time[0]).add(new int[]{time[1], time[2]});
        }

        return adj;
    }
}
