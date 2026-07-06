class Solution {
    int n;
    int[][] cache;
    public int maxProfit(int[] prices) {
        n = prices.length;
        cache = new int[n][2];
        for(int[] c : cache) Arrays.fill(c, -1);
        return helper(prices, 0, 0);
    }
    /*
    Op:
    0-> Buy
    1-> Sell
    */
    private int helper(int[] prices, int idx, int op) {
        if(idx >= n) return 0;
        if(cache[idx][op] != -1) return cache[idx][op];
        int max = 0;
        if(op == 0) {
            for(int i = idx; i < n; i++) {
                max = Math.max(max, -prices[i] + helper(prices, i + 1, 1));
            }
        }
        else if(op == 1) {
            for(int i = idx; i < n; i++) {
                max = Math.max(max, prices[i] + helper(prices, i + 2, 0));
            }
        }
        return cache[idx][op] = max;
    }
}
