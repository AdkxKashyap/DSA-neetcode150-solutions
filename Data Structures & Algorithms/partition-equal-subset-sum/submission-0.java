class Solution {
    int n;
    public boolean canPartition(int[] nums) {
        int tot = 0;
        n = nums.length;
        for(int num : nums) {
            tot += num;
        }
        if(tot % 2 != 0) return false;
        int target = tot / 2;

        return helper(nums, target, 0);
    }

    private boolean helper(int[] nums, int tar, int idx) {
        if(idx == n) return tar == 0 ? true : false;

        for(int i = idx; i < n; i++) {
            boolean res = tar - nums[i] >= 0 ? helper(nums, tar - nums[i], i + 1) : false;
            if(res) return true;
        }
        return false;
    }
}
