class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for(int price : prices) {
            if(price > min) profit = Math.max(profit, price - min);
            min = Math.min(min, price);
        }
        return profit;
    }
}
