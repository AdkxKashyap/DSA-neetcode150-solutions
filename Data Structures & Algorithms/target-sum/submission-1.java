class Solution {
    int[][] cache;
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        cache = new int[n][2001];

        for(int ch[] : cache) Arrays.fill(ch, -1);
        return helper(nums, target, 0);
    }

    private int helper(int[] nums, int target, int idx) {
        if(idx >= nums.length) return target == 0 ? 1 : 0;
        int key = target + 1000;
        if(cache[idx][key] != -1) return cache[idx][key];
        return cache[idx][key] = helper(nums, target + nums[idx], idx + 1) + helper(nums, target - nums[idx], idx + 1);
    }
}
