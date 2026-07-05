class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] cache = new int[amount + 1];
        Arrays.fill(cache, Integer.MAX_VALUE);

        cache[0] = 0;
        for(int amt = 1; amt <= amount; amt++) {
            for(int coin : coins) {
                if(amt >= coin) {
                    cache[amt] = Math.min(cache[amt], cache[amt - coin]);
                }
            }
            if(cache[amt] != Integer.MAX_VALUE) cache[amt] += 1;
        }
        return cache[amount] == Integer.MAX_VALUE ? -1 : cache[amount];
    }
}
