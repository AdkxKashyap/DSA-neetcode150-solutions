class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stk = new ArrayDeque<>();
        int max = 0;
        int n = heights.length;
        stk.push(-1);
        for(int i = 0; i <= n; i++) {
            int currHt = i == n ? 0 : heights[i];
            while(stk.peek() != -1 && heights[stk.peek()] > currHt) {
                int ht = heights[stk.pop()];
                int wd = i - stk.peek() - 1;
                max = Math.max(max, ht * wd);
            }
            stk.push(i);
        }
        return max;
    }
}
