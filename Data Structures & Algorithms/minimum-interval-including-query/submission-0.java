class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        int n = queries.length;
        int[] ans = new int[n];

        int[][] q = new int[n][2];
        for (int i = 0; i < n; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }

        Arrays.sort(q, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        // [size, end]

        int idx = 0;

        for (int[] query : q) {

            int val = query[0];

            // Add all intervals whose start <= query
            while (idx < intervals.length && intervals[idx][0] <= val) {

                int size = intervals[idx][1] - intervals[idx][0] + 1;
                pq.offer(new int[]{size, intervals[idx][1]});
                idx++;
            }

            // Remove intervals that can't cover query
            while (!pq.isEmpty() && pq.peek()[1] < val)
                pq.poll();

            ans[query[1]] = pq.isEmpty() ? -1 : pq.peek()[0];
        }

        return ans;
    }
}