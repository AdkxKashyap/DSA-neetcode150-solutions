class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        int idx = 0;
        Deque<int[]> dq = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            while(!dq.isEmpty() && dq.peek()[1] <= i-k) dq.poll();
            while(!dq.isEmpty() && dq.peekLast()[0] < nums[i]) dq.pollLast();
            dq.offerLast(new int[]{nums[i], i});
            if(i >= k-1) res[idx++] = dq.peek()[0];
        }
        return res;
    }
}
