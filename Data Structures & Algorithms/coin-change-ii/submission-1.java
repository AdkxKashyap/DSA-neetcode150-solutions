class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] cache = new int[amount + 1];
        cache[0] = 1;
        for(int idx = 0; idx < n; idx++) {
            for(int amt = 1; amt <= amount; amt++) {
                if(amt >= coins[idx]) cache[amt] += cache[amt - coins[idx]];
            }
        }
        return cache[amount];
    }

    // private int helper(int[] coins, int amt, int idx) {
    //     if(amt == 0) return 1;
    //     if(idx >= coins.length) return 0;

    //     int ans = 0;
    //     for(int i = idx; i < coins.length; i++) {
    //         if(amt >= coins[i]) ans += helper(coins, amt - coins[i], i);
    //     }
    //     return ans;
    // }
}
