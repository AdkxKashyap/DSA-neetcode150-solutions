class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int comp = map.getOrDefault(target-nums[i], -1);
            if(comp > -1) return new int[]{comp, i};
            map.put(nums[i], i);
        }
        return null;
    }
}
