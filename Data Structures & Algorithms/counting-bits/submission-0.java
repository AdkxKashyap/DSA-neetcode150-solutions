class Solution {
    public int[] countBits(int n) {
        int[] cache = new int[n + 1];
        for(int i = 1; i <= n; i++) {

            cache[i] = cache[i >>> 1] + (1 & i);
        }
        return cache;
    }
}
