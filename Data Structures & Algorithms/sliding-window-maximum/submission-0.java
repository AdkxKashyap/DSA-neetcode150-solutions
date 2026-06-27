class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        int idx = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));
        for(int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            while(!pq.isEmpty() && pq.peek()[1] <= i-k) pq.poll();
            if(i >= k-1 )res[idx++] = pq.peek()[0];
        }
        return res;
    }
}
