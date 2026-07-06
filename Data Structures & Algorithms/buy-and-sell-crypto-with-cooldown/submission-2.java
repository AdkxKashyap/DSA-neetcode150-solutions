class Solution {
    int n;
    int[][] cache;
    public int maxProfit(int[] prices) {
        n = prices.length;
        cache = new int[n][2];
        for(int[] c : cache) Arrays.fill(c, -1);
        return helper(prices, 0, 1);
    }
   
    private int helper(int[] prices, int day, int canBuy) {
        if(day >= n) return 0;
        if(cache[day][canBuy] != -1) return cache[day][canBuy];
        int ans = 0;
        if(canBuy == 1) {
            int buy = -prices[day] + helper(prices, day + 1, 0);
            int skip = helper(prices, day + 1, canBuy);
            ans = Math.max(buy, skip);
        }
        else {
            int sell = prices[day] + helper(prices, day + 2, 1);
            int skip = helper(prices, day + 1, canBuy);
            ans = Math.max(sell, skip);
        }
        return cache[day][canBuy] = ans;
    }
}
