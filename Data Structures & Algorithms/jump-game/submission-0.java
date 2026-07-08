class Solution {
    public boolean canJump(int[] nums) {
        int currReach = nums[0];
        int nextReach = 0;

        for(int i = 0; i < nums.length; i++) {
            if(i > currReach) return false;
            nextReach = Math.max(nextReach, nums[i] + i);

            if(i == currReach) currReach = nextReach;
        }
        return true;
    }
}
