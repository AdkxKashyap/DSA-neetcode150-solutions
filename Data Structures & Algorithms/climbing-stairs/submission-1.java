class Solution {
    public int climbStairs(int n) {
        int prev2prev = 1;
        int prev = 2;
        for(int i = 3; i <= n; i++) {
            int curr = prev + prev2prev;
            prev2prev = prev;
            prev = curr;
        }
        return n == 1 ? 1 : prev;
    }
}
