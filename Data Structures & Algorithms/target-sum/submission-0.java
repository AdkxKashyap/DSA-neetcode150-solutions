class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, 0);
    }

    private int helper(int[] nums, int target, int idx) {
        if(idx >= nums.length) return target == 0 ? 1 : 0;
        
        return helper(nums, target + nums[idx], idx + 1) + helper(nums, target - nums[idx], idx + 1);
    }
}
