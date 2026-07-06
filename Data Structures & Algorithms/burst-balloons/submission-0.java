class Solution {
    public int maxCoins(int[] nums) {
        int N = nums.length;
        if(N == 0) return 0;
        int[] nums_ = new int[N + 2];
        int N_ = nums_.length;
        nums_[0] = 1;
        nums_[N_ - 1] = 1;
        System.arraycopy(nums, 0, nums_, 1, nums.length);
        Integer[][] cache = new Integer[N_][N_];
        return helper(nums_, 0, N_ - 1, cache);
    }
    private int helper(int[] nums, int start, int end, Integer[][] cache) {
        if(end - start == 1) return 0;
        if(cache[start][end] != null) return cache[start][end];
        int max = 0;
        for(int k = start + 1; k < end; k++) {
            int ncoins = nums[start] * nums[k] * nums[end];
            int ncoinsLeft = helper(nums, start, k, cache);
            int ncoinsRight = helper(nums, k, end, cache);
            int totCost = ncoins+ncoinsLeft+ncoinsRight;
            max = Math.max(max, totCost);
        }
        return cache[start][end] = max;
    }
}