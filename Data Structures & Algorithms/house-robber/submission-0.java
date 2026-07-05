class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev2prev = 0;
        int prev = nums[0];
        for(int i = 1; i < n; i++) {
            int curr = Math.max(prev, nums[i] + prev2prev);
            prev2prev = prev;
            prev = curr;
        }
        return prev;
    }
}
