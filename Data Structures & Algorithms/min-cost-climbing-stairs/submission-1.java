class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n == 1) return cost[0];
        int prev = cost[0];
        int prev2prev = 0;
        
        for(int i = 1; i <= n; i++) {
            int c = i == n ? 0 : cost[i];
            int curr = c + Math.min(prev2prev, prev);
            prev2prev = prev;
            prev = curr;
        }
        return prev;
    }

}
