class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        for(int i = 0; i <= k; i++) {
            int[] curr = Arrays.copyOf(cost, n);
            for(int[] flight : flights) {
                int st = flight[0];
                int end = flight[1];
                int c = flight[2];
                if(cost[st] != Integer.MAX_VALUE) {
                    curr[end] = Math.min(curr[end], cost[st] + c);
                }
            }
            cost = curr;
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}
