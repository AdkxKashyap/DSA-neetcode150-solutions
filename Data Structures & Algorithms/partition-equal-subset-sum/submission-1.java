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
        boolean[] cache = new boolean[target + 1];
        cache[0] = true;
        for(int idx = n - 1; idx >= 0; idx--) {
            for(int amt = target; amt >= nums[idx]; amt--) {
                cache[amt] = cache[amt] || cache[amt - nums[idx]];
            }
            if(cache[target]) return true;
        }

        return false;
    }
}
