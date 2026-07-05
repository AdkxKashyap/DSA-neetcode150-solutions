class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int max = nums[0];
        int min = nums[0];

        for(int i = 1; i < n; i++) {
            int num = nums[i];
            int tmp = max;
            max = Math.max(num, Math.max(num * max, num * min));
            min = Math.min(num, Math.min(num * tmp, num * min));
            res = Math.max(res, max);
        }

        return res;
    }
}
