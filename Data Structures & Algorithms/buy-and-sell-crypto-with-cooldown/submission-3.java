class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] next2next = new int[2];
        int[] next = new int[2];
        for(int day = n - 1; day >= 0; day--) {
            int[] curr  = new int[2];
            curr[1] = Math.max(-prices[day] + next[0], next[1]);
            curr[0] = Math.max(prices[day] + next2next[1], next[0]);
            next2next = next;
            next = curr;
        }
        return next[1];
    }
   
    // private int helper(int[] prices, int day, int canBuy) {
    //     if(day >= n) return 0;
    //     if(cache[day][canBuy] != -1) return cache[day][canBuy];
    //     int ans = 0;
    //     if(canBuy == 1) {
    //         int buy = -prices[day] + helper(prices, day + 1, 0);
    //         int skip = helper(prices, day + 1, canBuy);
    //         ans = Math.max(buy, skip);
    //     }
    //     else {
    //         int sell = prices[day] + helper(prices, day + 2, 1);
    //         int skip = helper(prices, day + 1, canBuy);
    //         ans = Math.max(sell, skip);
    //     }
    //     return cache[day][canBuy] = ans;
    // }
}
