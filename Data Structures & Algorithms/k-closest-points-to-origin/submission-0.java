class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(distance(b), distance(a)));
        int[][] res = new int[k][2];
        for(int[] point : points) {
            pq.offer(point);
            if(pq.size() > k) pq.poll();
        }
        int idx = 0;
        while(!pq.isEmpty()) {
            int[] point = pq.poll();
            res[idx][0] = point[0];
            res[idx][1] = point[1];
            idx++;
        }
        return res;
    }

    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
