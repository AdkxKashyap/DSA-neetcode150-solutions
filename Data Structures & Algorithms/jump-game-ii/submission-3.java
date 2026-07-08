class Solution {
    public int jump(int[] nums) {
        // if(nums.length == 1) return 0;
        int maxReach = 0;
        int currReach = 0;
        int jump = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, nums[i] + i);

            if(i == currReach) {
                jump++;
                currReach = maxReach;
            }
        }
        return jump;
    }
}
