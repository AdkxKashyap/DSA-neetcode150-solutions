class Solution {
    public int rob(int[] nums) {
        if(nums == null) return -1;
        int n = nums.length;
        if(n == 1) return nums[0];
        return Math.max(findMax(nums ,0, n-1), findMax(nums, 1, n));
    }

    private int findMax(int[] nums, int start, int end) {
        int prev2prev = 0;
        int prev = nums[start];
        for(int i = start + 1; i < end; i++) {
            int curr = Math.max(prev, nums[i] + prev2prev);
            prev2prev = prev;
            prev = curr;
        }
        return prev;
    }
}
